package Array;

//https://leetcode.com/problems/minimum-size-subarray-sum/
//two-pointer solution

public class MinSubArrayLen {

	public static void main(String[] args) {
		
		int nums [] = {2,3,1,2,4,3};
		
		System.out.println(minSubArrayLen(7,nums));

	}

	private static int minSubArrayLen(int s, int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		
		for (int j = 0; j < nums.length; j++) {
			
			sum = sum + nums[j];
			
			while(sum >= s) {
				
				ans = Math.min(ans, j-left+1);
				sum = sum - nums[left];
				left++;
			}
			
		}
		
		if(ans == Integer.MAX_VALUE ) {
			return 0;
		}
		
		return ans;
	}
}
