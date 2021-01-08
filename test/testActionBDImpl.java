import modele.ActionsBDImpl;
import modele.ProgrammeurBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import utils.Constantes;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(MockitoJUnitRunner.class)
public class testActionBDImpl {
    @Mock
    private Connection con;

    @Mock
    private PreparedStatement pstmt;

    @Mock
    private ResultSet rs;

    private ProgrammeurBean p;


    @Before
    public void initTest() throws SQLException {
        Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(pstmt);
        Mockito.when(con.createStatement()).thenReturn(pstmt);
        Mockito.when(pstmt.executeQuery(Mockito.any(String.class))).thenReturn(rs);
        Mockito.when(con.createStatement()).thenReturn(pstmt);

        p = new ProgrammeurBean("1", "testLastName", "testFirstName", "testAddress", "testPseudo", "testResponsable", "testHobby", java.sql.Date.valueOf("2010-01-08"), java.sql.Date.valueOf("2020-05-01"));
        rs.insertRow();
        Mockito.when(rs.getString("MATRICULE")).thenReturn("1");
        Mockito.when(rs.getString("PRENOM")).thenReturn("testFirstName");
        Mockito.when(rs.getString("NOM")).thenReturn("testLastName");
        Mockito.when(rs.getString("ADRESSE")).thenReturn("testAddress");
        Mockito.when(rs.getString("PSEUDO")).thenReturn("testPseudo");
        Mockito.when(rs.getString("RESPONSABLE")).thenReturn("testResponsable");
        Mockito.when(rs.getString("HOBBY")).thenReturn("testHobby");
        Mockito.when(rs.getDate("DATE_NAISS")).thenReturn(java.sql.Date.valueOf("2010-01-08"));
        Mockito.when(rs.getDate("DATE_EMB")).thenReturn(java.sql.Date.valueOf("2020-05-01"));
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
    }

    @Test
    public void testConnectionBDD()
    {
        String connect;
        try {
            DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
            connect = "Connection successful";
        } catch (SQLException sqle) {
            connect = "Connection failed";
        }
        Assert.assertEquals("Can't connect to the database", "Connection successful",connect);
    }

    @Test
    public void creerProgrammeur()
    {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        bdd.ajouterProgrammeur(p.getMatricule(), p.getNom(), p.getPrenom(), p.getAdresse(), p.getPseudo(), p.getResponsable(), p.getHobby(), "08", "01", "2010", "01", "05", "2020");
    }

    @Test
    public void modifierProgrammeur() {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        bdd.modifierProgrammeur(p.getMatricule(), p.getNom(), p.getPrenom(), p.getAdresse(), p.getPseudo(), p.getResponsable(), p.getHobby(), "08", "01", "2010", "01", "05", "2020");
    }

    @Test
    public void supprimerProgrammeur() {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        bdd.supprimerProgrammeur(p.getMatricule());
    }

    /**
     * Test to check closure of the Database
     */
    @Test
    public void testFermerRessources() {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        try{
            bdd.fermerRessources();
            final Field field = bdd.getClass().getDeclaredField("dbConn");
            field.setAccessible(true); // change the field dbConn in ActionsBDImpl to public

            Connection dbConn = (Connection) field.get(bdd); //getter of dbConn

            Assert.assertNull(dbConn);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, exception);
        }

    }

    /**
     * Test to check if we retrieve list of programmers from Database
     */
    @Test
    public void getProgrammeurs() {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        ProgrammeurBean pb = (ProgrammeurBean) bdd.getProgrammeurs().get(0);
        Assert.assertEquals(p.getAdresse(), pb.getAdresse());
    }

    /**
     * Test to check afficherProgrammeurs
     */
    @Test
    public void afficherProgrammeurs() {
        ActionsBDImpl bdd = new ActionsBDImpl(con);
        String result = bdd.afficherProgrammeurs();
        Assert.assertEquals(p.toString(), result); //Check that the returned String is as expected
    }
}
