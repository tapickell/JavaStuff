package chapter3;

/**
 * Employee Class
 * @author Todd Pickell CISS 238
 * 3/19/12
 * Chapter 3
 * Programming Challenge 1 pg 177
 */
public class Employee {
    // Fields
    private String name;
    private int idNumber;
    private String department;
    private String position;
    
    /**
     * Constructor
     * @param nameIn
     * @param intIn
     * @param deptIn
     * @param posIn  
     */
    public Employee(String nameIn, int intIn, String deptIn, String posIn)
    {
        name = nameIn;
        idNumber = intIn;
        department = deptIn;
        position = posIn;
    }
    
    /**
     *  setters
     */
    public void setName(String stringIn) {
        name = stringIn;
    }

    public void setIdNumber(int intIn) {
        idNumber = intIn;
    }

    public void setDepartment(String deptIn) {
        department = deptIn;
    }

    public void setPosition(String posIn) {
        position = posIn;
    }
    
    /**
     *  getters
     */
    public String getName() {
        return name;
    }
    
    public int getIdNumber() {
        return idNumber;
    }
    
    public String getDeptartment() {
        return department;
    }
    
    public String getPosistion() {
        return position;
    }
}
