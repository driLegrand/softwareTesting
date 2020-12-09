package utils;

/**
 * Classe rassemblant toutes les constantes utilisées dans le programme
 */
public class Constantes{
    public static final String OCCUPATION = "Programmeur";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/TP2ST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String MDP = "mysql";
    public static final String SELECT_ALL = "SELECT * FROM PROGRAMMEUR";
    public static final String SELECT_UNIQUE = "SELECT * FROM PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String UPDATE_UNIQUE = "UPDATE PROGRAMMEUR SET NOM = ?, PRENOM = ?, ADRESSE = ?, PSEUDO = ?, RESPONSABLE = ?, HOBBY = ?, DATE_NAISS = ?, DATE_EMB = ? WHERE MATRICULE = ?";
    public static final String DELETE_UNIQUE = "DELETE FROM PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String INSERT_UNIQUE = "INSERT INTO PROGRAMMEUR (MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}