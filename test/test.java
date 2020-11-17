import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

public class test {

    public ActionsBDImpl conn = new ActionsBDImpl();

    @Test
    public void stubbingReturnValue() {
        Assert.assertTrue(true);
    }

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
}
