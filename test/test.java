import modele.ActionsBDImpl;
import modele.ProgrammeurBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import java.lang.reflect.*;

@RunWith(MockitoJUnitRunner.class)
public class test {

    private static Vue vue;

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
    public void testAddToList() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Vue vue = new Vue();

        //when
        vue.addToList();

        //then
        final Field field = vue.getClass().getDeclaredField("listComponents");
        field.setAccessible(true);
        List list = (List) field.get(vue);
        Assert.assertEquals("Fields didn't match", list.size(), 22);
    }

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
