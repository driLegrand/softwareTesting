import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import utils.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    @Mock
    private Connection dbConn;

    @Mock
    private PreparedStatement pstmt;

    @Before
    public void setUp() {
        try{
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    @Test
    public void testAjouterProgrammeur() throws SQLException
    {
        Assert.assertNotNull(dbConn);
        pstmt = dbConn.prepareStatement(Constantes.INSERT_UNIQUE);

        pstmt.setString(1, Constantes.TESTADDPROG_MATR);
        pstmt.setString(2, Constantes.TESTADDPROG_NOM);
        pstmt.setString(3, Constantes.TESTADDPROG_PRENOM);
        pstmt.setString(4, Constantes.TESTADDPROG_ADR);
        pstmt.setString(5, Constantes.TESTADDPROG_PSEUDO);
        pstmt.setString(6, Constantes.TESTADDPROG_RESP);
        pstmt.setString(7, Constantes.TESTADDPROG_HOBBY);
        pstmt.setString(8, Constantes.TESTADDPROG_DATNAISS);
        pstmt.setString(9, Constantes.TESTADDPROG_DATEMP);

        int isSuccessful = pstmt.executeUpdate();
        Assert.assertEquals(1, isSuccessful);
    }

    @Test
    public void testModifierProgrammeur() throws SQLException
    {
        Assert.assertNotNull(dbConn);
        pstmt = dbConn.prepareStatement(Constantes.UPDATE_UNIQUE);

        pstmt.setString(1, Constantes.TESTADDPROG_NOM);
        pstmt.setString(2, Constantes.TESTADDPROG_PRENOM);
        pstmt.setString(3, Constantes.TESTADDPROG_ADR);
        pstmt.setString(4, Constantes.TESTUPDPROG_PSEUDO);
        pstmt.setString(5, Constantes.TESTUPDPROG_RESP);
        pstmt.setString(6, Constantes.TESTADDPROG_HOBBY);
        pstmt.setString(7, Constantes.TESTADDPROG_DATNAISS);
        pstmt.setString(8, Constantes.TESTUPDPROG_DATEMP);
        pstmt.setString(9, Constantes.TESTADDPROG_MATR);

        int isSuccessful = pstmt.executeUpdate();
        Assert.assertNotEquals(0, isSuccessful);
    }

    @Test
    public void testSupprimerProgrammeur() throws SQLException
    {
        Assert.assertNotNull(dbConn);
        pstmt = dbConn.prepareStatement(Constantes.DELETE_UNIQUE);

        pstmt.setString(1, Constantes.TESTADDPROG_MATR);

        int isSuccessful = pstmt.executeUpdate();
        Assert.assertNotEquals(0, isSuccessful);
    }
}
