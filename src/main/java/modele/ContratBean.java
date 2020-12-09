package modele;

import java.sql.Date;

/**
 * Classe gérant less programmeurs
 */
public class ContratBean {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String followUp;
    private String energyMeter;

    public ContratBean(){
    }

    /**
     * Renvoie une chaîne de caractère composée des champs du ProgrammeurBean
     * @return une chaîne de caractère composée des informations du ProgrammeurBean
     */
    @Override
    public String toString(){
        return this.getMatricule() + " " + this.getNom() + " " + this.getPrenom() + " " 
            + this.getAdresse() + " " + this.getFollowUp() + " " + this.getEnergyMeter() + " "
                + "\n";
    }
    
    /**
     * Récupère le matricule du ProgrammeurBean
     * @return matricule, le matricule du ProgrammeurBean
     */
    public String getMatricule(){
        return matricule;
    }

    /**
     * Affecte un matricule au ProgrammeurBean
     * @param matricule  Matricule à affecter au ProgrammeurBean
     */
    public void setMatricule(String matricule){
        this.matricule = matricule;
    }
    
    /**
     * Récupère le nom du ProgrammeurBean
     * @return nom, le nom du ProgrammeurBean
     */
    public String getNom(){
        return nom;
    }

    /**
     * Affecte un nom au ProgrammeurBean
     * @param nom  Nom à affecter au ProgrammeurBean
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Récupère le prénom du ProgrammeurBean
     * @return prenom, le prénom du ProgrammeurBean
     */
    public String getPrenom(){
        return prenom;
    }

    /**
     * Affecte un prénom au ProgrammeurBean
     * @param prenom  Prénom à affecter au ProgrammeurBean
     */
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getFollowUp(){
        return followUp;
    }

    public void setFollowUp(String followUp){
        this.followUp = followUp;
    }
 
    /**
     * Récupère l'adresse du ProgrammeurBean
     * @return adresse, l'adresse du ProgrammeurBean
     */
    public String getAdresse(){
        return adresse;
    }

    /**
     * Affecte une adresse au ProgrammeurBean
     * @param adresse  Adresse à affecter au ProgrammeurBean
     */
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getEnergyMeter(){
        return energyMeter;
    }

    public void setEnergyMeter(String energyMeter){
        this.energyMeter = energyMeter;
    }
}