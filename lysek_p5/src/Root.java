import java.util.Scanner;


public class Root
{
    public static void main(String []args)
    {
        while(true)
        {
            printApplication();
            Scanner input = new Scanner(System.in);
            int ApplicationChoice = input.nextInt();
            if(ApplicationChoice == 1)
            {
                TaskApp.AppMain(null);
            }
            if(ApplicationChoice == 2)
            {
                ContactApp.ContactMain(null);
            }
            if(ApplicationChoice == 3)
            {
                System.out.println("Exiting program...");
                break;
            }
        }
    }

    public static void printApplication()
    {
        System.out.println("Select your application");
        System.out.println("-----------------------\n");
        System.out.println("1) Task List");
        System.out.println("2) Contact List");
        System.out.println("3) Quit\n");

    }
}
