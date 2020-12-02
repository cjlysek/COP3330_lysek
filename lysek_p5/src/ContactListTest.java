import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest

{
    @Test
    public void addingItemsIncreasesSize()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "123-456-7890", "jpaul@gmail.com");
        contacts.add(contact);

        assertEquals(contacts.size(), 1);
    }
    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("");
        String newEmail = contacts.get(0).getEmail();

        assertThrows(InvalidContactException.class, () -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "123-456-7890", "jpaul@gmail.com");
        contacts.add(contact);
        int counter = 1;

        ContactItem contact2 = new ContactItem("Name2", "AnotherName2", "A really cool phone #", "Cool email");

        assertThrows(IndexOutOfBoundsException.class, () -> contacts.set(counter, contact2));
    }
    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("NewLast");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-666-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("jpaul666@gmail.com");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithBlankLastName()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("NewFirst");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-666-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("jpaul666@gmail.com");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithBlankPhone()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("NewFirst");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("NewLast");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("jpaul666@gmail.com");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("NewFirst");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("NewLast");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-666-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("jpaul666@gmail.com");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void newListIsEmpty()
    {
        List<ContactItem> contacts = new ArrayList<>();
        assertEquals(contacts.size(), 0);
    }
    @Test
    public void removingItemsDecreasesSize()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("First", "Last", "123-456-7890", "email@gmail.com");
        //Size of contacts is 1
        contacts.add(contact);
        //Removes the one Contact Item
        contacts.remove(0);

        assertEquals(contacts.size(), 0);
    }
    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("First", "Last", "123-456-7890", "email@gmail.com");
        //Size of contacts is 1 at index 0
        contacts.add(contact);

        //Try to remove index 1 which is out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> contacts.remove(1));
    }
    @Test
    public void savedContactListCanBeLoaded()
    {
        List<ContactItem> contacts = new ArrayList<>();
        //Assume list is loaded and two items are created based off the list input below
        ContactItem fileInput = new ContactItem("Name1","Last1", "Num1", "email1");
        ContactItem fileInput2 = new ContactItem("Name1","Last2", "Num2", "email2");

        assertDoesNotThrow(() -> contacts.add(fileInput));
        assertDoesNotThrow(() -> contacts.add(fileInput2));
    }

}