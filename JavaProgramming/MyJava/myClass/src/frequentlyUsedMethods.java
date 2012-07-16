import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: i7pk13
 * Date: 3/16/12
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class frequentlyUsedMethods
{


    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static int getIntInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextInt();
    }

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static double getDblInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextDouble();
    }

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static String getStringInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.next();
    }

    /**
     * method used to validate input from the user
     * gets passed a string for user prompt also
     * a minimum value and a maximum value
     * to check against for validation
     * if input is out of range it will continue
     * to prompt user for correct input then returns
     * the input only after it passes validation
     * @param stringIn
     * @param min
     * @param max
     * @return
     */
    public static int validateInput(String stringIn, int min, int max)
    {
        int objVar = getIntInput(stringIn);
        while(objVar > max || objVar < min)
        {
            System.out.println("Invalid Entry!\nTry Again:");
            objVar = getIntInput(stringIn);
        }
        return objVar;
    }

}
