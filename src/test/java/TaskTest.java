import General.DukeException;
import Tasks.Task;
import Tasks.Todo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaskTest {
    @Test
    public void TodoTest() throws DukeException {
        String input = "todo tmr getup";
        Task task = new Todo(input);
        String expectedToString = "[T][\u2718]tmr getup";
        assertEquals(expectedToString, task.toString());
    }
}
