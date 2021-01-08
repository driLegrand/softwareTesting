import modele.ActionsBDImpl;
import modele.ProgrammeurBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.Constantes;
import vue.Vue;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;

@RunWith(MockitoJUnitRunner.class)
public class testVue {

    /**
     * Test to check components of the Display
     * (this isn't a unit test anymore)
     */
    @Test
    public void testDisplayModifierFinal() {
        // Setup
        final Vue vue = new Vue();
        vue.display();
        JPanel paneGenerique = vue.getPaneGenerique();

        // checking that paneGenerique is valid before calling the tested method
        Assert.assertEquals("PaneGenerique size from display() didn't match", 22, paneGenerique.getComponents().length);

        // main call
        vue.displayModifierFinal();

        // getting the affected attributes
        paneGenerique = vue.getPaneGenerique();
        JButton btnRechercher = vue.getBtnRechercher();
        JButton btnAnnuler = vue.getBtnAnnuler();
        JButton btnReinitialiser = vue.getBtnReinitialiser();
        JButton btnValiderEcranModifier = vue.getBtnValiderEcranModifier();

        // then
        Assert.assertTrue("btnRechercher's text content is not Rechercher", btnRechercher.getText() == "Rechercher");
        Assert.assertTrue("btnReinitializer's text content is not Réinitialiser", btnReinitialiser.getText() == "Réinitialiser");
        Assert.assertTrue("btnValidateEcranModifier's text content is not Valider", btnValiderEcranModifier.getText() == "Valider");
        Assert.assertTrue("btnAnnuler's text content is not Annuler", btnAnnuler.getText() == "Annuler");

        Assert.assertEquals("PaneGenerique size didn't vary as expected", 26, paneGenerique.getComponents().length);

        Assert.assertTrue("btnRechercher does not have a listener", btnRechercher.getActionListeners().length > 0);
        Assert.assertTrue("btnAnnuler does not have a listener", btnAnnuler.getActionListeners().length > 0);
        Assert.assertTrue("btnReinitialiser is enabled", !btnReinitialiser.isEnabled());
        Assert.assertTrue("btnValiderEcranModifier does not have a listener", btnValiderEcranModifier.getActionListeners().length > 0);

        Assert.assertTrue("btnRechercher wrong bounds", btnRechercher.getBounds().x == 85);
        Assert.assertTrue("btnAnnuler wrong bounds", btnAnnuler.getBounds().x == 400);
        Assert.assertTrue("btnReinitialiser wrong bounds", btnReinitialiser.getBounds().x == 190);
        Assert.assertTrue("btnValiderEcranModifier wrong bounds", btnValiderEcranModifier.getBounds().x == 295);
    }

    /**
     * Test if the background color of contentPane is Gray
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testActionPerformed() throws NoSuchFieldException, IllegalAccessException {
        Vue vue = new Vue();

        // We make sure the source of the event isn't null, then we create it
        vue.setBtnAnnuler(new JButton("Annuler"));
        final ActionEvent eventBtnAnnuler = new ActionEvent(vue.getBtnAnnuler(), 0, "");
        // the case of btnAnnuler will use Vue.paneAccueil, so we need to instantiate it to avoid NullPointerException
        vue.setPaneAccueil(new JPanel());
        //We actually test the method
        vue.actionPerformed(eventBtnAnnuler);
        Assert.assertEquals("actionPerformed failed to handle btnAnnuler", Color.GRAY, vue.getContentPane().getBackground());
    }

    /**
     * Test if all components of the window are here
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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

    /**
     * Test to check the Rechercher button
     */
    @Test
    public void testSetButtonBounds() {
        Vue vue = new Vue();

        JButton btnTest = new JButton();
        vue.setButtonBounds(btnTest, 85);

        JButton btnRef = new JButton();
        btnRef.setBounds(85, 200, 100, 30);

        Assert.assertEquals("Button bounds are not set correctly", btnRef.toString(), btnTest.toString());
    }

    /**
     * Test to check the label matricule
     */
    @Test
    public void testSetFieldBounds() {
        Vue vue = new Vue();
        JLabel labelMatricule = new JLabel("Matricule");
        vue.setFieldBounds(labelMatricule, 10, 10, 80);

        JLabel labelMatriculeTest = new JLabel("Matricule");
        labelMatriculeTest.setBounds(10, 10, 80, 20);

        Assert.assertEquals("Field bounds are not set correctly", labelMatriculeTest.toString(), labelMatricule.toString());
    }

