package chapter3;

/**
 * Employee Class Demo
 * @author Todd Pickell CISS 238
 * 3/19/12
 * Chapter 3
 * Programming Challenge 1 pg 177
 */
public class EmployeeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create employee objects
        Employee emp1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee emp2 = new Employee("Mark Jones", 39119, "IT", "Programmer");
        Employee emp3 = new Employee("Joy Rodgers", 81774, "Manufacturing", "Engineer");
        
        // store employees
        Employee[] Emps = new Employee[3];
        Emps[0] = emp1;
        Emps[1] = emp2;
        Emps[2] = emp3;
        
        // display employee records
        for(int i = 0; i < 3; i++)
        {
            System.out.println(Emps[i].getName());
            System.out.println(Emps[i].getIdNumber());
            System.out.println(Emps[i].getDeptartment());
            System.out.println(Emps[i].getPosistion());
            System.out.println();
        }  
        
    }
}
