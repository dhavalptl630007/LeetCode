package String;

import java.util.HashMap;
import java.util.Map;

public class FractionRecurring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(2,3));
	}

	
	 public static String fractionToDecimal(int numerator, int denominator) {
	        
	        // If numerator is 0 (=> result = 0) no negative sign in result
	        String sign = (numerator != 0) && (numerator < 0 ^ denominator < 0) ? "-" : "";
	        long absNum = Math.abs((long) numerator), absDen = Math.abs((long) denominator);
	        String integerPart = String.valueOf(absNum / absDen);
	        
	        if(absNum % absDen == 0) {
	            return sign + integerPart;
	        }
	        
	        StringBuilder decimalPart = new StringBuilder();    
	        long reminder = absNum % absDen;
	        
	        // The first time we saw this reminder in positions after decimal point- 
	        // For example, we would see 4/6 for the first time in 1/6 at 0.1|6|666... i.e. pos 2
	        // This is to identify repeating decimals
	        Map<Long, Integer> reminderPositions = new HashMap<>();
	        
	        while(reminder != 0) {
	            if(reminderPositions.containsKey(reminder)) {
	                decimalPart.insert(reminderPositions.get(reminder), "(");
	                decimalPart.append(")");
	                break;
	            }
	            
	            reminderPositions.put(reminder, decimalPart.length());
	            decimalPart.append(String.valueOf(reminder * 10 / absDen));
	            reminder = (reminder * 10) % absDen;
	        }
	        
	        return sign + integerPart + "." + decimalPart.toString();
	    }
}
