import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;
import vue.Vue;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

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

    @Test
    public void testDisplaySupprimer() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();
        ihm.display();
        ihm.displaySupprimer();

        final Field field = ihm.getClass().getSuperclass().getDeclaredField("paneGenerique");
        field.setAccessible(true);

        JPanel paneGeneriqueTest = new JPanel();
        paneGeneriqueTest.setLayout(null);

        JButton btnRechercherTest = new JButton("Rechercher");
        JButton btnReinitialiserTest = new JButton("Réinitialiser");
        JButton btnValiderEcranSupprimerTest = new JButton("Valider");
        JButton btnAnnulerTest = new JButton("Annuler");
        paneGeneriqueTest.add(btnRechercherTest);
        paneGeneriqueTest.add(btnReinitialiserTest);
        paneGeneriqueTest.add(btnValiderEcranSupprimerTest);
        paneGeneriqueTest.add(btnAnnulerTest);

        ArrayList<JComponent> listComponentsTest = new ArrayList<>();
        JLabel labelMatriculeTest = new JLabel("Matricule");
        JTextField champMatriculeTest = new JTextField();

        listComponentsTest.add(labelMatriculeTest);
        listComponentsTest.add(champMatriculeTest);
        listComponentsTest.add(new JLabel("Nom"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Prénom"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Adresse"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Pseudo"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Responsable"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Hobby"));
        listComponentsTest.add(new JTextField());
        listComponentsTest.add(new JLabel("Date de naissance"));
        listComponentsTest.add(new JTextField("jour"));
        Object[] mois = new Object[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        listComponentsTest.add(new JComboBox(mois));
        listComponentsTest.add(new JTextField("année"));
        listComponentsTest.add(new JLabel("Date d'embauche"));
        listComponentsTest.add(new JTextField("jour"));
        listComponentsTest.add(new JComboBox(mois));
        listComponentsTest.add(new JTextField("année"));
        //ihm.addTo(paneGeneriqueTest, listComponentsTest);
        ihm.disableAll(listComponentsTest);
        labelMatriculeTest.setEnabled(true);
        champMatriculeTest.setEnabled(true);

        btnValiderEcranSupprimerTest.addActionListener(ihm);
        btnAnnulerTest.addActionListener(ihm);
        ihm.setButtonBounds(btnRechercherTest, 85);
        ihm.setButtonBounds(btnReinitialiserTest, 190);
        ihm.setButtonBounds(btnValiderEcranSupprimerTest, 295);
        ihm.setButtonBounds(btnAnnulerTest, 400);

        Assert.assertEquals("paneGenerique didn't match.", paneGeneriqueTest.toString(), field.get(ihm).toString());
    }
}
