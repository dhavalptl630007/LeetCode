package Array;

public class DividNum {

	public static void main(String[] args) {
		
		System.out.println(divide(-2147483648,-1));
        System.out.println(25%5);
        System.out.println(25/5);
	}
	
	  public static int divide(int dividend, int divisor) {
	        
	        int new_dividend;
	        int new_divisor;
	        
	        if(dividend<0) {
	        	new_dividend = 0 - dividend;
	        	
	        }
	        else {
	        	new_dividend = dividend;
	        }
	        if (divisor<0) {
	        	new_divisor = - divisor;
	        }
	        else {
	        	new_divisor = divisor;
	        }
	        int ans = 0;
	        
	        if (new_dividend >=new_divisor){
	            ans = 1;
	        }
	        else{
	            ans = 0;
	        }
	        int remainder = new_dividend-new_divisor;
	        while(remainder>new_divisor){
	            remainder = remainder-new_divisor;
	            ans++;
	        }
	        
	        if(dividend <0 && divisor<0 ){
	            return ans;
	        }
	        else if (dividend<0 || divisor<0){
	            return -ans;
	        }
	        
	        return ans;
	        
	
	    }

}
