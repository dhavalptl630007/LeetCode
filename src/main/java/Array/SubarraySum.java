package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/

public class SubarraySum {

	public static void main(String[] args) {
		
		int nums [] = {1,2,3};
		
		System.out.println(subarraySum(3,nums));
		System.out.println(subarraySum2(3,nums));

	}
	
	private static int subarraySum2(int k, int[] nums) {
		
		    int left = 0;
	        int right = 0;
	        int sum = 0;
	        int count = 0;
	        while(right<nums.length){
	            
	            while(sum<k){
	                   sum += nums[right];
	                   if(right<nums.length-1)
	  	                 right++;
	                   //right++;
	                  }
	            if(sum == k){
	            	count++;
	            	// sum = sum-nums[left]; 
	            	 //left++;
	            	 if(right<nums.length-1)
	                 right++;
	            }
	           while(sum>=k && left<nums.length){
	              
	               sum = sum-nums[left]; 
	               left++;
	           }
	            
	            //right++;
	        }    
	        
	       return count;
	}
	

	private static int subarraySum(int k, int[] nums) {
		
		/* no base condition becaues k could be 0 e.g [1,-1,1]
		if(k== 0 || nums.length == 0) {
			return 0;
		}*/
		
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		map.put(0, 1);
		
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			
			if(map.containsKey(sum-k)) {
				
				count = count + map.get(sum-k);
			}
			
			map.put(sum, map.getOrDefault(sum, 0)+1);
			
		}
		
		return count;
	}

}
