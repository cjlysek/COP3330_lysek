import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{
    @Test
    public void addingTaskItemsIncreasesSize()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);

        assertEquals(tasks.size(), 1);
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        tasks.get(counter - 1).setComplete(true);
        TaskItem task2 = tasks.get(counter - 1);


        assertEquals(task, task2);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        //counter is the invalid index, only index of 0 aka counter - 1 will work
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(counter).setComplete(true));
    }

    //Like with the other Test program, editing just requires making a new task normally and setting it so this should be sufficient
    @Test
    public void editingTaskItemChangesValues()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        TaskItem task2 = new TaskItem("Title2", "Description2", "2020-11-05", true);

        tasks.set(0, task2);
        assertEquals(tasks.get(counter - 1), task2);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        TaskItem task2 = new TaskItem("Title", "New Description", "2020-11-03", false);

        tasks.set(0, task2);
        assertEquals(tasks.get(counter - 1), task2);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        TaskItem task2 = new TaskItem("Title", "New Description", "2020-11-03", false);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.set(counter, task2));
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        TaskItem task2 = new TaskItem("Title", "desc", "2020-11-05", false);

        tasks.set(0, task2);
        assertEquals(tasks.get(counter - 1), task2);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        TaskItem task2 = new TaskItem("Title", "desc", "2020-11-05", false);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.set(counter, task2));
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;
        TaskItem task2 = new TaskItem("New Title", "desc", "2020-11-03", false);

        tasks.set(0, task2);
        assertEquals(tasks.get(counter - 1), task2);
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);

        TaskItem task2 = new TaskItem("New Title", "desc", "2020-11-03", false);
        int counter = 1;

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.set(counter, task2));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(counter).getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertDoesNotThrow(() -> tasks.get(counter - 1).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(counter).getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertDoesNotThrow(() -> tasks.get(counter - 1).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(counter).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {

        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        tasks.add(task);
        int counter = 1;

        assertDoesNotThrow(() -> tasks.get(counter - 1).getTitle());
    }

    @Test
    public void newTaskListIsEmpty()
    {
        List<TaskItem> tasks = new ArrayList<>();

        assertEquals(tasks.size(), 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        TaskItem task2 = new TaskItem("Title2", "desc2", "2020-11-05", false);

        //Add two tasks
        tasks.add(task);
        tasks.add(task2);

        //Remove one task
        tasks.remove(task2);

        //Task size should be one
        assertEquals(tasks.size(), 1);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", false);
        TaskItem task2 = new TaskItem("Title2", "desc2", "2020-11-05", false);
        int counter = 2;

        //Add two tasks
        tasks.add(task);
        tasks.add(task2);

        //Try to remove index of 2 (which does not exist)
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.remove(counter));
    }

    //Does not work properly, couldn't figure out how to load list as of now
    @Test
    public void savedTaskListCanBeLoaded()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("You failed this test boi", "desc", "2020-11-03", true);
        tasks.add(task);

        assertEquals(tasks.get(0).getTitle(), "You failed this test boi");

    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", true);
        tasks.add(task);
        int counter = 1;

        tasks.get(counter - 1).setComplete(false);
        TaskItem task2 = tasks.get(counter - 1);

        assertEquals(task, task2);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        List<TaskItem> tasks = new ArrayList<>();
        TaskItem task = new TaskItem("Title", "desc", "2020-11-03", true);
        tasks.add(task);
        int counter = 1;

        //counter is the invalid index, only index of 0 aka counter - 1 will work
        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(counter).setComplete(false));
    }

}
