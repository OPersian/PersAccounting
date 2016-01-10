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
    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;
    private String current_str_number;
    private String whole_expression = "";    

    @FXML private Button btnSum;
    @FXML private Button btnSub;
    @FXML private Button btnMul;
    @FXML private Button btnDiv;
    @FXML private Button btnClear;
    @FXML private Button btnStyle1;
    @FXML private Button btnStyle2;
    @FXML private Button btnRad;
    @FXML private Button btnDigit2;
    @FXML private Button btnDigit1;
    @FXML private Button btnDigit3;
    @FXML private Button btnDigit4;
    @FXML private Button btnDigit5;
    @FXML private Button btnDigit7;
    @FXML private Button btnDigit8;
    @FXML private Button btnDigit6;
    @FXML private Button btnDigit9;
    @FXML private Button btnDigit0;
    @FXML private Button btnPoint;
    @FXML private Button btnEquals;
    @FXML private Button btnChangeNumber; // TODO: implement
    @FXML private TextField display;      // result in particular
    @FXML private TextField wholeExpression;
    @FXML private Button btnEraseLeft;    // TODO: implement

    @FXML
    private void handleStyleButtonAction(ActionEvent e) {
        Button clicked = (Button)e.getSource();
        // styleSheets = rootPane.getStylesheets();
        // System.out.println(styleSheets);
        if (clicked == btnStyle1) {
            Globals.mainScene.remove(style2URL);
            Globals.mainScene.add(style1URL);
        } else if (clicked == btnStyle2) {
            Globals.mainScene.remove(style1URL);
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
                current_str_number = "0";
                whole_expression = "";
                display.setText(current_str_number);            
                // return;
            }

            if (button_text.matches("[0-9\\.]")) {
                if (!numberInputting) {
                    numberInputting = true;
                    display.clear();
                    current_str_number = "";
                }
                display.appendText(button_text);
                current_str_number = button_text; // TODO: consider
                whole_expression += button_text;
                // return;
            }

            if (button_text.matches("[＋－×÷]")) {
                left = new BigDecimal(display.getText());
                // left = new BigDecimal(current_str_number);
                selectedOperator = button_text;
                numberInputting = false;
                char a;
                int len = whole_expression.length();
                if (len >= 1) {
                    a = whole_expression.charAt(len-1);
                    // System.out.println(a);
                    // System.out.println(Character.toString(a).matches("[＋－×÷]"));
                    if (Character.toString(a).matches("[＋－×÷]"))
                        whole_expression = whole_expression.substring(0, len-1) + button_text;
                    else whole_expression += button_text;
                }
                else whole_expression += button_text;
                // return;
            }        

            if (button_text.equals("=")) {            
                // final BigDecimal right = numberInputting ? new BigDecimal(display.getText()) : left;
                // System.out.println(numberInputting);  // debug
                final BigDecimal right = numberInputting ? new BigDecimal(current_str_number) : left;
                // System.out.println(selectedOperator);  // debug
                left = Utils.calculate(selectedOperator, left, right);
                current_str_number = left.toString(); // result
                display.setText(current_str_number);
                numberInputting = false;
                // System.out.println(current_str_number);  // debug
                whole_expression = "";
                // return;            
            }
            
            if (button_text.equals("rad")) {
                // TODO: fix: 360
                // System.out.print(current_str_number);  // null360              
                left = new BigDecimal(current_str_number);
                // System.out.print("-----left----" + left);
                
                if (Utils.isInRange(left) == true) {
                    double rad_result = Math.toRadians(left.doubleValue()); // TODO: test
                    current_str_number = Double.toString(rad_result); // result
                    display.setText(current_str_number);
                }
                else {
                    // current_str_number = "Enter number between 0 and 360"; // TODO: throw exception
                    AlertManagement.displayErrorAlert("performing math operations. "
                        + "\nPlease ensure you have correctly "
                        + "\nentered the numbers.", 
                        "Enter number between 0 and 360");
                    display.clear();
                }                       
                
                // display.setText(current_str_number);
                numberInputting = false;
                whole_expression = "";
            }
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
