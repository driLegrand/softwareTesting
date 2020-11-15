import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class test {

    public ActionsBDImpl conn = new ActionsBDImpl();

    @Test
    public void stubbingReturnValue() {
        Assert.assertTrue(true);
    }

    @Test
    public void testDisplayModifierFinal() throws NoSuchFieldException, IllegalAccessException {
        final Vue vue = new Vue();
        final Field field = vue.getClass().getSuperclass().getDeclaredField("paneGenerique");
        field.setAccessible(true);

        field.set(vue, new JPanel());
        vue.displayModifierFinal();

        Assert.assertEquals(4, ((JPanel) field.get(vue)).getComponentCount());
        Component[] comps = ((JPanel) field.get(vue)).getComponents();
        for (Component c : comps) {
            Assert.assertEquals(JButton.class, c.getClass());
            JButton button = (JButton) c;
            if (button.getText() != "Réinitialiser") {
                Assert.assertEquals(1, button.getActionListeners().length);
                Assert.assertTrue(button.isEnabled());
            } else {
                Assert.assertEquals(0, button.getActionListeners().length);
                Assert.assertFalse(button.isEnabled());
            }
        }
        Assert.assertEquals(new Rectangle(85, 200, 100, 30), comps[0].getBounds());
        Assert.assertEquals(new Rectangle(190, 200, 100, 30), comps[1].getBounds());
        Assert.assertEquals(new Rectangle(295, 200, 100, 30), comps[2].getBounds());
        Assert.assertEquals(new Rectangle(400, 200, 100, 30), comps[3].getBounds());
    }

    @Test
    public void testActionPerformed() {
        
    }
}
