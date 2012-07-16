package chapter4;

/**
 * Software Sales Class Demo
 * @author Todd Pickell CISS 238
 * Chapter 4
 * Programming Challenge 4 pg 257
 */
public class SoftwareSalesDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Driver file to test SoftwareSales class
        
        SoftwareSales Sale1 = new SoftwareSales();
        
        System.out.println(Sale1.calculateSale(21));
        System.out.println(Sale1.getDiscount());
        
        SoftwareSales Sale2 = new SoftwareSales();
        
        System.out.println(Sale2.calculateSale(14));
        System.out.println(Sale2.getDiscount());
        
        SoftwareSales Sale3 = new SoftwareSales();
        
        System.out.println(Sale3.calculateSale(53));
        System.out.println(Sale3.getDiscount());
        
        SoftwareSales Sale4 = new SoftwareSales();
        
        System.out.println(Sale4.calculateSale(123));
        System.out.println(Sale4.getDiscount());
        
        SoftwareSales Sale5 = new SoftwareSales();
        
        System.out.println(Sale5.calculateSale(3));
        System.out.println(Sale5.getDiscount());
    }
}
