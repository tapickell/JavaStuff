/**
 * Month Class
 * @author Todd Pickell CISS 238
 * Chapter 6
 * Programming Challenge 5 pg 409-410
 */


public class Month
{
    /**
     * private fields
     */
    private int monthNumber;
    private String monthName;
    private static String[] names = {"Undecided", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    /**
     * no-arg constructor
     */
    public Month()
    {
        setMonthNumber(1);
    }

    /**
     * constructor that takes an integer
     * @param month
     */
    public Month(int month)
    {
        setMonthNumber(month);
    }

    /**
     * constructor that takes a String
     * for the name of the month then coverts to
     * integer for number of month
     * @param stringIn
     */
    public Month(String stringIn)
    {
        Boolean isSet = false;
        for(int i = 0; i < names.length; i++)
        {
            if(stringIn.equalsIgnoreCase(names[i]))
            {
                setMonthNumber(i);
                isSet = true;
                break;
            }
        }
        if(!isSet)
        {
            setMonthNumber(1);
        }
    }

    /**
     * setter method for monthNumber field
     * uses input validation to keep it 1-12
     * @param intIn
     */
    public void setMonthNumber(int intIn)
    {
        if(intIn < 1 || intIn > 12)
        {
            monthNumber = 1;
            setMonthName(1);
        }
        else
        {
            monthNumber = intIn;
            setMonthName(intIn);
        }
    }

    /**
     * private only used by other methods
     * setter method for monthName field
     * takes in an integer and sets to
     * the corresponding month name
     * @param intIn
     */
    private void setMonthName(int intIn)
    {
        monthName = names[intIn];
    }

    /**
     * getter method for monthNumber field
     * @return integer monthNumber
     */
    public int getMonthNumber()
    {
        return monthNumber;
    }

    /**
     * getter method for monthName field
     * @return String monthName
     */
    public String getMonthName()
    {
        return  monthName;
    }

    /**
     * toString method that returns
     * a string with month name
     * @return String monthOut
     */
    public String toString()
    {
        String monthOut = "The month is " + getMonthName();
        return monthOut;
    }

    /**
     * equals method that determines if
     * the object and object passed in
     * have the same values
     * @param objIn
     * @return Boolean isEqual
     */
    public Boolean equals(Month objIn)
    {
        Boolean isEqual;

        if(this.getMonthNumber() == objIn.getMonthNumber())
        {
            isEqual = true;
        }
        else
        {
            isEqual = false;
        }
        return isEqual;
    }

    /**
     * greater than method that tests if
     * object passed in is greater than obj
     * @param objIn
     * @return Boolean greaterThan
     */
    public Boolean greaterThan(Month objIn)
    {
        Boolean isGreater;

        if(this.getMonthNumber() > objIn.getMonthNumber())
        {
            isGreater = true;
        }
        else
        {
            isGreater = false;
        }
        return isGreater;
    }

    /**
     * less than method that tests if
     * object passed in is less than object
     * @param objIn
     * @return Boolean isLess
     */
    public Boolean lessThan(Month objIn)
    {
        Boolean isLess;

        if(this.getMonthNumber() < objIn.getMonthNumber())
        {
            isLess = true;
        }
        else
        {
            isLess = false;
        }
        return isLess;
    }
}
