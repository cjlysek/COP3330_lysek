import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(InvalidContactException.class, () -> new ContactItem("", "", "", ""));
    }
    @Test
    public void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Paul", "902-132-1245", ""));
    }
    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem("", "Paul", "902-132-1245", "jpaul@gmail.com"));
    }
    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "", "902-132-1245", "jpaul@gmail.com"));
    }
    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Paul", "", "jpaul@gmail.com"));
    }
    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com"));
    }
    @Test
    public void editingFailsWithAllBlankValues()
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
    public void editingSucceedsWithBlankEmail()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("First");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("Last");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-456-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("Last");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-456-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("Email");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithBlankLastName()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("First");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-456-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("Email");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithBlankPhone()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("First");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("Last");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("Email");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        List<ContactItem> contacts = new ArrayList<>();
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        contacts.add(contact);

        contact.setFirstName("First");
        String newName = contacts.get(0).getFirstName();
        contact.setLastName("Last");
        String newLast = contacts.get(0).getLastName();
        contact.setPhoneNumber("123-456-7890");
        String newPhone = contacts.get(0).getPhoneNumber();
        contact.setEmail("Email");
        String newEmail = contacts.get(0).getEmail();


        assertDoesNotThrow(() -> new ContactItem(newName, newLast, newPhone, newEmail));
    }
    @Test
    public void testToString()
    {
        ContactItem contact = new ContactItem("John", "Paul", "902-132-1245", "jpaul@gmail.com");
        String testPrint = contact.toString();
        assertEquals(testPrint, "Name: John Paul     Phone Number: 902-132-1245     Email: jpaul@gmail.com");
    }
}