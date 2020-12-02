import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest
{
    @Test
    public void constructorTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "", "2020-11-2020", false));
    }

    @Test
    public void constructorFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "", "2020-11-03", false));
    }

    @Test
    public void constructorSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() -> new TaskItem("title", "", "2020-11-03", false));
    }

    @Test
    public void constructorSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("Valid Title", "", "2020-11-03", false));
    }

    //The following "Setting" tests are the same for editing and are from the previous test cases
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

    @Test
    public void settingDescriptionSucceedsWithExpectedValue()
    {
        assertDoesNotThrow(() -> new TaskItem("Title", "any description", "2000-11-03", false));
    }

    @Test
    public void settingDueDateFailsWithInvalidYYYYMMDD()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("title", "desc", "2000000-666-50", false));
    }
}
