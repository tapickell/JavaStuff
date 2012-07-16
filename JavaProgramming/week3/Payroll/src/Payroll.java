/**
 * Payroll
 * @author Todd Pickell CISS 238
 * Chapter 7
 * Programming Challenge 2 pg 504
 */
public class Payroll
{
    /**
     * private fields
     */
    private final int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    private int[] hours = new int[7];
    private double[] payRate = new double[7];
    private double[] wages = new double[7];

    //Setters
    /**
     * setter method for hours field
     * @param hoursIn
     * @param indexIn
     */
    public void setHours(int hoursIn, int indexIn)
    {
        hours[indexIn] = hoursIn;
    }

    /**
     * setter method for payRate field
     * @param rateIn
     * @param indexIn
     */
    public void setPayRate(double rateIn, int indexIn)
    {
        payRate[indexIn] = rateIn;
    }

    /**
     * setter method for wages field
     * @param wageIn
     * @param indexIn
     */
    public void setWages(double wageIn, int indexIn)
    {
        wages[indexIn] = wageIn;
    }

    //Getters
    /**
     * getter method for hours field
     * @param indexIn
     * @return
     */
    public int getHours(int indexIn)
    {
        return hours[indexIn];
    }

    /**
     * getter method for payRate field
     * @param indexIn
     * @return
     */
    public double getPayRate(int indexIn)
    {
        return payRate[indexIn];
    }

    /**
     * getter method for wages field
     * @param indexIn
     * @return
     */
    public double getWages(int indexIn)
    {
        return wages[indexIn];
    }

    /**
     * getter method for employeeId field
     * @param indexIn
     * @return
     */
    public int getEmployeeId(int indexIn)
    {
        return employeeId[indexIn];
    }

    public int getNumEmployees()
    {
        return employeeId.length;
    }

    /**
     * calculates gross pay & saves it to wages field
     * takes in employeeId, if Id is not found prints
     * error to console and returns -1
     * wages and hours must be set before calling this method
     * @param idIn
     * @return
     */
    public double getGrossPay(int idIn)
    {
        int index = 0;
        boolean found = false;
        //find employee
        for(int i=0; i < employeeId.length; i++)
        {
             if(employeeId[i] == idIn)
             {
                 index = i;
                 found = true;
             }
        }
        if(!found)
        {
            System.out.println("Employee Id doesn't match records.");
            return -1;
        }
        else
        {
            //calc pay
            setWages((getPayRate(index) * getHours(index)), index);
            return getWages(index);
        }

    }
}
