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
    public void testDisplay() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();
        ihm.display();

        final Field field = ihm.getClass().getSuperclass().getDeclaredField("paneGenerique");
        field.setAccessible(true);


        JPanel paneGeneriqueTest = new JPanel();

        JLabel labelMatriculeTest = new JLabel("Matricule");
        JTextField champMatriculeTest = new JTextField();
        JLabel labelNomTest = new JLabel("Nom");
        JTextField champNomTest = new JTextField();
        JLabel labelPrenomTest = new JLabel("Prénom");
        JTextField champPrenomTest = new JTextField();
        JLabel labelAdresseTest = new JLabel("Adresse");
        JTextField champAdresseTest = new JTextField();
        JLabel labelPseudoTest = new JLabel("Pseudo");
        JTextField champPseudoTest = new JTextField();
        JLabel labelResponsableTest = new JLabel("Responsable");
        JTextField champResponsableTest = new JTextField();
        JLabel labelHobbyTest = new JLabel("Hobby");
        JTextField champHobbyTest = new JTextField();
        JLabel labelDate_naissTest = new JLabel("Date de naissance");
        JTextField champJourDate_naissTest = new JTextField("jour");
        Object[] moisTest = new Object[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        JComboBox comboMoisDate_naissTest = new JComboBox(moisTest);
        JTextField champAnneeDate_naissTest = new JTextField("année");
        JLabel labelDate_embTest = new JLabel("Date d'embauche");
        JTextField champJourDate_embTest = new JTextField("jour");
        JComboBox comboMoisDate_embTest = new JComboBox(moisTest);
        JTextField champAnneeDate_embTest = new JTextField("année");

        ArrayList<JComponent> listComponentsTest = new ArrayList<>();

        listComponentsTest = new ArrayList<>();
        listComponentsTest.add(labelMatriculeTest);
        listComponentsTest.add(champMatriculeTest);
        listComponentsTest.add(labelNomTest);
        listComponentsTest.add(champNomTest);
        listComponentsTest.add(labelPrenomTest);
        listComponentsTest.add(champPrenomTest);
        listComponentsTest.add(labelAdresseTest);
        listComponentsTest.add(champAdresseTest);
        listComponentsTest.add(labelPseudoTest);
        listComponentsTest.add(champPseudoTest);
        listComponentsTest.add(labelResponsableTest);
        listComponentsTest.add(champResponsableTest);
        listComponentsTest.add(labelHobbyTest);
        listComponentsTest.add(champHobbyTest);
        listComponentsTest.add(labelDate_naissTest);
        listComponentsTest.add(champJourDate_naissTest);
        listComponentsTest.add(comboMoisDate_naissTest);
        listComponentsTest.add(champAnneeDate_naissTest);
        listComponentsTest.add(labelDate_embTest);
        listComponentsTest.add(champJourDate_embTest);
        listComponentsTest.add(comboMoisDate_embTest);
        listComponentsTest.add(champAnneeDate_embTest);

        ihm.addTo(paneGeneriqueTest, listComponentsTest);

        paneGeneriqueTest.setLayout(null);

        ihm.setFieldBounds(labelMatriculeTest, 10, 10, 80);
        ihm.setFieldBounds(champMatriculeTest, 70, 10, 100);
        ihm.setFieldBounds(labelNomTest, 40, 60, 80);
        ihm.setFieldBounds(champNomTest, 140, 60, 100);
        ihm.setFieldBounds(labelPrenomTest, 260, 60, 80);
        ihm.setFieldBounds(champPrenomTest, 390, 60, 100);
        ihm.setFieldBounds(labelAdresseTest, 40, 90, 80);
        ihm.setFieldBounds(champAdresseTest, 140, 90, 100);
        ihm.setFieldBounds(labelPseudoTest, 260, 90, 80);
        ihm.setFieldBounds(champPseudoTest, 390, 90, 100);
        ihm.setFieldBounds(labelResponsableTest, 40, 120, 80);
        ihm.setFieldBounds(champResponsableTest, 140, 120, 100);
        ihm.setFieldBounds(labelDate_naissTest, 260, 120, 100);
        ihm.setFieldBounds(champJourDate_naissTest, 390, 120, 50);
        ihm.setFieldBounds(comboMoisDate_naissTest, 460, 120, 40);
        ihm.setFieldBounds(champAnneeDate_naissTest, 520, 120, 60);
        ihm.setFieldBounds(labelHobbyTest, 40, 150, 80);
        ihm.setFieldBounds(champHobbyTest, 140, 150, 100);
        ihm.setFieldBounds(labelDate_embTest, 260, 150, 120);
        ihm.setFieldBounds(champJourDate_embTest, 390, 150, 100);
        ihm.setFieldBounds(champJourDate_embTest, 390, 150, 50);
        ihm.setFieldBounds(comboMoisDate_embTest, 460, 150, 40);
        ihm.setFieldBounds(champAnneeDate_embTest, 520, 150, 60);


        Assert.assertEquals("paneGenerique didn't match.", paneGeneriqueTest.toString(), field.get(ihm).toString());
    }

    @Test
    public void testSetButtonBounds() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();
        ihm.display();
        final Field field = ihm.getClass().getDeclaredField("btnRechercher");
        field.setAccessible(true);

        JButton btnRechercher = (JButton) field.get(ihm);
        btnRechercher = new JButton("Rechercher");
        ihm.setButtonBounds(btnRechercher, 85);

        JPanel paneGeneriqueTest = new JPanel();
        paneGeneriqueTest.setLayout(null);
        JButton btnRechercherTest = new JButton("Rechercher");

        paneGeneriqueTest.add(btnRechercherTest);
        btnRechercherTest.addActionListener(ihm);
        btnRechercherTest.setBounds(85, 200, 100, 30);

        System.out.println(btnRechercherTest.toString());
        Assert.assertEquals("btnRechercher didn't match.", btnRechercherTest.toString(), btnRechercher.toString());
    }

    @Test
    public void testSetFieldBounds() throws NoSuchFieldException, IllegalAccessException {
        final Vue ihm = new Vue();

        final Field field = ihm.getClass().getDeclaredField("labelMatricule");
        field.setAccessible(true);

        JLabel labelMatricule = (JLabel) field.get(ihm);//mock
        labelMatricule = new JLabel("Matricule");
        ihm.setFieldBounds(labelMatricule, 10, 10, 80);



        JPanel paneGeneriqueTest = new JPanel();
        paneGeneriqueTest.setLayout(null);
        JLabel labelMatriculeTest = new JLabel("Matricule");

        ArrayList<JComponent> listComponentsTest = new ArrayList<>();
        listComponentsTest.add(labelMatriculeTest);
        ihm.addTo(paneGeneriqueTest, listComponentsTest);
        labelMatriculeTest.setBounds(10, 10, 80, 20);

        Assert.assertEquals("labelMatricule didn't match.", labelMatriculeTest.toString(), labelMatricule.toString());
    }
}
