public class ContactItem
{
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String email;
    private String editedFirstName;
    private String editedLastName;
    private String editedPhoneNumber;
    private String editedEmail;

    public ContactItem(String FirstName, String LastName, String PhoneNumber, String email)
    {

        if(isContactValid(FirstName, LastName, PhoneNumber, email))
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.PhoneNumber = PhoneNumber;
            this.email = email;
        }
        else
        {
            throw new InvalidContactException("Contact is not valid, must have at least a first name, last name, phone number or email");
        }
    }

    private boolean isContactValid(String FirstName, String LastName, String PhoneNumber, String email)
    {
        return (FirstName.length() > 0 || LastName.length() > 0 || PhoneNumber.length() > 0 || email.length() > 0);
    }

    public String getFirstName()
    {
        return this.FirstName;
    }

    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getLastName()
    {
        return this.LastName;
    }

    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public String getPhoneNumber()
    {
        return this.PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEditedFirstName()
    {
        return this.editedFirstName;
    }

    public String getEditedLastName()
    {
        return this.editedLastName;
    }

    public String getEditedPhoneNumber()
    {
        return this.editedPhoneNumber;
    }

    public String getEditedEmail()
    {
        return this.editedEmail;
    }

    @Override
    public String toString()
    {
        return "Name: " + getFirstName() + " " +getLastName() + "     " + "Phone Number: " + getPhoneNumber() + "     " + "Email: " + getEmail();
    }
}



class InvalidContactException extends IllegalArgumentException
{
    public InvalidContactException(String msg)
    {
        super(msg);
    }
}

