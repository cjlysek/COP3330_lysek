import java.io.File;
import java.util.Scanner;

public class App {

    private String fileToLoad;
    private static Scanner input = new Scanner(System.in);
    private TaskList tasks;
    private int MainMenu = 0;
    private int OpMenu = 0;
    private int taskToEdit;
    private int taskToRemove;
    private int taskToMark;



    private void processMenu()
    {
        while(true)
        {
            DisplayMainMenu();
            MainMenu = input.nextInt();
            if(MainMenu == 1)
            {
                tasks = new TaskList();
                OperationProcedure();
            }
            else if(MainMenu == 2)
            {
                //tasks = new TaskList();
                //loadTaskList();
                //OperationProcedure();
                System.out.println("This isn't working right and don't want the program to crash, F");
            }
            else if(MainMenu == 3)
            {
                System.out.println("Sayonara");
                break;
            }
            else
            {
                System.out.println("Incorrect option, choose again");
            }
        }
    }

    private void unmarkTask(int taskToMark)
    {
        tasks.unmark(taskToMark);
    }

    private void markTask(int taskToMark)
    {
        tasks.mark(taskToMark);
    }


    private void loadTaskList()
    {
        input.nextLine();
        System.out.println("Enter the name of a file to load your list from");

        tasks = new TaskList();
        tasks.loadList(new File(input.nextLine()));
    }


    private void writeTaskData()
    {
        System.out.println("Saving file to \"output.txt\"");
        tasks.write("output.txt");
    }

    private void storeTaskData(TaskItem task)
    {
        tasks.add(task);
    }


    private void storeEditedTask(TaskItem task, int taskToEdit)
    {
        tasks.replace(task, taskToEdit);
    }

    private void removeTask(int taskToRemove)
    {
        tasks.delete(taskToRemove);
    }

    private TaskItem getTaskItem()
    {
        TaskItem task = null;
        while(true) {
            try {
                String Title = getTitle();
                String description = getDescription();
                String dueDate = getDueDate();


                task = new TaskItem(Title, description, dueDate, false);
                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Warning: your Title was invalid, please double check it and try again");
            }
            catch(InvalidDateException ex)
            {
                System.out.println("Warning: your Date was entered in an invalid format, please double check it and try again");
            }
        }
        return task;
    }


    private TaskItem getEditedTask()
    {
        TaskItem task = null;
        while(true) {
            try {
                String Title = getEditedTitle();
                String description = getEditedDescription();
                String dueDate = getEditedDueDate();
                boolean isComplete = askIsComplete();


                task = new TaskItem(Title, description, dueDate, isComplete);
                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Warning: your Title was invalid, please double check it and try again");
            }
            catch(InvalidDateException ex)
            {
                System.out.println("Warning: your Date was entered in an invalid format, please double check it and try again");
            }
        }
        return task;
    }

    private boolean askIsComplete()
    {
        System.out.println("Is this task completed? (True/False)");
        return input.nextBoolean();
    }

    private String getTitle()
    {
        System.out.println("Enter the Title:");
        return input.nextLine();
    }

    private String getEditedTitle()
    {
        System.out.println("Enter the new Title:");
        return input.nextLine();
    }

    private String getDescription()
    {
        System.out.println("Enter the description:");
        return input.nextLine();
    }

    private String getEditedDescription()
    {
        System.out.println("Enter the new Description");
        return input.nextLine();
    }

    public String getDueDate()
    {
        System.out.println("Enter the due date (format yyyy-mm-dd)");
        return input.nextLine();
    }

    private String getEditedDueDate()
    {
        System.out.println("Enter the due date (format yyyy-mm-dd)");
        return input.nextLine();
    }


    private static void DisplayMainMenu()
    {
        System.out.println("Main Menu");
        System.out.println("_________");
        System.out.println("\n1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

    private static void DisplayOperationMenu()
    {
        System.out.println("List Operation Menu");
        System.out.println("_________");
        System.out.println("\n1) View the list");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

    private void OperationProcedure()
    {
        while(true)
        {
            DisplayOperationMenu();
            OpMenu = input.nextInt();
            if(OpMenu == 1)
            {
                tasks.print();
            }
            if(OpMenu == 2)
            {
                input.nextLine();
                TaskItem task = getTaskItem();

                storeTaskData(task);
            }
            if(OpMenu == 3)
            {
                tasks.print();
                System.out.println("Enter a task number to edit\n");
                taskToEdit = input.nextInt();
                input.nextLine();

                //Create the new Edited Task
                TaskItem task = getEditedTask();

                storeEditedTask(task, taskToEdit);
            }
            if(OpMenu == 4)
            {
                tasks.print();
                System.out.println("Enter a task number to remove\n");
                taskToRemove = input.nextInt();

                removeTask(taskToRemove);
            }
            if(OpMenu == 5)
            {
                tasks.print();
                System.out.println("Enter a task to mark as complete: ");
                taskToMark = input.nextInt();
                input.nextLine();

                markTask(taskToMark);

            }
            if(OpMenu == 6)
            {
                tasks.print();
                System.out.println("Enter a task to mark as incomplete");
                taskToMark = input.nextInt();
                input.nextLine();

                unmarkTask(taskToMark);
            }
            if(OpMenu == 7)
            {
                writeTaskData();
            }
            if(OpMenu == 8)
            {
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        App m = new App();

        m.processMenu();
    }
}