package Partition;
//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

public class MinimumDifferencePartition {

	public static void main(String[] args) {
	
        int nums[] = {1,2,3,4,5};
        
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
        	totalSum = totalSum+nums[i];
		}
       
        
        System.out.println(partition(nums,n,0,totalSum));
     
        
	}

	private static int partition(int[] nums, int n, int newSum, int totalSum) {
		
		if(n == 0) {
			
			return( Math.abs ((totalSum-newSum)-newSum));
		}
		
		return Math.min(partition(nums,n-1,newSum+nums[n-1],totalSum),partition(nums,n-1,newSum,totalSum));
	}

}
