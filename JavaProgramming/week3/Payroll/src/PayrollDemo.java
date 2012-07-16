/**
 * Payroll Demo
 * @author Todd Pickell CISS 238
 * Chapter 7
 * Programming Challenge 2 pg 504
 */
import java.util.Scanner;
import java.text.DecimalFormat;


public class PayrollDemo
{

    public static void main(String[] args)
    {
       Payroll myPayroll = new Payroll();
       setupEmployees(myPayroll);
       displayGross(myPayroll);
    }

    public static void setupEmployees(Payroll objIn)
    {
        System.out.println("Please enter information for each employee.\n");
        for(int i=0; i < objIn.getNumEmployees(); i++)
        {
            System.out.println("Employee Number: " + objIn.getEmployeeId(i));
            int hrs = getIntInput("Please enter hours: ");
            while (hrs < 0)
            {
                hrs = getIntInput("Invalid Entry!\nTry Again\n\nPlease enter hours: ");
            }
            objIn.setHours(hrs, i);
            double rate = getDblInput("Please enter pay rate: ");
            while (rate < 6)
            {
                rate = getDblInput("Invalid Entry!\nPay Rate Must Be Above $6.00\nTry Again\n\nPlease enter pay rate: ");
            }
            objIn.setPayRate(rate, i);
            System.out.println("");
        }
    }

    public static void displayGross(Payroll objIn)
    {
        DecimalFormat myFormat = new DecimalFormat("'$'0.00");
        System.out.println("Displaying gross pay for each employee.\n");
        System.out.println("Employee Number:    Gross Pay:");
        for(int i=0; i < objIn.getNumEmployees(); i++)
        {
            System.out.println("    " + objIn.getEmployeeId(i) + "          " + myFormat.format(objIn.getGrossPay(objIn.getEmployeeId(i))));
        }
    }

    public static int getIntInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextInt();
    }
    public static double getDblInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextDouble();
    }
}
