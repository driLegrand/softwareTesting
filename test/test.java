import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;
import vue.Vue;

import javax.swing.*;
import java.lang.reflect.Field;

public class test {

    public ActionsBDImpl conn = new ActionsBDImpl();

    @Test
    public void stubbingReturnValue() {
        Assert.assertTrue(true);
    }

    @Test
    public void testAddProgrammer() {
        Assert.assertNotEquals(0, conn.getProgrammeurs().size());
    }

    @Test
    public void testDisplayAfficherTous() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();
        ihm.displayAfficherTous();

        final Field field = ihm.getClass().getSuperclass().getDeclaredField("paneAfficher");
        field.setAccessible(true);

        final Field field2 = ihm.getClass().getSuperclass().getDeclaredField("zoneAffichageProgrammeurs");
        field2.setAccessible(true);

        JPanel paneAfficherTest = new JPanel();
        JTextArea zoneAffichageProgrammeursTest = new JTextArea(10, 70);
        JScrollPane scrollTest = new JScrollPane(zoneAffichageProgrammeursTest);
        paneAfficherTest.add(scrollTest);

        Assert.assertEquals("paneAfficher didn't match.", paneAfficherTest.toString(), field.get(ihm).toString());
        Assert.assertEquals("zoneAffichageProgrammeurs didn't match.", zoneAffichageProgrammeursTest.toString(), field2.get(ihm).toString());
    }
}
