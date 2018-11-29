import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Lab 13
 * 
 * This class creates a GUI for simple calculator application
 * 
 * @author CS2334. Modified by: Stephen
 * @version 2018-11-28
 */
public class CalculatorFrame extends JFrame
{
    /** Use default UID */
    private static final long serialVersionUID = 1L;

    /** panel for slider */
    JPanel panel0 = new JPanel();
    /** panel for the binary inputs */
    JPanel panel1 = new JPanel(new GridLayout(5, 0));
    /** panel for the error message */
    JPanel panel2 = new JPanel();
    /** panel for the calculate result button */
    JPanel panel3 = new JPanel();
    /** panel for the radio buttons */
    JPanel panel4 = new JPanel();

    /** Group of operation buttons */
    ButtonGroup ops = new ButtonGroup();

    /** Calculate result button */
    JButton button = new JButton("Calculate Result");

    /** Text that describes which operator is being used */
    JLabel opSign = new JLabel();
    /** Text that display an equals sign*/
    JLabel equalsSign = new JLabel("=  ");
    /** Text that display an error message */
    JLabel errorMessage = new JLabel();

    /** JSlider for the user's first input */
    JSlider slider = new JSlider(0, 10, 5);
    /** Text field for the user's first input */
    JTextField firstBox = new JTextField(5);
    /** Text field for the user's second input */
    JTextField secondBox = new JTextField(5);
    /** Text field for the computed result */
    JTextField computeResult = new JTextField();

    /** add operation radio button */
    JRadioButton add = new JRadioButton("+");
    /** multiply operation radio button */
    JRadioButton multiply = new JRadioButton("*");
    /** divide operation radio button */
    JRadioButton divide = new JRadioButton("/");
    /** equality operation radio button */
    JRadioButton equality = new JRadioButton("==");

