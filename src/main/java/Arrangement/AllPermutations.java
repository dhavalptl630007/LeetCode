package Arrangement;

import java.util.ArrayList;
import java.util.List;

//https://youtu.be/idmgLLNIC2U
//https://www.programcreek.com/2013/02/leetcode-permutations-java/
//https://www.topcoder.com/generating-permutations/
public class AllPermutations {

	public static void main(String[] args) {

	    int nums[] = { 1, 2, 3 };
		System.out.println(permute(nums));

	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0 || nums == null) {
			return res;
		}

		boolean used[] = new boolean[nums.length];
		List<Integer> permutation = new ArrayList<>();
		helper(nums, used, permutation, res);

		return res;

	}

	public static void helper(int[] nums, boolean used[], List<Integer> permutation, List<List<Integer>> res) {

		if (permutation.size() == nums.length) {
			res.add(new ArrayList<>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (used[i]) {
				continue;
			}
			used[i] = true;
			permutation.add(nums[i]);
			helper(nums, used, permutation, res);
			permutation.remove(permutation.size() - 1);
			used[i] = false;
		}
	}

}
