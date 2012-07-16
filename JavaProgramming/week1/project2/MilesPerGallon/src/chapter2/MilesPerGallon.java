package chapter2;

/**
 * Miles-per-Gallon
 * @author Todd Pickell CISS 238
 * 3/19/12
 * Chapter 2
 * Programming Challenge 9 pg 115
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MilesPerGallon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // variables
        double miles;
        double gallons;
        double mpgs = 0;
        String input;
        
        // get menu choice from user
        int choice = getIntInput("Press 1 for GUI or 2 for CLI: ");
        if (choice == 1) 
        {        
        // getting input
            input = JOptionPane.showInputDialog("Enter number of miles driven.");
            miles = Double.parseDouble(input);
            input = JOptionPane.showInputDialog("Enter number of gallons used.");
            gallons = Double.parseDouble(input);
            mpgs = calculateMPG(gallons, miles);
            // displaying answer
            JOptionPane.showMessageDialog(null, "Your miles per gallon: " + mpgs);
        }
        else 
        {
            miles = getDoubleInput("Enter number of miles driven.");
            gallons = getDoubleInput("Enter number of gallons used.");
            mpgs = calculateMPG(gallons, miles);
            System.out.println("Your miles per gallon: " + mpgs);
        }
                            
        System.exit(0);
    }
    
    // calculating mpg
    private static double calculateMPG(double gallonsIn, double milesIn)
    {
        double mpgsOut = 0;
        if(gallonsIn != 0)
        {
            mpgsOut = milesIn / gallonsIn;
        }
        return mpgsOut;
    }
    
    // gets input from user and returns an int
    private static int getIntInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextInt();
        
    }
    
    // gets input from user and returns a double
    private static double getDoubleInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextDouble();
        
    }
}
