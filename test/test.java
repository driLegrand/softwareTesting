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

    @Test
    public void testDisplayAjouter() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();
        ihm.display();
        ihm.displayAjouter();

        final Field field = ihm.getClass().getSuperclass().getDeclaredField("paneGenerique");
        field.setAccessible(true);

        JPanel paneGeneriqueTest = new JPanel();
        paneGeneriqueTest.setLayout(null);

        JButton btnRechercherTest = new JButton("Rechercher");
        JButton btnReinitialiserTest = new JButton("Réinitialiser");
        JButton btnValiderEcranAjouterTest = new JButton("Valider");
        JButton btnAnnulerTest = new JButton("Annuler");
        paneGeneriqueTest.add(btnRechercherTest);
        paneGeneriqueTest.add(btnReinitialiserTest);
        paneGeneriqueTest.add(btnValiderEcranAjouterTest);
        paneGeneriqueTest.add(btnAnnulerTest);
        btnRechercherTest.setEnabled(false);
        btnReinitialiserTest.addActionListener(ihm);
        btnValiderEcranAjouterTest.addActionListener(ihm);
        btnAnnulerTest.addActionListener(ihm);
        ihm.setButtonBounds(btnRechercherTest, 85);
        ihm.setButtonBounds(btnReinitialiserTest, 190);
        ihm.setButtonBounds(btnValiderEcranAjouterTest, 295);
        ihm.setButtonBounds(btnAnnulerTest, 400);

        Assert.assertEquals("paneGenerique didn't match.", paneGeneriqueTest.toString(), field.get(ihm).toString());
    }
}
