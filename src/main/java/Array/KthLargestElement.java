package Array;

//https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthLargestElement {

	public static void main(String[] args) {
		
		int nums[] = {3,2,3,1,2,4,5,5,6};

		
		Arrays.sort(nums);
		
        int k= 4;
        int i = nums.length;
	
        System.out.println(nums[i-k]);
		
	}

}
