import no.antiquearchive.Item;
import no.antiquearchive.TaskRegistry;
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
    private static Item item1;

    /**
     * This simple method creates the reigstry to be used with the tests as well as a Task.Then adds the tasks.
     */
    @BeforeAll
     static void initialize()
     {
         t1 = new TaskRegistry();
         item1 = new Item("Test Oppgave", "High", "Hei, jeg er en kul test!", "Tester og slik", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 5, 6));
         t1.addTask(item1);
     }

    /**
     * Checks that the title we made actually got added to the registry.
     */
    @Test
    void addTestPositive()
    {
        assertEquals("Test Oppgave", item1.getModelAlias());
    }

    /**
     * Checks that an incorrect title was not added to the registry.
     */
    @Test
    void addTestNegative()
    {
        assertNotEquals("Ikke riktig tittel!", item1.getModelAlias());
    }

    /**
     * Checks that the removeTask method actually manages to remove a task.
     */
    @Test
    void removeTestPositive()
    {
        t1.removeSelectedTask(item1);
        assertTrue(t1.isEmpty());
    }
}
