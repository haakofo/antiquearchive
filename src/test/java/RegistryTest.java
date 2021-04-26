import no.ntnu.idatg2001.Task;
import no.ntnu.idatg2001.TaskRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RegistryTest
{
    /**
     * Setting up the registry to be used with the tests.
     */
    private static TaskRegistry t1;

    /**
     * This simple method creates the reigstry to be used with the tests as well as a Task.Then adds the tasks.
     */
    @BeforeAll
     static void initialize()
     {
         t1 = new TaskRegistry();
         Task task1 = new Task("Test Oppgave", "High", "Hei, jeg er en kul test!", "Tester og slik", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 5, 6));
         t1.addTask(task1);
     }

    /**
     * Checks that the title we made actually got added to the registry.
     */
    @Test
    void addTestPositive()
    {
        assertEquals("Test Oppgave",t1.getReg().get(0).getTitle());
    }

    /**
     * Checks that an incorrect title was not added to the registry.
     */
    @Test
    void addTestNegative()
    {
        assertNotEquals("Ikke riktig tittel!", t1.getReg().get(0).getTitle());
    }

    /**
     * Checks that the removeTask method actually manages to remove a task.
     */
    @Test
    void removeTestPositive()
    {
        t1.removeTask(0);
        assertEquals(0,t1.getReg().size());
    }

    /**
     * Checks that the size of the registry has gotten smaller after removal.
     */
    @Test
    void removeTestNegative()
    {
        initialize();
        t1.removeTask(0);
        assertFalse(t1.getReg().size() == 1);
    }
}