    /**
     * Test to check paneAfficher and zoneAffichageProgrammeurs
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testDisplayAfficherTous() throws NoSuchFieldException, IllegalAccessException {
        final Vue vue = new Vue();
        vue.displayAfficherTous();

        JPanel paneAfficherTest = new JPanel();
        JTextArea zoneAffichageProgrammeursTest = new JTextArea(10, 70);
        JScrollPane scrollTest = new JScrollPane(zoneAffichageProgrammeursTest);
        paneAfficherTest.add(scrollTest);

        Assert.assertEquals("paneAfficher didn't match.", paneAfficherTest.toString(), vue.getPaneAfficher().toString());
        Assert.assertEquals("zoneAffichageProgrammeurs didn't match.", zoneAffichageProgrammeursTest.toString(), vue.getZoneAffichageProgrammeurs().toString());
        Assert.assertEquals("scroll didn't match.", scrollTest.toString(), vue.getScroll().toString());
    }

    /**
     * Test to check components of the DisplayAjouter
     */
    @Test
    public void testDisplayAjouter() {
        final Vue vue = new Vue();
        vue.display();
        vue.displayAjouter();
        JPanel paneGenerique = vue.getPaneGenerique();

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
        btnReinitialiserTest.addActionListener(vue);
        btnValiderEcranAjouterTest.addActionListener(vue);
        btnAnnulerTest.addActionListener(vue);
        btnRechercherTest.setBounds(85, 200, 100, 30);
        btnReinitialiserTest.setBounds(190, 200, 100, 30);
        btnValiderEcranAjouterTest.setBounds(295, 200, 100, 30);
        btnAnnulerTest.setBounds(400, 200, 100, 30);

        Assert.assertEquals("Couldn't properly display the 'adding' view", paneGeneriqueTest.toString(), paneGenerique.toString());
    }

    /**
     * Test to check components of the DisplaySupprimer
     */
    @Test
    public void testDisplaySupprimer(){
        final Vue vue = new Vue();
        vue.display();
        vue.displaySupprimer();
        JPanel paneGenerique = vue.getPaneGenerique();

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
        for(JComponent component : listComponentsTest){
            component.setEnabled(false);
        }
        labelMatriculeTest.setEnabled(true);
        champMatriculeTest.setEnabled(true);
        btnValiderEcranSupprimerTest.addActionListener(vue);
        btnAnnulerTest.addActionListener(vue);
        btnRechercherTest.setBounds(85, 200, 100, 30);
        btnReinitialiserTest.setBounds(190, 200, 100, 30);
        btnValiderEcranSupprimerTest.setBounds(295, 200, 100, 30);
        btnAnnulerTest.setBounds(400, 200, 100, 30);

        Assert.assertEquals("paneGenerique didn't match.", paneGeneriqueTest.toString(), paneGenerique.toString());
    }

    /**
     * Test to check adding an element to the list
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testAddToList() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Vue vue = new Vue();

        //when
        vue.addToList();

        //then
        final Field field = vue.getClass().getDeclaredField("listComponents");
        field.setAccessible(true);
        java.util.List list = (List) field.get(vue);
        Assert.assertEquals("Fields didn't match", list.size(), 22);
    }

    /**
     * Test to check components of the Display after modifications
     * (this isn't a unit test anymore)
     */
    @Test
    public void testDisplayModifier() {
        // Setup
        final Vue vue = new Vue();
        vue.display();
        JPanel paneGenerique = vue.getPaneGenerique();

        // checking that paneGenerique is valid before calling the tested method
        Assert.assertEquals("PaneGenerique size from display() didn't match", 22, paneGenerique.getComponents().length);

        // main call
        vue.displayModifier();

        // getting the affected attributes
        paneGenerique = vue.getPaneGenerique();
        JButton btnRechercher = vue.getBtnRechercher();
        JButton btnAnnuler = vue.getBtnAnnuler();
        JButton btnReinitialiser = vue.getBtnReinitialiser();
        JButton btnValiderEcranModifier = vue.getBtnValiderEcranModifier();

        //Then
        Assert.assertTrue("btnRechercher's text content is not Rechercher", btnRechercher.getText() == "Rechercher");
        Assert.assertTrue("btnReinitializer's text content is not Réinitialiser", btnReinitialiser.getText() == "Réinitialiser");
        Assert.assertTrue("btnValidateEcranModifier's text content is not Valider", btnValiderEcranModifier.getText() == "Valider");
        Assert.assertTrue("btnAnnuler's text content is not Annuler", btnAnnuler.getText() == "Annuler");

        Assert.assertEquals("PaneGenerique size didn't match", paneGenerique.getComponents().length, 26);

        Assert.assertTrue("btnRechercher does not have a listener", btnRechercher.getActionListeners().length > 0);
        Assert.assertTrue("btnAnnuler does not have a listener", btnAnnuler.getActionListeners().length > 0);
        Assert.assertTrue("btnReinitialiser is enabled", !btnReinitialiser.isEnabled());
        Assert.assertTrue("btnValiderEcranModifier is enabled", !btnValiderEcranModifier.isEnabled());

        Assert.assertTrue("btnRechercher wrong bounds", btnRechercher.getBounds().x == 85);
        Assert.assertTrue("btnAnnuler wrong bounds", btnAnnuler.getBounds().x == 400);
        Assert.assertTrue("btnReinitialiser wrong bounds", btnReinitialiser.getBounds().x == 190);
        Assert.assertTrue("btnValiderEcranModifier wrong bounds", btnValiderEcranModifier.getBounds().x == 295);
    }
}
