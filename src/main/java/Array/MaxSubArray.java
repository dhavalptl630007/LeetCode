package Array;

//https://leetcode.com/problems/maximum-subarray/submissions/
//Kadane's Algorithm
//here there is no target, hence may be sliding window can not  be applied 
// input contains the negative numbers
public class MaxSubArray {

	public static void main(String[] args) {
		
		int[]nums = {-2,1,-3,4,-1,2,1,-5,4};
	
		System.out.println(maxSubArray(nums));
	}

	private static int maxSubArray(int[] nums) {
		// TODO Auto-generated method stub
		
		if(nums.length== 0|| nums == null) {
			return 0;
		}
		
		int localsum = nums[0];
		int globalsum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			localsum = Math.max(nums[i], localsum+nums[i]);
			
			globalsum = Math.max(globalsum, localsum);
		}
		
		return globalsum;
		
	}

}
