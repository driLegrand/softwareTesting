package modele;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Interface contenant les déclaratios des méthodes d'échanges avec la BDD
 */
public interface ActionsBD_b {
    public ResultSet getResultSet(String req);
    public ArrayList getContrats();
    public ContratBean getContrat(String matricule);
    public String afficherContrats();
    public int modifierContrat(String matricule, String nom, String prenom, String adresse, String followUp, String energyMeter);
    public int supprimerContrat(String matricule);
    public int ajouterContrat(String matricule, String nom, String prenom, String adresse, String followUp, String energyMeter);
    public void fermerRessources();
}