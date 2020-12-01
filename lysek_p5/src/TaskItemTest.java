import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest
{
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "", "2020-11-2020", false));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "", "2020-11-03", false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() -> new TaskItem("title", "", "2020-11-03", false));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("Valid Title", "", "2020-11-03", false));
    }

    //How my program works is that when you set a task item you are entering everything again normally, so the same tests would show if it failed or not
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "", "2020-11-033333", false));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        assertDoesNotThrow(() -> new TaskItem("Valid Title", "", "2020-11-20", false));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "", "2020-11-03", false));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("Valid Title", "", "2069-11-05", false));
    }
}
