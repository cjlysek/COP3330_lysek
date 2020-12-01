import java.io.File;
import java.util.Scanner;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);
    private ContactList contacts;
    private int MainMenu = 0;
    private int OpMenu = 0;
    private int contactToEdit;
    private int contactToRemove;

    private void processMenu()
    {
        while(true)
        {
            DisplayMainMenu();
            MainMenu = input.nextInt();
            if(MainMenu == 1)
            {
                contacts = new ContactList();
                OperationProcedure();
            }
            else if(MainMenu == 2)
            {
                contacts = new ContactList();
                loadContactList();
                OperationProcedure();
                //System.out.println("It was so easy to fix wtf");
            }
            else if(MainMenu == 3)
            {
                System.out.println("Exiting Contact Menu");
                break;
            }
            else
            {
                System.out.println("Incorrect option, choose again");
            }
        }
    }

    private void loadContactList()
    {
        input.nextLine();
        System.out.println("Enter the name of a file to load your list from");

        contacts = new ContactList();
        contacts.loadList(new File(input.nextLine()));
    }


    private void writeContactData()
    {
        System.out.println("Enter a file name to save the list to: ");
        String fileToSaveTo = input.next();
        System.out.printf("Saving file to %s", fileToSaveTo);
        contacts.write(fileToSaveTo);
    }

    private void storeContactData(ContactItem contact)
    {
        contacts.add(contact);
    }


    private void storeEditedContact(ContactItem contact, int contactToEdit)
    {
        contacts.replace(contact, contactToEdit);
    }

    private void removeContact(int contactToRemove)
    {
        contacts.delete(contactToRemove);
    }

    private ContactItem getFirstNameItem()
    {
        ContactItem contact = null;
        while(true) {
            try {
                String FirstName = getFirstName();
                String LastName = getLastName();
                String PhoneNumber = getPhoneNumber();
                String email = getEmail();


                contact = new ContactItem(FirstName, LastName, PhoneNumber, email);
                break;
            } catch (InvalidContactException ex) {
                System.out.println("Warning: your Contact was invalid, please double check it and try again");
            }
        }
        return contact;
    }


    private ContactItem getEditedContact()
    {
        ContactItem contact = null;
        while(true) {
            try {
                String FirstName = getEditedFirstName();
                String LastName = getEditedLastName();
                String PhoneNumber = getEditedPhoneNumber();
                String email = getEditedEmail();


                contact = new ContactItem(FirstName, LastName, PhoneNumber, email);
                break;
            } catch (InvalidContactException ex) {
                System.out.println("Warning: your Contact was invalid, please double check it and try again");
            }
        }
        return contact;
    }


    private String getFirstName()
    {
        System.out.println("Enter the First Name:");
        return input.nextLine();
    }

    private String getEditedFirstName()
    {
        System.out.println("Enter the new First Name:");
        return input.nextLine();
    }

    private String getLastName()
    {
        System.out.println("Enter the LastName:");
        return input.nextLine();
    }

    private String getEditedLastName()
    {
        System.out.println("Enter the new Last Name");
        return input.nextLine();
    }

    public String getPhoneNumber()
    {
        System.out.println("Enter the Phone Number");
        return input.nextLine();
    }

    private String getEditedPhoneNumber()
    {
        System.out.println("Enter the new Phone Number");
        return input.nextLine();
    }

    private String getEmail()
    {
        System.out.println("Enter the Email");
        return input.nextLine();
    }

    private String getEditedEmail()
    {
        System.out.println("Enter the new email");
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
        System.out.println("5) Save the current list");
        System.out.println("6) Quit to the main menu");
    }

    private void OperationProcedure()
    {
        while(true)
        {
            DisplayOperationMenu();
            OpMenu = input.nextInt();
            if(OpMenu == 1)
            {
                contacts.print();
            }
            if(OpMenu == 2)
            {
                input.nextLine();
                ContactItem contact = getFirstNameItem();

                storeContactData(contact);
            }
            if(OpMenu == 3)
            {
                contacts.print();
                System.out.println("Enter a contact number to edit\n");
                contactToEdit = input.nextInt();
                input.nextLine();

                //Create the new Edited Contact
                ContactItem contact = getEditedContact();

                storeEditedContact(contact, contactToEdit);
            }
            if(OpMenu == 4)
            {
                contacts.print();
                System.out.println("Enter a contact number to remove\n");
                contactToRemove = input.nextInt();

                removeContact(contactToRemove);
            }
            if(OpMenu == 5)
            {
                writeContactData();

            }
            if(OpMenu == 6)
            {
                System.out.println("Exiting Contact List Creation");
                break;
            }
        }
    }

    public static void ContactMain(String[] args)
    {
        ContactApp m = new ContactApp();

        m.processMenu();
    }
}