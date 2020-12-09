package utils;

/**
 * Classe rassemblant toutes les constantes utiisées dans le programme
 */
public class Constantes_b {
    public static final String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7375737";
    public static final String USER = "sql7375737";
    public static final String MDP = "ICxuurfGJu";
    public static final String SELECT_ALL = "SELECT * FROM CONTRAT";
    public static final String SELECT_UNIQUE = "SELECT * FROM CONTRAT WHERE MATRICULE = ?";
    public static final String UPDATE_UNIQUE = "UPDATE CONTRAT SET NOM = ?, PRENOM = ?, ADRESSE = ?, FOLLOW_UP = ?, ENERGY_METER = ? WHERE MATRICULE = ?";
    public static final String DELETE_UNIQUE = "DELETE FROM CONTRAT WHERE MATRICULE = ?";
    public static final String INSERT_UNIQUE = "INSERT INTO CONTRAT (MATRICULE, NOM, PRENOM, ADRESSE, FOLLOW_UP, ENERGY_METER) VALUES (?, ?, ?, ?, ?, ?)";

    
    // For testing purposes
    public static final String TESTADDPROG_MATR = "0001001001";
    public static final String TESTADDPROG_NOM = "Smith";
    public static final String TESTADDPROG_PRENOM = "John";
    public static final String TESTADDPROG_ADR = "1 rue de Paris";
    public static final String TESTADDPROG_FOLLOW_UP = "standard";
    public static final String TESTADDPROG_ENERGY_METER = "9001";

    public static final String TESTUPDPROG_FOLLOW_UP = "monthly";
    public static final String TESTUPDPROG_ENERGY_METER = "9500";

}
