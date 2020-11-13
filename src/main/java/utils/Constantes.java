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

    // For testing purposes
    public static final String TESTADDPROG_MATR = "21";
    public static final String TESTADDPROG_NOM = "hello";
    public static final String TESTADDPROG_PRENOM = "world";
    public static final String TESTADDPROG_ADR = "11 rue de Paris";
    public static final String TESTADDPROG_PSEUDO = "hello-chan";
    public static final String TESTADDPROG_RESP = "JAA";
    public static final String TESTADDPROG_HOBBY = "coding";
    public static final String TESTADDPROG_DATNAISS = "1967-11-11";
    public static final String TESTADDPROG_DATEMP = "1997-11-11";

    public static final String TESTUPDPROG_PSEUDO = "world-chan";
    public static final String TESTUPDPROG_RESP = "Cherel";
    public static final String TESTUPDPROG_DATEMP = "2017-12-13";
}