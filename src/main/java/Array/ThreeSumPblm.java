package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/discuss/317216/Optimized-java-solution
//lookfor better solution
public class ThreeSumPblm {

	public static void main(String[] args) {
		
		int nums[] = {-1, 0, 1, 2, -1, -4 };
		
		System.out.println(threeSum(nums));

	}

	private static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0 || nums == null) {
		 	return res;
		}
		
		Arrays.sort(nums);
		
		for (int i = nums.length-1; i > 1; i--) {
			
			int third = nums[i];
			int l = 0;
			int r = i-1;
			
			while(l<r) {
				
				List<Integer> list = new ArrayList<>();
				int twoSum = nums[l]+nums[r];
				
				if(twoSum == -third) {
					
					list = Arrays.asList(nums[l],nums[r],third);
					
					if(!res.contains(list)) {
						res.add(list);
					}
					
				}
				
				if(twoSum <-third) {
					l++;
				}
				else {
					r--;
				}
				
			}
			
			
		}
		
	 return res;	
	}

}