    /**
     * This method builds and operates the GUI window.
     * @param title The title of the window.
     */
    public CalculatorFrame(String title) {
        super(title);

        /**************************************************/
        /** Setup Section: You should not change this... **/
        
        // Set Alignment of the JTextField and Jlabel
        firstBox.setHorizontalAlignment(JTextField.RIGHT);
        secondBox.setHorizontalAlignment(JTextField.RIGHT);
        opSign.setHorizontalAlignment(JLabel.RIGHT);
        equalsSign.setHorizontalAlignment(JLabel.RIGHT);
        computeResult.setHorizontalAlignment(JTextField.RIGHT);
        
        // Set the slider display configuration:
        slider.setMinorTickSpacing(1); 
        slider.setMajorTickSpacing(2); 
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        
        Hashtable<Integer, JLabel> labelTable  = new Hashtable<Integer, JLabel>(); 
        labelTable.put(0, new JLabel("0")); 
        labelTable.put(5, new JLabel("5"));
        labelTable.put(10,  new JLabel("10"));
        slider.setLabelTable(labelTable); 
        slider.setPaintLabels(true);
        
        firstBox.setText("5");  // Set to match slider

        // Change firstBox and computeResult to be non-editable
        firstBox.setEditable(false);
        computeResult.setEditable(false);
        
        //add the operation radio buttons to the button group
        //this makes is so that only one radio button can be selected at any given time
        ops.add(add);
        ops.add(multiply);
        ops.add(divide);
        ops.add(equality);

        //sets the layout grid for the GUI of dimension 4*5
        setLayout(new GridLayout(5, 0));
        /** End Setup Section: You should not change the code above... **/
        /****************************************************************/

        // Here we are adding elements into panels. The first panel has all elements added into it.
        panel1.add(firstBox);
        panel1.add(opSign);
        panel1.add(secondBox); 
        panel1.add(equalsSign);
        panel1.add(computeResult);
        
        //Error message added to panel
        panel2.add(errorMessage);
        
        //Calculate button added
        panel3.add(button);
        
        //Symbols added
        panel4.add(add);
        panel4.add(multiply);
        panel4.add(divide);
        panel4.add(equality);
        
        //Slider added
        panel0.add(slider);
        
        //Panels added to frame       
        add(panel0);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        
        //default to + operator
        add.setSelected(true);  //remember, the button group ensures only one button is selected
        opSign.setText("+  ");

        /*
         * When a button is pressed it should:
         * (1) change the opSign text to the name of the respective radio Button (+, *, /, ==)
         * (2) clear the computeResult text field
         * (3) clear the errorMessage text field
         * 
         * Note: pressing the button sets it to be selected. Because the buttons are in a button
         * group, when one button is selected all other buttons will be deselected. As such, you
         * should not add any code to explicitly set the buttons to be selected.
         * 
         * ActionListeners wait for the program to send them an event. In this case, an event
         * occurs when we press a button. Once that event happens, the code inside the actionPerformed
         * method is executed. Thus, we are coding here what the program should do when a button is
         * pressed. We add action listeners to each of the radio buttons.
         * 
         * The action listener completes the 3 above tasks
         */
        
        //Adds an action to the add button
        add.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	// Change the opSign, clear the error message and compute result on every click.
            	opSign.setText("+  "); 
            	computeResult.getText();
            	errorMessage.setText("");
            	
            } 
        });
        
        //Adds an action to the multiply button
        multiply.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	// Change the opSign, clear the error message and compute result on every click.
            	opSign.setText("*  "); 
            	computeResult.getText();
            	errorMessage.setText("");
            }
        });
        
        //Adds an action to the divide button
        divide.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	// Change the opSign, clear the error message and compute result on every click.
            	opSign.setText("/  "); 
            	computeResult.getText();
            	errorMessage.setText("");
            }
        });
        
        //Adds an action to the equality button
        equality.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	// Change the opSign, clear the error message and compute result on every click.
            	opSign.setText("==  "); 
            	computeResult.getText();
            	errorMessage.setText("");
            }
        }
        );
        
        
        /*
         * Set the Change Listener for the Slider. When a change
         * occurs, the text in firstBox should be set to the slider value.
         * 
         * The text in the computeResult and errorMessage should also be cleared.
         * 
         * ChangeListener is a type of listener like ActionListener. Events are
         * sent to it when the slider is changed. The method called is stateChanged
         * instead of actionPerformed for this listener.
         */
        slider.addChangeListener(new ChangeListener() 
        {
        	public void stateChanged(ChangeEvent e) 
        	{
        		// Changed the text in the first JTextField. Clear error and result
        		errorMessage.setText("");
        		computeResult.setText("");
        		//Sets the slider value to the number value
        		String value = "" + slider.getValue();
        		firstBox.setText(value);
        		
            }
        });

        /*
         * When the Calculate Result Button is pressed, 
         * get the values from the text fields and calculate the 
         * appropriate result using the four different operators (+, *, /, ==).
         * 
         * You need to check which operation (button) is selected to decide what to do.
         * You may need to look at the JRadioButton API to determine how best to do this.
         * 
         * (1) + operation: add the integer values from firstBox and secondBox.
         * 					Set computeResult to the result.
         * (2) - operation: subtract the integer value of secondBox from firstBox.
         * 					Set computeResult to the result.
         * (3) / operation: divide the integer value of firstBox by secondBox.
         * 					Set computeResult to the result.
         * (4) == operation: if the integer value of firstBox == secondBox, set computeResult to
         * 					 the string "True". Else, set computeResult to the string "False".
         * 
         * You should reset errorMessage when the computation succeeds.
         * You should reset computeResult when you encounter an error.
         */
        
        //Makes the button an action button
        button.addActionListener(new ActionListener() 
        {
        	/**
        	 * Calculate statistics for desired button
        	 */
            public void actionPerformed(ActionEvent e) 
            {
            	/**
            	 * Calculates statistics for what button is pushed
            	 */
            	try 
            	{
                    /**
                     * Calculate statistics for add values                            		
                     */
            		if (add.isSelected())
            		{
            			//Gets both number from the lines
            			int value1 = slider.getValue();
            			int value2 = Integer.parseInt(secondBox.getText());
            			//Adds them and makes them a string
            			String value = "" + (value1+value2);
            			computeResult.setText(value);
            		}
            		
            		/**
            		 * Calculate statistics for divide statistics
            		 */
            		else if (divide.isSelected())
            		{
            			//Gets both numbers from the lines
            			int value1 = slider.getValue();
            			int value2 = Integer.parseInt(secondBox.getText());
            			//Divides them and makes it a string
            			String value = "" + (value1/value2);
            			computeResult.setText(value);
            		}
            		
            		/**
            		 * Calculate statistics for multiply statistics 
            		 */
            		else if (multiply.isSelected())
            		{
            			//Gets both numbers from the lines
            			int value1 = slider.getValue();
            			int value2 = Integer.parseInt(secondBox.getText());
            			//Multiples them and makes it a string
            			String value = "" + (value1*value2);
            			computeResult.setText(value);
            		}
            		
            		/**
            		 * Calculate statistics for equality statement
            		 */
            		else if (equality.isSelected())
            		{
            			//Casts boolean of if the values are equal to string
            			String value = "" + (firstBox.getText().equals(secondBox.getText()));
            			computeResult.setText(value);
            		}
            		
                    // Clear the error message text field:
                    errorMessage.setText("");
                }
                // Check for errors:
                // (1) A number entered is not an integer -> NumberFormatException
                // (2) Divide by zero -> ArithmeticException
            	/**
            	 * Checks for errors
            	 */
                catch (NumberFormatException error) 
            	{
                	//Sets error message
                	errorMessage.setText("ERROR: Please enter a valid integer.");
                	//Clears results
                	computeResult.setText("");
                }
            	/**
            	 * Checks for errors
            	 */
            	catch (ArithmeticException error) 
            	{
                	//Sets error message
                	errorMessage.setText("ERROR: Tried to divide by 0.");
                	//Clears results
                	computeResult.setText("");
                }
            }
        });

        // Configuring of the frame
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Used to create the Calculator Frame
     * @param args
     * command-line arguments - not used
     */
    public static void main(String[] args) {
        new CalculatorFrame("Calculator Window");
    }
}
