package Partition;

import java.util.HashMap;

//https://youtu.be/3N47yKRDed0
//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSum {

	public static void main(String[] args) {
	
		int nums[] = {1, 5, 11, 5};

		System.out.println(canPartition(nums));
		
	}

	private static boolean canPartition(int[] nums) {
		// TODO Auto-generated method stub
		
		int total = 0;
		
		for(int i : nums) {
			total+=i;
		}
		
		if(total%2 !=0) {
			return false;
		}
		
		
		return canPartition(nums,0,0,total,new HashMap<String,Boolean>());
	}

	private static boolean canPartition(int[] nums, int i, int sum, int total, HashMap<String,Boolean> state) {
		
		String current = i +""+sum;
		
		if(state.containsKey(current)) {
			return state.get(current);
		}
		
		if(sum*2 == total) {
			return true;
		}
		
		if(sum > total/2 || i>=nums.length ) {
			return false;
		}
		
		boolean foundState = canPartition(nums,i+1,sum,total,state) ||canPartition(nums,i+1,sum+nums[i],total,state);
		
		state.put(current, foundState);
		return foundState;
	}

}
