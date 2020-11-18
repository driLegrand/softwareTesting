import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;
import utils.Constantes;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    public ActionsBDImpl conn = new ActionsBDImpl();

    @Test
    public void testFermerRessources() {
        ActionsBDImpl tested = new ActionsBDImpl();
        try{

            tested.fermerRessources();
            final Field field = tested.getClass().getDeclaredField("dbConn");
            field.setAccessible(true); // changethe field dbConn in ActionsBDImpl to public

            Connection dbConn = (Connection) field.get(tested); //getter of dbConn

            Assert.assertNull(dbConn);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, exception);
        }

    }

    @Test
    public void testGetProgrammeurs() {
        ActionsBDImpl tested = new ActionsBDImpl();
        Assert.assertTrue(tested.getProgrammeurs() instanceof ArrayList);
    }

    @Test
    public void testGetResultSet() {
        String query = Constantes.SELECT_ALL;
        ActionsBDImpl tested = new ActionsBDImpl();
        Assert.assertTrue(tested.getResultSet(query) instanceof ResultSet);
    }
}
