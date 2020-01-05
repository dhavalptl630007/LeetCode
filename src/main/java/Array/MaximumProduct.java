package Array;
//https://leetcode.com/problems/maximum-product-subarray/submissions/
//same like kadane's algorithm with little moddification
public class MaximumProduct {

	public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(maxProduct(nums));
	}

	  public static int maxProduct(int[] nums) {
	        
	      if(nums==null||nums.length==0) return 0;
	        int max = nums[0];
	        int min = nums[0];
	        int ans = nums[0];
	        int temp;
	        for(int i=1;i<nums.length;i++) {
	            if(nums[i]<0) {
	                temp = max;
	                max = min;
	                min = temp;
	            }
	            max = Integer.max(nums[i],nums[i]*max);
	            min = Integer.min(nums[i],nums[i]*min);
	            ans = Integer.max(ans,max);
	        }
	        return ans;
	        
	    }
}
