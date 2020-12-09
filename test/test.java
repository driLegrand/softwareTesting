import modele.ActionsBDImpl;
import modele.ProgrammeurBean;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import utils.Constantes;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.Vue;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class test {

    public ActionsBDImpl conn = new ActionsBDImpl();
 
    /*@Test
    public void testAjouterProgrammeur() throws SQLException
    {
        Assert.assertNotNull(conn);
        PreparedStatement pstmt = conn.prepareStatement(Constantes.INSERT_UNIQUE);

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
        Assert.assertNotNull(conn);
        PreparedStatement pstmt = conn.prepareStatement(Constantes.UPDATE_UNIQUE);

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
        Assert.assertNotNull(conn);
        PreparedStatement pstmt = conn.prepareStatement(Constantes.DELETE_UNIQUE);

        pstmt.setString(1, Constantes.TESTADDPROG_MATR);

        int isSuccessful = pstmt.executeUpdate();
        Assert.assertNotEquals(0, isSuccessful);
    }*/



    /**
     * Test to check closure of the Database
     */
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

    /**
     * Test to check if we retrieve list of programmers from Database
     */
    @Test
    public void testGetProgrammeurs() {
        ActionsBDImpl tested = new ActionsBDImpl();
        Assert.assertTrue(tested.getProgrammeurs() instanceof ArrayList);
    }

    /**
     * Test to check if we retrieve list of programmers from Database
     */
    @Test
    public void testGetResultSet() {
        String query = Constantes.SELECT_ALL;
        ActionsBDImpl tested = new ActionsBDImpl();
        Assert.assertTrue(tested.getResultSet(query) instanceof ResultSet);
    }

    /**
     * Test to check components of the Display
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testDisplayModifierFinal() throws NoSuchFieldException, IllegalAccessException {
        // Setup
        final Vue vue = new Vue();
        final Field paneGenerique = vue.getClass().getSuperclass().getDeclaredField("paneGenerique");
        paneGenerique.setAccessible(true);
        paneGenerique.set(vue, new JPanel());
        final Field btnRechercher = vue.getClass().getDeclaredField("btnRechercher");
        final Field btnAnnuler = vue.getClass().getDeclaredField("btnAnnuler");
        final Field btnReinitializer = vue.getClass().getDeclaredField("btnReinitialiser");
        final Field btnValidateEcranModifier = vue.getClass().getDeclaredField("btnValiderEcranModifier");
        btnAnnuler.setAccessible(true);
        btnReinitializer.setAccessible(true);
        btnRechercher.setAccessible(true);
        btnValidateEcranModifier.setAccessible(true);

        // When
        vue.displayModifierFinal();

        //Then
        Assert.assertTrue("btnRechercher's text content is not Rechercher", ((JButton) btnRechercher.get(vue)).getText() == "Rechercher");
        Assert.assertTrue("btnReinitializer's text content is not Réinitialiser", ((JButton) btnReinitializer.get(vue)).getText() == "Réinitialiser");
        Assert.assertTrue("btnValidateEcranModifier's text content is not Valider", ((JButton) btnValidateEcranModifier.get(vue)).getText() == "Valider");
        Assert.assertTrue("btnAnnuler's text content is not Annuler", ((JButton) btnAnnuler.get(vue)).getText() == "Annuler");

        Assert.assertEquals("PaneGenerique size didn't match", ((JPanel) paneGenerique.get(vue)).getComponents().length, 4);

        Assert.assertTrue("btnRechercher does not have a listener", ((JButton) btnRechercher.get(vue)).getActionListeners().length > 0);
        Assert.assertTrue("btnAnnuler does not have a listener", ((JButton) btnAnnuler.get(vue)).getActionListeners().length > 0);
        Assert.assertTrue("btnReinitialiser is enabled", !((JButton) btnReinitializer.get(vue)).isEnabled());
        Assert.assertTrue("btnValiderEcranModifier does not have a listener", ((JButton) btnValidateEcranModifier.get(vue)).getActionListeners().length > 0);

        Assert.assertTrue("btnRechercher wrong bounds", ((JButton) btnRechercher.get(vue)).getBounds().x == 85);
        Assert.assertTrue("btnAnnuler wrong bounds", ((JButton) btnAnnuler.get(vue)).getBounds().x == 400);
        Assert.assertTrue("btnReinitialiser wrong bounds", ((JButton) btnReinitializer.get(vue)).getBounds().x == 190);
        Assert.assertTrue("btnValiderEcranModifier wrong bounds", ((JButton) btnValidateEcranModifier.get(vue)).getBounds().x == 295);
    }

    /**
     * Test if the background color of contentPane is Gray
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testActionPerformed() throws NoSuchFieldException, IllegalAccessException {
        final Vue vue = new Vue();

        // We make sure the source of the event isn't null, then we create it
        final Field btnAnnuler = vue.getClass().getDeclaredField("btnAnnuler");
        btnAnnuler.setAccessible(true);
        btnAnnuler.set(vue, new JButton("Annuler"));
        final ActionEvent eventBtnAnnuler = new ActionEvent((JButton) btnAnnuler.get(vue), 0, "");

        // the case of btnAnnuler will use Vue.paneAccueil, so we need to instantiate it to avoid NullPointerException
        final Field paneAccueil = vue.getClass().getSuperclass().getDeclaredField("paneAccueil");
        paneAccueil.setAccessible(true);
        paneAccueil.set(vue, new JPanel());

        //We actually test the method
        vue.actionPerformed(eventBtnAnnuler);
        Assert.assertEquals(Color.GRAY, vue.getContentPane().getBackground());
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

    /**
     * Test to check the Rechercher button
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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

    /**
     * Test to check the label matricule
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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

    /**
     * Test to check paneAfficher and zoneAffichageProgrammeurs
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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

    /**
     * Test to check components of the DisplayAjouter
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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

    /**
     * Test to check components of the DisplaySupprimer
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
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
    
    /**
     * Test the function getProgrammeurs
     */
    @Test
    public void getProgrammeurs() {
        ProgrammeurBean testProg1 = new ProgrammeurBean("1","Torvalds","Linus","2 avenue Linux Git","linuxroot","Didier Achvar","Salsa", Date.valueOf("1969-01-12"),Date.valueOf("2170-01-12"));
        ProgrammeurBean testProg10 = new ProgrammeurBean("10","Codd","Edgar Frank","2 bvd des Relations","bdd1","Lamine Bougueroua","Puzzles",Date.valueOf("1923-01-12"),Date.valueOf("8541-01-12"));
        ProgrammeurBean prog1 = (ProgrammeurBean)conn.getProgrammeurs().get(0);
        ProgrammeurBean prog10 = (ProgrammeurBean)conn.getProgrammeurs().get(9);
        Assert.assertEquals(prog1.getNom(), testProg1.getNom());
        Assert.assertEquals(prog10.getNom(), testProg10.getNom());
        Assert.assertEquals(conn.getProgrammeurs().size(), 13); // check that the number of programmers recovered is correct
    }

    /**
     * Test to check afficherProgrammeurs
     */
    @Test
    public void afficherProgrammeurs() {
        String listeProg = "";
        String fakeString = "1 Torvalds Linus 2 avenue Linux Git linuxroot Didier Achvar Salsa 1969-01-12 2170-01-12\n";

        // Create a false list of ProgrammeurBean
        ArrayList<ProgrammeurBean> listeProgrammeurs = new ArrayList<>();

        for(int i=0;i<3;i++) {
            ProgrammeurBean pb = Mockito.mock(ProgrammeurBean.class);
            Mockito.when(pb.toString()).thenReturn(fakeString); // fake the return of toString to a predefined String
            listeProgrammeurs.add(pb);
        }

        for (ProgrammeurBean progr : listeProgrammeurs) {
            listeProg = listeProg + progr;
        }

        Assert.assertEquals(listeProg, fakeString + fakeString + fakeString); //Check that the returned String is as expected
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
     *
     * @throws NoSuchFieldException If one field is missing is the Database
     * @throws IllegalAccessException If the Database cannot be access
     */
    @Test
    public void testDisplayModifier() throws NoSuchFieldException, IllegalAccessException {
        // Setup
        final Vue vue = new Vue();
        final Field paneGenerique = vue.getClass().getSuperclass().getDeclaredField("paneGenerique");
        paneGenerique.setAccessible(true);
        paneGenerique.set(vue, new JPanel());
        final Field btnRechercher = vue.getClass().getDeclaredField("btnRechercher");
        final Field btnAnnuler = vue.getClass().getDeclaredField("btnAnnuler");
        final Field btnReinitializer = vue.getClass().getDeclaredField("btnReinitialiser");
        final Field btnValidateEcranModifier = vue.getClass().getDeclaredField("btnValiderEcranModifier");
        btnAnnuler.setAccessible(true);
        btnReinitializer.setAccessible(true);
        btnRechercher.setAccessible(true);
        btnValidateEcranModifier.setAccessible(true);

        // When
        vue.displayModifier();

        //Then
        Assert.assertTrue("btnRechercher's text content is not Rechercher", ((JButton) btnRechercher.get(vue)).getText() == "Rechercher");
        Assert.assertTrue("btnReinitializer's text content is not Réinitialiser", ((JButton) btnReinitializer.get(vue)).getText() == "Réinitialiser");
        Assert.assertTrue("btnValidateEcranModifier's text content is not Valider", ((JButton) btnValidateEcranModifier.get(vue)).getText() == "Valider");
        Assert.assertTrue("btnAnnuler's text content is not Annuler", ((JButton) btnAnnuler.get(vue)).getText() == "Annuler");

        Assert.assertEquals("PaneGenerique size didn't match", ((JPanel) paneGenerique.get(vue)).getComponents().length, 4);

        Assert.assertTrue("btnRechercher does not have a listener", ((JButton) btnRechercher.get(vue)).getActionListeners().length > 0);
        Assert.assertTrue("btnAnnuler does not have a listener", ((JButton) btnAnnuler.get(vue)).getActionListeners().length > 0);
        Assert.assertTrue("btnReinitialiser is enabled", !((JButton) btnReinitializer.get(vue)).isEnabled());
        Assert.assertTrue("btnValiderEcranModifier does not have a listener", !((JButton) btnValidateEcranModifier.get(vue)).isEnabled());

        Assert.assertTrue("btnRechercher wrong bounds", ((JButton) btnRechercher.get(vue)).getBounds().x == 85);
        Assert.assertTrue("btnAnnuler wrong bounds", ((JButton) btnAnnuler.get(vue)).getBounds().x == 400);
        Assert.assertTrue("btnReinitialiser wrong bounds", ((JButton) btnReinitializer.get(vue)).getBounds().x == 190);
        Assert.assertTrue("btnValiderEcranModifier wrong bounds", ((JButton) btnValidateEcranModifier.get(vue)).getBounds().x == 295);
    }
}
