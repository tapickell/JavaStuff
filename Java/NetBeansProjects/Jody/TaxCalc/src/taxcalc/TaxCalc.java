/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalc;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author 
 */
public class TaxCalc extends JFrame {
    
    private final int MIN_TAX = 0;//minimum tax rate
    private final int MAX_TAX = 10;//maximum tax rate
    private final int INIT_TAX = 0;//initial tax rate

    private JTextField purchase;//amount of purchase
    private JTextField tax;//Sales tax (read-only text field)
    
    private JSlider slider;//to adjust sales tax rate
    private JPanel dataPanel;//panel to hold label & text field
    private JPanel sliderPanel;//panel to hold slider
    private JPanel taxPanel;//Panel to display the sales tax

    /**
     * Constructor
     */
    public TaxCalc() {
        super("Tax Calculator");//display a title
        
        //scpecify what happens when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       	//build the data panel
        buildDataPanel();
        
        //build slider panel
        buildSliderPanel();
        
        //build tax panel
        buildTaxPanel();
        
        //add panel to the context pane
        add(this.dataPanel, BorderLayout.NORTH);
        add(this.sliderPanel, BorderLayout.CENTER);
        add(this.taxPanel, BorderLayout.SOUTH);
        
        //pack and display the window
        pack();
        setVisible(true);

    }

    private void buildDataPanel() {
        
	//create a label to prompt the user to enter the amount of the purchase
	JLabel msg = new JLabel("Enter the amount of the purchase");
	
	//create a text field for the input
	purchase = new JTextField(10);
	
	//put the components into a field
	dataPanel = new JPanel();
	dataPanel.add(msg);
	dataPanel.add(purchase);
    }

    private void buildSliderPanel() {
        
        //create a lable to prompt the user to enter the amount of the purchase
        JLabel sliderMsg = new JLabel("Sales Tax Slider");
        
        //create new slider
        slider = new  JSlider(JSlider.HORIZONTAL, MIN_TAX, MAX_TAX, INIT_TAX);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        //add an event listener to the slider
        slider.addChangeListener(new SliderListener());
        
        //put the label and slider in a panel
        sliderPanel = new JPanel();
        sliderPanel.add(sliderMsg);
        sliderPanel.add(slider);
    }

    /**
     * build taxPanel Method 
     */
    private void buildTaxPanel() {
        
	//create a label identifying the sales tax
	JLabel taxMsg = new JLabel("Sales Tax");
	
	//create a read-only text field for tax
	tax = new JTextField(10);
	tax.setEditable(false);
	tax.setText("0.00");
	
	//put the label and text field in a panel
	taxPanel = new JPanel();
	taxPanel.add(taxMsg);
	taxPanel.add(tax);
    }
    
    
/**
 * SliderListener is an event Listener class for the slider
 */    

    private class SliderListener implements ChangeListener {

        public SliderListener() {
        }

        /**
	 * stateChanged method
	 */
        @Override
        public void stateChanged(ChangeEvent e) {
            

            //create decimalFormat
            DecimalFormat dollar = new DecimalFormat("#, ##.00");
            //changed from "#, ##.0.00" this would crash when using slider

            //get value
            if (purchase.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Enter the purchase amount");
            } else {
                //get tax rate
                //taxRate=slider.getValue()/100;
                Double taxRate = slider.getValue()/100.00; 
                //changed to 100.00 b/c it was giving you a int

                //calculate the sales tax
                //salesTax=Double.parseDouble(purchase.getText()) * taxRate;
                Double salesTax = Double.parseDouble(purchase.getText()) * taxRate;

                //Display the message
                tax.setText(dollar.format(salesTax));
            }//end ifelse
        }//end stateChanged
    }//end SliderListener
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaxCalc tc = new TaxCalc();
    }//end main
}//end class TaxCalc
