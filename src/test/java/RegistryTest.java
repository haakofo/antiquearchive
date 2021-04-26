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
    private static Task task1;

    /**
     * This simple method creates the reigstry to be used with the tests as well as a Task.Then adds the tasks.
     */
    @BeforeAll
     static void initialize()
     {
         t1 = new TaskRegistry();
         task1 = new Task("Test Oppgave", "High", "Hei, jeg er en kul test!", "Tester og slik", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 5, 6));
         t1.addTask(task1);
     }

    /**
     * Checks that the title we made actually got added to the registry.
     */
    @Test
    void addTestPositive()
    {
        assertEquals("Test Oppgave",task1.getTitle());
    }

    /**
     * Checks that an incorrect title was not added to the registry.
     */
    @Test
    void addTestNegative()
    {
        assertNotEquals("Ikke riktig tittel!", task1.getTitle());
    }

    /**
     * Checks that the removeTask method actually manages to remove a task.
     */
    @Test
    void removeTestPositive()
    {
        t1.removeSelectedTask(task1);
        assertTrue(t1.isEmpty());
    }
}
