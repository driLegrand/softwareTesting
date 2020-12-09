package modele;

import utils.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe contenant les méthodes de transaction avec la base de données
 * 
 */
public class ActionsBDImpl_b implements ActionsBD_b{
    private Connection dbConn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<ContratBean> listeContrats;
    private ContratBean prog;
    private int erreur;

    /**
     * Constructeur initialisant la connexion
     */
    public ActionsBDImpl_b() {
        try {
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    /**
     * Lance la requête passée en paramètre et retourne le ResultSet correspondant à cette requête
     * @param req   Requête SQL que l'on souhaite exécuter
     * @return rs, un ResultSet
     */
    @Override
    public ResultSet getResultSet(String req) {
        try {
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(req);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return rs;
    }

    @Override
    public ArrayList getContrats() {
        rs = this.getResultSet(Constantes.SELECT_ALL);
        listeContrats = new ArrayList<>();
        try {
            while (rs.next()) {
                prog = new ContratBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setFollowUp(rs.getString("FOLLOW_UP"));
                prog.setEnergyMeter(rs.getString("ENERGY_METER"));
                listeContrats.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return listeContrats;
    }

    @Override
    public ContratBean getContrat(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.SELECT_UNIQUE);
            pstmt.setString(1, matricule);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                prog = new ContratBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setFollowUp(rs.getString("FOLLOW_UP"));
                prog.setEnergyMeter(rs.getString("ENERGY_METER"));
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return prog;
    }

    @Override
    public String afficherContrats() {
        String listeProg = "";
        listeContrats = this.getContrats();
        for (ContratBean progr : listeContrats) {
            listeProg = listeProg + progr;
        }
        return listeProg;
    }

    @Override
    public int modifierContrat(String matricule, String nom, String prenom, String adresse, String followUp, String energyMeter) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.UPDATE_UNIQUE);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, adresse);
            pstmt.setString(4, followUp);
            pstmt.setString(5, energyMeter);
            pstmt.setString(6, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur= 1 ;
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }

    @Override
    public int supprimerContrat(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.DELETE_UNIQUE);
            pstmt.setString(1, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }

    @Override
    public int ajouterContrat(String matricule, String nom, String prenom, String adresse, String followUp, String energyMeter) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.INSERT_UNIQUE);
            pstmt.setString(1, matricule);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, adresse);
            pstmt.setString(5, followUp);
            pstmt.setString(6, energyMeter);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }

    /**
     * Libère les ressources liées à la base de données
     */
    @Override
    public void fermerRessources() {
        if (dbConn != null) {
            try {
                dbConn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                dbConn = null;
            } catch (SQLException ex) {
                Logger.getLogger(ActionsBDImpl_b.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}