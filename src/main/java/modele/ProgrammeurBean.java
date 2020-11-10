package modele;

import java.sql.Date;

/**
 * Classe gérant less programmeurs
 */
public class ProgrammeurBean{
    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String responsable;  
    private String hobby;
    private Date date_naiss;
    private Date date_emb;
    
    public ProgrammeurBean(){
    }

    /**
     * Renvoie une chaîne de caractère composée des champs du ProgrammeurBean
     * @return une chaîne de caractère composée des informations du ProgrammeurBean
     */
    @Override
    public String toString(){
        return this.getMatricule() + " " + this.getNom() + " " + this.getPrenom() + " " 
            + this.getAdresse() + " " + this.getPseudo() + " " + this.getResponsable() + " " 
            + this.getHobby() + " " + this.getDate_naiss() + " " + this.getDate_emb() + "\n";
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

    /**
     * Récupère le pseudo du ProgrammeurBean
     * @return pseudo, le pseudo du ProgrammeurBean
     */
    public String getPseudo(){
        return pseudo;
    }
    
    /**
     * Affecte un pseudo au ProgrammeurBean
     * @param pseudo  Pseudo à affecter au ProgrammeurBean
     */
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
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

    /**
     * Récupère le responsable du ProgrammeurBean
     * @return responsable, le responsable du ProgrammeurBean
     */
    public String getResponsable(){
        return responsable;
    }

    /**
     * Affecte un responsable au ProgrammeurBean
     * @param responsable  Responsable à affecter au ProgrammeurBean
     */
    public void setResponsable(String responsable){
        this.responsable = responsable;
    }

    /**
     * Récupère le hobby du ProgrammeurBean
     * @return hobby, le hobby du ProgrammeurBean
     */
    public String getHobby(){
        return hobby;
    }

    /**
     * Affecte un hobby au ProgrammeurBean
     * @param hobby  Hobby à affecter au ProgrammeurBean
     */
    public void setHobby(String hobby){
        this.hobby = hobby;
    }

    /**
     * Récupère la date de naissance du ProgrammeurBean
     * @return date_naiss, la date de naissance du ProgrammeurBean
     */
    public Date getDate_naiss(){
        return date_naiss;
    }

    /**
     * Affecte une date de naissance au ProgrammeurBean
     * @param date_naiss  Date de naissance à affecter au programmeurBean
     */
    public void setDate_naiss(Date date_naiss){
        this.date_naiss = date_naiss;
    }

    /**
     * Récupère la date d'embauche du ProgrammeurBean
     * @return date_emb, la date d'embauche du ProgrammeurBean
     */
    public Date getDate_emb(){
        return date_emb;
    }

    /**
     * Affecte une date d'embauche au ProgrammeurBean
     * @param date_emb  Date d'embauche à affecter au programmeurBean
     */
    public void setDate_emb(Date date_emb){
        this.date_emb = date_emb;
    }
}