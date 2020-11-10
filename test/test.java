import modele.ActionsBDImpl;
import org.junit.Assert;
import org.junit.Test;

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
}
