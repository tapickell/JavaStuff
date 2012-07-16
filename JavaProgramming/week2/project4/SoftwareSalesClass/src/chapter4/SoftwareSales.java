package chapter4;

/**
 * Software Sales Class
 * @author Todd Pickell CISS 238
 * Chapter 4
 * Programming Challenge 4 pg 257
 */
public class SoftwareSales {
    
    private int unitsSold;
    private double totalCost;
    private double unitCost = 99.00;
    private double discount;
    
    private void setUnitsSold(int intIn)
    {
        unitsSold = intIn;
    }
    
    private void calcDiscount()
    {
        if(unitsSold >= 1 && unitsSold <= 9) {
            discount = 1.0;
        }
        if(unitsSold >= 10 && unitsSold <= 19) {
            discount = 0.8;
        }
        if(unitsSold >= 20 && unitsSold <= 49) {
            discount = 0.7;
        }
        if(unitsSold > 50 && unitsSold <= 99) {
            discount = 0.6;
        }
        if(unitsSold >= 100) {
            discount = 0.5;
        }
    }
    
    private void setTotalCost()
    {
        totalCost = (unitsSold * unitCost) * discount;
    }
    
    public double calculateSale(int intIn)
    {
        setUnitsSold(intIn);
        calcDiscount();
        setTotalCost();
        return totalCost;
    }
    
    public double getDiscount()
    {
        return discount;
    }
}
