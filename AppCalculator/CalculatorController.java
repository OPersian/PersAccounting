/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppCalculator;

import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persaccounting.Auxiliaries.AlertManagement;
import persaccounting.Configs;
import persaccounting.Globals;

/**
 *
 * @author Olena
 */
public class CalculatorController {
    
    // private static ObservableList<String> styleSheets;
    // private AnchorPane rootPane = new AnchorPane();

    private String style1URL = getClass().
            getResource(Configs.calculator_style_1).toExternalForm();
    private String style2URL = getClass().
            getResource(Configs.calculator_style_2).toExternalForm();

    // TODO: refactor
    private BigDecimal left; // left_str_number
    private String selectedOperator;
    private boolean numberInputting;
    private String current_str_digit;
    private String whole_expression = "";    
    private String negative_number = "";    

    @FXML private Button btnStyle1;
    @FXML private Button btnStyle2;
    @FXML private TextField display; // result in particular
    @FXML private TextField wholeExpression;

    @FXML
    private void handleStyleButtonAction(ActionEvent e) {
        Button clicked = (Button)e.getSource();
        // styleSheets = rootPane.getStylesheets();
        // System.out.println(styleSheets);
        if (clicked == btnStyle1) {
            // Globals.mainScene.remove(style2URL);
            Globals.mainScene.add(style1URL);
        } else if (clicked == btnStyle2) {
            // Globals.mainScene.remove(style1URL);
            Globals.mainScene.add(style2URL);
        }
    }

    @FXML
    private void handleComputingButtonAction(ActionEvent event) {
        try {
            Button button = (Button)event.getSource();
            final String button_text = button.getText(); 

            if (button_text.equals("C")) {
                left = BigDecimal.ZERO;
                selectedOperator = "";
                numberInputting = false;
                current_str_digit = "0";
                whole_expression = "";
                display.setText(current_str_digit);            
                // return;
            }

            if (button_text.matches("[0-9\\.]")) {
                if (!numberInputting) {
                    numberInputting = true;
                    display.clear();
                    current_str_digit = "";
                }
                display.appendText(button_text);
                current_str_digit = button_text;
                whole_expression += button_text;
                // return;
            }

            if (button_text.matches("[＋－×÷]")) {
                if (!"".equals(display.getText()))
                    left = new BigDecimal(display.getText());

                selectedOperator = button_text;
                numberInputting = false;
                char a;
                int len = whole_expression.length();
                if (len >= 1) {
                    a = whole_expression.charAt(len-1);
                    if (Character.toString(a).matches("[＋－×÷]"))
                        whole_expression = 
                            whole_expression.substring(0, len-1) + button_text;
                    else whole_expression += button_text;
                } else { 
                    whole_expression += button_text;
                    if ("－".equals(button_text)) negative_number = "-";
                }                
                // return;
            }        

            if (button_text.equals("=")) {            
                final BigDecimal right = numberInputting ? 
                        new BigDecimal(display.getText()) : 
                        left;                
                /*
                // debug:
                System.out.print(left);
                System.out.print(selectedOperator);
                System.out.print(right);
                System.out.println("--------");
                */                
                
                if ("-".equals(negative_number)) {
                    left = Utils.calculate(selectedOperator, left, right).
                            negate();
                    negative_number = "";
                    // System.out.println(left);
                }
                else left = Utils.calculate(selectedOperator, left, right);
                
                // left = Utils.calculate(selectedOperator, left, right);
                
                current_str_digit = left.toString(); // result
                display.setText(current_str_digit);
                numberInputting = false;
                whole_expression = current_str_digit; // ""
                // return;            
            }
            
            if (button_text.equals("rad")) {
                if ("-".equals(negative_number)) {
                    left = new BigDecimal(display.getText()).negate();
                    negative_number = "";
                } else left = new BigDecimal(display.getText());
                
                System.out.println("-----left----" + left);  // debug
                
                if (Utils.isInRange(left) == true) {
                    double rad_result = Math.toRadians(left.doubleValue());
                    current_str_digit = Double.toString(rad_result); // result
                    display.setText(current_str_digit);
                    whole_expression = current_str_digit;
                }
                else {
                    AlertManagement.displayErrorAlert(
                          "performing math operations. "
                        + "\nPlease ensure you have correctly "
                        + "\nentered the numbers.", 
                        "Enter number between 0 and 360");
                    display.clear();
                    whole_expression = "";
                }                       
                
                // display.setText(current_str_digit);
                numberInputting = false;
                // whole_expression = "";
            }
            
            // TODO: implement
            // if (button_text.equals("+-"))
            
            wholeExpression.setText(whole_expression); 
        }        
        
        catch (Exception error) {
            AlertManagement.displayErrorAlert("performing math operations. "
                    + "\nPlease ensure you have correctly "
                    + "\nentered the numbers.", 
                    error.toString());
            error.printStackTrace(); // to debug in console mode
        }     
        
    }
}
