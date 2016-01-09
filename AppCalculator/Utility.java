/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppCalculator;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author Olena
 */
public class Utility {
    
    public static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch (operator) {
            case "＋": return left.add(right);
            case "－": return left.subtract(right);
            case "×": return left.multiply(right);
            case "÷": return left.divide(right, MathContext.DECIMAL32);
        }
        return right;  // TODO: consider
    }
    
    public static Boolean isInRange(BigDecimal bd) {
        
        BigDecimal min = new BigDecimal(0);
        BigDecimal max = new BigDecimal(360);
        
        if ((bd.compareTo(min) == 1 || bd.compareTo(min) == 0) 
                && (bd.compareTo(max) == -1 || bd.compareTo(max) == 0))
            return true;
        else return false;
    }    
    
}
