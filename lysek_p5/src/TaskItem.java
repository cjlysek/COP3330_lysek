import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskItem
{
    final static String DATE_FORMAT = "yyyy-mm-dd";
    private String Title;
    private String description;
    private String dueDate;
    private boolean isComplete;
    private String editedTitle;
    private String editedDescription;
    private String editedDueDate;

    public TaskItem(String Title, String description, String dueDate, boolean isComplete)
    {

        if(isTitleValid(Title))
        {
            this.Title = Title;
        }
        else
        {
            throw new InvalidTitleException("Title is not valid; must be at least 1 character long");
        }

        if(isDateValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
        {
            throw new InvalidDateException("Date is not valid; ensure correct format usage");
        }

        this.isComplete = isComplete;
        this.description = description;

    }

    private boolean isDateValid(String dueDate)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(dueDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isTitleValid(String Title)
    {
        return Title.length() > 0;
    }


    public String getTitle()
    {
        return this.Title;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDueDate()
    {
        return this.dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getEditedTitle()
    {
        return this.editedTitle;
    }

    public String getEditedDescription()
    {
        return this.editedDescription;
    }

    public String getEditedDueDate()
    {
        return this.editedDueDate;
    }

    public boolean getCompletion()
    {
        return isComplete;
    }

    public void setComplete(boolean isComplete)
    {
        this.isComplete = isComplete;
    }


}

class InvalidTitleException extends IllegalArgumentException
{
    public InvalidTitleException(String msg)
    {
        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException
{
    public InvalidDateException(String msg)
    {
        super(msg);
    }
}

class IncorrectIndexException extends java.lang.IndexOutOfBoundsException
{
    public IncorrectIndexException(String msg){super(msg);}
}
