import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList
{
    List<TaskItem> tasks;
    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public void add(TaskItem task)
    {
        tasks.add(task);
    }

    public void replace(TaskItem task, int taskToEdit)
    {
        tasks.set(taskToEdit - 1, task);
    }

    public void delete(int taskToRemove)
    {
        tasks.remove(taskToRemove - 1);
    }

    public void mark(int taskToMark)
    {
        try {
            tasks.get(taskToMark - 1).setComplete(true);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Index/Choice, please try again");
        }

    }

    public void unmark(int taskToMark)
    {

        try {
            tasks.get(taskToMark - 1).setComplete(false);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Index/Choice, please try again");
        }
    }





    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            for(int i = 0; i < tasks.size(); i++)
            {
                TaskItem task = tasks.get(i);
                output.format("%s\n%s\n%s\n%b\n", task.getTitle(), task.getDescription(), task.getDueDate(), task.getCompletion());
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to find the file...");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void print()
    {
        System.out.println("Current Task List: \n");
        System.out.println("__________________\n");
        for(int i = 0; i < tasks.size(); i++)
        {
            TaskItem task = tasks.get(i);
            System.out.printf("%d) %s     %s     Due by: %s     Completed: %b\n", i + 1, task.getTitle(), task.getDescription(), task.getDueDate(), task.getCompletion());
        }
        System.out.println("\n");
    }

    public void loadList(File s)
    {
        try {
            Scanner scanner = new Scanner(s);
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                TaskItem task = new TaskItem(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Boolean.parseBoolean(scanner.nextLine()));
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}