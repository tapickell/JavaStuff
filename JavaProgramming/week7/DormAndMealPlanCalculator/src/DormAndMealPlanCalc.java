/**
 * DormAndMealPlanCalc Demo
 * @author Todd Pickell CISS 238
 * Chapter 12
 * Programming Challenge 3 pg 865
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * class for the dorm and meal plan calculator
 */
public class DormAndMealPlanCalc extends JFrame
{
    /**
     * private fields for panels, combo boxes and text field
     */
    private JPanel dormsPanel;
    private JPanel mealPanel;
    private JPanel chargesPanel;
    private JComboBox dormBox;
    private JComboBox mealBox;
    private JFormattedTextField chargeField;

    /**
     * arrays to hold data
     */
    private String[] dorms = {"Allen Hall", "Pike Hall", "Farthing Hall", "University Suites" };
    private String[] meals = {"7 meals per week", "14 meals per week", "Unlimited meals per week"};
    private int[] dormPrices = {1500, 1600, 1200, 1800};
    private int [] mealPrices = {560, 1095, 1500};

    /**
     * constructor
     */
    public DormAndMealPlanCalc()
    {
        super("Dorm and Meal Plan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildDormsPanel();
        buildMealPanel();
        buildChargesPanel();
        add(dormsPanel, BorderLayout.EAST);
        add(mealPanel, BorderLayout.WEST);
        add(chargesPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    /**
     * method that creates the panel, the label and the text field for total cost
     */
    private void buildChargesPanel()
    {
        chargesPanel = new JPanel();
        JLabel chargesLabel = new JLabel("Total charges for the semester");
        chargeField = new JFormattedTextField(java.text.NumberFormat.getCurrencyInstance());
        chargeField.setEditable(false);
        chargesPanel.add(chargesLabel);
        chargesPanel.add(chargeField);
        chargeField.setValue((dormPrices[0] + mealPrices[0]));   //sets initial value for text field
    }

    /**
     * method that creates the panel, label and combo box for selecting meal plan
     */
    private void buildMealPanel()
    {
        mealPanel = new JPanel();
        JLabel mealLabel = new JLabel("Meal Plans");
        mealBox = new JComboBox(meals);                 // pass the meal plan array to populate the combo box
        mealBox.addItemListener(new comboBoxListener());
        mealPanel.add(mealLabel);
        mealPanel.add(mealBox);
    }

    /**
     * method that creates the panel, label and combo box for selecting a dormitory
     */
    private void buildDormsPanel()
    {
        dormsPanel = new JPanel();
        JLabel dormLabel = new JLabel("Dormitories");
        dormBox = new JComboBox(dorms);               // pass the dormitories array to populate the combo box
        dormBox.addItemListener(new comboBoxListener());
        dormsPanel.add(dormLabel);
        dormsPanel.add(dormBox);
    }

    /**
     * nested class for my item listener
     * listener for both combo boxes to update the text field when changed
     * gets the index numbers of the current selected items in the combo boxes
     * and uses those to get the correct prices from the price arrays
     * then adds them and gets the string value of the result to display in the text field
     */
    private class comboBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            int mealIndex = mealBox.getSelectedIndex();
            int dormIndex = dormBox.getSelectedIndex();
            chargeField.setValue((dormPrices[dormIndex] + mealPrices[mealIndex]));
        }
    }

    /**
     * main method that creates an instance of my Dorm and meal plan calculator class
     * @param args
     */
    public static void main(String[] args)
    {
        new DormAndMealPlanCalc();
    }
}
