package utils;

/**
 * Classe rassemblant toutes les constantes utiisées dans le programme
 */
public class Constantes{
    public static final String OCCUPATION = "Programmeur";
    public static final String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7375737";
    public static final String USER = "sql7375737";
    public static final String MDP = "ICxuurfGJu";
    public static final String SELECT_ALL = "SELECT * FROM PROGRAMMEUR";
    public static final String SELECT_UNIQUE = "SELECT * FROM PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String UPDATE_UNIQUE = "UPDATE PROGRAMMEUR SET NOM = ?, PRENOM = ?, ADRESSE = ?, PSEUDO = ?, RESPONSABLE = ?, HOBBY = ?, DATE_NAISS = ?, DATE_EMB = ? WHERE MATRICULE = ?";
    public static final String DELETE_UNIQUE = "DELETE FROM PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String INSERT_UNIQUE = "INSERT INTO PROGRAMMEUR (MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}