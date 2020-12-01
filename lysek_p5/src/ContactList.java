import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList
{
    List<ContactItem> contacts;
    public ContactList()
    {
        contacts = new ArrayList<>();
    }

    public void add(ContactItem contact)
    {
        contacts.add(contact);
    }

    public void replace(ContactItem contact, int contactToEdit)
    {
        contacts.set(contactToEdit - 1, contact);
    }

    public void delete(int contactToRemove)
    {
        contacts.remove(contactToRemove - 1);
    }

    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                ContactItem contact = contacts.get(i);
                output.format("%s\n%s\n%s\n%s\n", contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail());
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
        System.out.println("Current Contact List: \n");
        System.out.println("__________________\n");
        for(int i = 0; i < contacts.size(); i++)
        {
            ContactItem contact = contacts.get(i);
            System.out.printf("%d) Name: %s     %s     Phone Number: %s     Email: %s\n", i + 1, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmail());
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
                ContactItem contact = new ContactItem(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                contacts.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}