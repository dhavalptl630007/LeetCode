package Array;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenDigits {

	public static void main(String[] args) {
		
		int nums[] = {12,345,2,6,7896};
	
			System.out.println(findNumbers(nums));
		

	}
	
	
	 public static int findNumbers(int[] nums) {
	        
	        if(nums == null || nums.length == 0){
	            return 0;
	        }
	        
	        int count = 0;
	        
	        for(int num : nums){
	            
	           if(Integer.toString(num).length() % 2 == 0){
	               
	               count++;
	           }
	            
	        }
	        
	        return count;
	    }

}
