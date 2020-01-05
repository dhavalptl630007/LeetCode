package Array;

//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
//binary search // array do not have duplicate values
public class RotateSortedArray {

	public static void main(String[] args) {

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(search(nums, 0));

	}

	private static int search(int[] nums, int target) {

		if (nums.length == 0 || nums == null) {
			return -1;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {

			if (nums[i] == target) {
				return i;
			} else if (nums[j] == target) {
				return j;
			}
			i++;
			j--;
		}

		return -1;
	}

}
