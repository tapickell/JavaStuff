package chapter5;

/**
 * Hotel Class
 * @author Todd Pickell CISS 238
 * Chapter 5
 * Programming Challenge 5 pg 327
 */
public class Hotel {
    
    /**
     * private fields
     */
    private int numFloors;
    private int numRooms;
    private int numOccupado;
    private int minFloors;
    private int minRooms;
    private int maxFloors;
    private int maxRooms;
    
    
    /**
     * constructor 
     * initializes settings to zeros
     * and minimums to 1 & 10
     */
    public Hotel()
    {
        numFloors = 0;
        numRooms = 0;
        numOccupado = 0;
        minFloors = 1;
        minRooms = 10;
        maxFloors = 100;
        maxRooms = 250;
    }
    
    /**
     * setter methods for my fields
     * these all take in an integer
     * @param intIn
     */
    public void setNumFloors(int intIn)
    {
        numFloors = intIn;
    }
    
    public void setNumRooms(int intIn)
    {
        numRooms = intIn;
    }
    
    public void setNumOccupado(int intIn)
    {
        numOccupado = intIn;
    }
    
    /**
     * getter methods for my fields
     * these all return integers
     * @return
     */
    public int getNumFloors()
    {
        return numFloors;
    }
    
    public int getNumRooms()
    {
        return numRooms;
    }
    
    public int getOccupado()
    {
        return numOccupado;
    }
    
    public int getMinFloors()
    {
        return minFloors;
    }
    
    public int getMinRooms()
    {
        return minRooms;
    }
    
    public int getMaxFloors()
    {
        return maxFloors;
    }
    
    public int getMaxRooms()
    {
        return maxRooms;
    }
    
    /**
     * adds to the current number of rooms
     * to be used during each iteration of a floor
     * @param intIn
     */
    public void addToRooms(int intIn)
    {
        numRooms += intIn;
    }
    
    /**
     * add to the current number of occupied rooms
     * to be used during each iteration of a floor
     * @param intIn
     */
    public void addToOccupado(int intIn)
    {
        numOccupado += intIn;
    }
    
    /**
     * calculates the occupancy rate for the hotel
     * to be ran after all floors have been input
     * returns an integer
     * @return
     */
    public double occupancyRate()
    {
        double newDouble1 = (double)numOccupado;
        double newDouble2 = (double)numRooms;
        return  newDouble1 / newDouble2;
    }
    
}
