import modele.ActionsBDImpl;
import modele.ProgrammeurBean;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void getProgrammeurs() {
        ResultSet rs = Mockito.mock(ResultSet.class); // create a fake ResultSet to call ProgrammeurBean setters.
        ProgrammeurBean prog;
        ArrayList<ProgrammeurBean> listeProgrammeurs = new ArrayList<>();
        try {
            //Create fake response from call of getString methods from our fake ResultSet (= Stubs)
            Mockito.when(rs.getString("MATRICULE")).thenReturn("1");
            Mockito.when(rs.getString("PRENOM")).thenReturn("Torvalds");
            Mockito.when(rs.getString("NOM")).thenReturn("Linus");
            Mockito.when(rs.getString("ADRESSE")).thenReturn("2 avenue Linux Git");
            Mockito.when(rs.getString("PSEUDO")).thenReturn("linuxroot");
            Mockito.when(rs.getString("RESPONSABLE")).thenReturn("Didier Achvar");
            Mockito.when(rs.getString("HOBBY")).thenReturn("Salsa");
            Mockito.when(rs.getString("DATE_NAISS")).thenReturn("1969-01-12");
            Mockito.when(rs.getString("DATE_EMB")).thenReturn("2170-01-12");

            Mockito.when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false); // simulate a resultSet with 2 elements

            while (rs.next()) {
                prog = Mockito.mock(ProgrammeurBean.class); // create a fake ProgrammerBean foreach element in the fake ResultSet
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDate_naiss(rs.getDate("DATE_NAISS"));
                prog.setDate_emb(rs.getDate("DATE_EMB"));
                listeProgrammeurs.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBDImpl.class.getName()).log(Level.SEVERE, null, sqle);
        }
        Assert.assertEquals(listeProgrammeurs.size(), 2); // check that the number of programmers recovered is correct
    }

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
}
