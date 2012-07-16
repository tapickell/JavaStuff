/**
 * BackwardString Demo
 * @author Todd Pickell CISS 238
 * Chapter 8
 * Programming Challenge 1 pg 563
 */
import java.util.LinkedList;
import java.util.Scanner;


public class BackwardString
{
    public static void main(String[] args)
    {
        /**
         * menu system that gives user choice of which method to run on input string.
         * since there are many different ways this could be implemented I thought
         * it would be neat to give the user a choice, all though the end result
         * is exactly the same.
         */
        String myText = getStringInput("Please enter text to be reversed: ");
        String answer = getStringInput("\nSelect method of String reversal:\n1 -Stack Reverse Iteration\n2 -StringBuilder.reverse()\n3 -Reverse Iteration\n");

        switch (Integer.valueOf(answer))
        {
            case 1:
                System.out.println(reverseStringStack(myText + "  -noitaretI esreveR kcatS"));
                break;
            case 2:
                System.out.println(reverseStringBuilder(myText + "  -)(esrever.redliuBgnirtS"));
                break;
            case 3:
                System.out.println(reverseString(myText + "        -noitaretI esreveR"));
                break;
            default:
                System.out.println("***Input Error***");
        }
                

        
        
    }

    /**
     * uses linked list as stack to push characters from string onto stack
     * then pop them from the stack into a new string builder them
     * returned with toString()
     * @param stringIn
     * @return
     */
    public static String reverseStringStack(String stringIn)
    {
        LinkedList<Character> myStack = new LinkedList<Character>();
        for (int i = 0; i < stringIn.length(); i++)
        {
            myStack.push(stringIn.charAt(i));
        }
        StringBuilder stringOut = new StringBuilder();
        for (int i = 0; i < stringIn.length(); i++)
        {
            stringOut.append(myStack.pop());
        }
        return stringOut.toString();
    }

    /**
     * simply creates string builder from string and calls reverse() & toString()
     * on the return statement
     * @param stringIn
     * @return
     */
    public static String reverseStringBuilder(String stringIn)
    {
        StringBuilder sb = new StringBuilder(stringIn);
        return sb.reverse().toString();

    }

    /**
     * iterates through the string in reverse order appending
     * each character to a new string builder then returning with
     * toString() method
     * @param stringIn
     * @return
     */
    public static String reverseString(String stringIn)
    {
        StringBuilder rev = new StringBuilder();
        for (int i = (stringIn.length()-1); i >= 0; i--)
        {
            rev.append(stringIn.charAt(i));
        }
        return  rev.toString();
    }

    /**
     * my function that displays string passed and then gets string from user
     * this is a function that I found useful in C++ and carried over to Java
     * @param stringIn
     * @return
     */
    public static String getStringInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextLine();
    }
}
