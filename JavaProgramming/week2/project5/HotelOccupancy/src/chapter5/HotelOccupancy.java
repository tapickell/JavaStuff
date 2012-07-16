package chapter5;

/**
 * Hotel Occupancy Demo
 * @author Todd Pickell CISS 238
 * Chapter 5
 * Programming Challenge 5 pg 327
 */
import java.text.DecimalFormat;
import java.util.Scanner;


public class HotelOccupancy {

    /**
     * main method
     * creates new Hotel object
     * calls iterateFloors then displayTotals
     * passing in the Hotel object
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Hotel newHotel = new Hotel();
        
        interateFloors(newHotel);
        
        displayTotals(newHotel);
        
    }//end main
    
    /**
     * method to prompt user for input 
     * displays string passed in for question
     * gets integer value from prompt
     * validates that it's within acceptable range
     * returns accepted integer value
     * @param stringIn
     * @param minValue
     * @param maxValue
     * @return integer
     */
    public static int getInput(String stringIn, int minValue, int maxValue)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        if(!keyboard.hasNextInt())
        {
            System.out.println("***Not a Number***\nPlease try again.\n");
            System.out.println(stringIn);
            keyboard.nextLine();
        }
        int input = keyboard.nextInt();
        while(input < minValue)
        {
            System.out.println("***Number too small***\nPlease try again.\n");
            System.out.println(stringIn);
            input = keyboard.nextInt();
            continue;
        }
        while(input > maxValue)
        {
            System.out.println("***Number too large***\nPlease try again.\n");
            System.out.println(stringIn);
            input = keyboard.nextInt();
            continue;
        }
        return input;
    }//end getInput
    
    /**
     * method to iterate through all floors of hotel
     * it set the number of floors in the hotel object
     * then sets the number of rooms and number occupied on each floor
     * takes in Hotel object, 
     * calls getInput method to prompt user
     * @param localHotel 
     */
    public static void interateFloors(Hotel localHotel)
    {
        localHotel.setNumFloors(getInput("Enter number of floors: ", localHotel.getMinFloors(), localHotel.getMaxFloors()));
        for(int i=1; i <= localHotel.getNumFloors(); i++)
        {
            int roomsOnCurrentFloor = getInput("Enter number of rooms on floor " + i + ":", localHotel.getMinRooms(),localHotel.getMaxRooms());
            localHotel.addToRooms(roomsOnCurrentFloor);
            int occupiedOnCurrentFloor = getInput("Enter number occupied on floor " + i + ":", 0, roomsOnCurrentFloor);
            localHotel.addToOccupado(occupiedOnCurrentFloor);
        }
    }//end itereateFloors
    
    /**
     * method to display the totals after all data has been added
     * uses DecimalFormat to display the occupancy rate as a percentage
     * calculates vacant by subtracting total rooms - rooms occupied
     * @param localHotel 
     */
    public static void displayTotals(Hotel localHotel)
    {
        DecimalFormat rate = new DecimalFormat("#0%");
        System.out.println("The total number of floors are: " + localHotel.getNumFloors());
        System.out.println("The total number of rooms are: " + localHotel.getNumRooms());
        System.out.println("The total number occupied is: " + localHotel.getOccupado());
        System.out.println("The total number vacant is: " + (localHotel.getNumRooms() - localHotel.getOccupado()));
        System.out.println("The occupancy rate is: " + rate.format(localHotel.occupancyRate()));
    }//end displayTotals
}

