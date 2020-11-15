import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public void testDisplayModifierFinal() {
        class FakeVue implements ActionListener {
            private JButton btnRechercher;
            private JButton btnReinitialiser;
            private JButton btnValiderEcranModifier;
            private JButton btnAnnuler;

            protected JPanel paneGenerique = new JPanel();

            public void setButtonBounds(JButton button, int x) {
                button.setBounds(x, 200, 100, 30);
            }

            public void displayModifierFinal() {
                btnRechercher = new JButton("Rechercher");
                btnReinitialiser = new JButton("Réinitialiser");
                btnValiderEcranModifier = new JButton("Valider");
                btnAnnuler = new JButton("Annuler");
                paneGenerique.add(btnRechercher);
                paneGenerique.add(btnReinitialiser);
                paneGenerique.add(btnValiderEcranModifier);
                paneGenerique.add(btnAnnuler);
                btnRechercher.addActionListener(this);
                btnValiderEcranModifier.addActionListener(this);
                btnReinitialiser.setEnabled(false);
                btnAnnuler.addActionListener(this);
                setButtonBounds(btnRechercher, 85);
                setButtonBounds(btnReinitialiser, 190);
                setButtonBounds(btnValiderEcranModifier, 295);
                setButtonBounds(btnAnnuler, 400);
            }

            @Override
            public void actionPerformed(ActionEvent e) {}
        }
        FakeVue fake = new FakeVue();
        fake.displayModifierFinal();
        Assert.assertEquals(4, fake.paneGenerique.getComponentCount());
        Component[] comps = fake.paneGenerique.getComponents();
        for (Component c : comps) {
            Assert.assertEquals(JButton.class, c.getClass());
            JButton button = (JButton) c;
            if (button.getText() != "Réinitialiser")
                Assert.assertEquals(1, button.getActionListeners().length);
            else
                Assert.assertEquals(0, button.getActionListeners().length);
        }
        Assert.assertEquals(new Rectangle(85, 200, 100, 30), comps[0].getBounds());
        Assert.assertEquals(new Rectangle(190, 200, 100, 30), comps[1].getBounds());
        Assert.assertEquals(new Rectangle(295, 200, 100, 30), comps[2].getBounds());
        Assert.assertEquals(new Rectangle(400, 200, 100, 30), comps[3].getBounds());
    }
}
