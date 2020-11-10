package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constantes;

/**
 * Classe contenant les méthodes de transaction avec la base de données
 * 
 */
public class ActionsBDImpl implements ActionsBD{
    private Connection dbConn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<ProgrammeurBean> listeProgrammeurs;
    private ProgrammeurBean prog;
    private int erreur;

    /**
     * Constructeur initialisant la connexion
     */
    public ActionsBDImpl() {
        try {
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
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
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return rs;
    }

    /**
     * Récupère toutes les informations d'un programmeur 
     * et retourne une liste de l'ensemble des programmeurs
     * @return listeProgrammeurs, une ArrayList contenant de la liste des programmeurs
     */
    @Override
    public ArrayList getProgrammeurs() {
        rs = this.getResultSet(Constantes.SELECT_ALL);
        listeProgrammeurs = new ArrayList<>();
        try {
            while (rs.next()) {
                prog = new ProgrammeurBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDate_naiss(rs.getDate("DATE_NAISS"));
                prog.setDate_emb(rs.getDate("DATE_EMB"));
                listeProgrammeurs.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return listeProgrammeurs;
    }

    /**
     * Recherche un progammeur via son matricule, 
     * récupère toutes les informations de ce programmeur
     * et retourne ce programmeur sous la forme d'un ProgrammeurBean 
     * @param matricule Matricule saisi par l'utilisateur pour lancer la recherche
     * @return prog, un ProgrammeurBean
     */
    @Override
    public ProgrammeurBean getProgrammeur(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.SELECT_UNIQUE);
            pstmt.setString(1, matricule);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                prog = new ProgrammeurBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDate_naiss(rs.getDate("DATE_NAISS"));
                prog.setDate_emb(rs.getDate("DATE_EMB"));
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return prog;
    }

    /**
     * Construit la chaîne de caractères composée les informations des programmeurs
     * @return listeProg, la chaîne de caractère regroupant les informations des programmeurs
     */
    @Override
    public String afficherProgrammeurs() {
        String listeProg = "";
        listeProgrammeurs = this.getProgrammeurs();
        for (ProgrammeurBean progr : listeProgrammeurs) {
            listeProg = listeProg + progr;
        }
        return listeProg;
    }
    
    /**
     * Modifie les données d'un programmeur
     * @param matricule Nouveau matricule du programmeur
     * @param nom   Nouveau nom du programmeur
     * @param prenom    Nouveau prénom du programmeur
     * @param adresse    Nouvelle adresse du programmeur
     * @param pseudo    Nouveau pseudo du programmeur
     * @param responsable    Nouveau responsable du programmeur
     * @param hobby    Nouveau hobby du programmeur
     * @param Jdate_naiss    Nouveau jour de naissance du programmeur
     * @param Mdate_naiss    Nouveau mois de naissance du programmeur
     * @param Adate_naiss    Nouvelle année de naissance du programmeur
     * @param Jdate_emb    Nouveau jour d'embauche du programmeur
     * @param Mdate_emb    Nouveau mois d'embauche du programmeur
     * @param Adate_emb    Nouvelle année d'embauche du programmeur
     * @return erreur, 0 si la modication est réussit et 1 sinon
     */
    @Override
    public int modifierProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb){
        try {
            String date_naiss = Adate_naiss + "-" + Mdate_naiss + "-" + Jdate_naiss;
            String date_emb = Adate_emb + "-" + Mdate_emb + "-" + Jdate_emb;
            pstmt = dbConn.prepareStatement(Constantes.UPDATE_UNIQUE);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, adresse);
            pstmt.setString(4, pseudo);
            pstmt.setString(5, responsable);
            pstmt.setString(6, hobby);
            pstmt.setString(7, date_naiss);
            pstmt.setString(8, date_emb);            
            pstmt.setString(9, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur= 1 ;
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }
    
    /**
     * Supprime de la base de données un programmeur identifié par son matricule
     * @param matricule Matricule permettant d'indentifié le programmeur
     * @return erreur, 0 si la modication est réussit et 1 sinon
     */
    @Override
    public int supprimerProgrammeur(String matricule){
        try {
            pstmt = dbConn.prepareStatement(Constantes.DELETE_UNIQUE);
            pstmt.setString(1, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }
    
    /**
     * Ajoute un programmeur à la base de données
     * @param matricule Matricule du programmeur
     * @param nom   Nom du programmeur
     * @param prenom    Prénom du programmeur
     * @param adresse    Adresse du programmeur
     * @param pseudo    Pseudo du programmeur
     * @param responsable    Responsable du programmeur
     * @param hobby    Hobby du programmeur
     * @param Jdate_naiss    Jour de naissance du programmeur
     * @param Mdate_naiss    Mois de naissance du programmeur
     * @param Adate_naiss    Année de naissance du programmeur
     * @param Jdate_emb    Jour d'embauche du programmeur
     * @param Mdate_emb    Mois d'embauche du programmeur
     * @param Adate_emb    Année d'embauche du programmeur
     * @return erreur, 0 si la modication est réussit et 1 sinon
     */
    @Override
    public int ajouterProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb){
        try {
            String date_naiss = Adate_naiss + "-" + Mdate_naiss + "-" + Jdate_naiss;
            String date_emb = Adate_emb + "-" + Mdate_emb + "-" + Jdate_emb;
            pstmt = dbConn.prepareStatement(Constantes.INSERT_UNIQUE);          
            pstmt.setString(1, matricule);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, adresse);
            pstmt.setString(5, pseudo);
            pstmt.setString(6, responsable);
            pstmt.setString(7, hobby);
            pstmt.setString(8, date_naiss);
            pstmt.setString(9, date_emb);  
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}