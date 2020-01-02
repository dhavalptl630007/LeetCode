package Arrangement;

import java.util.Arrays;
import java.util.Comparator;

//brute force approach : https://youtu.be/pETdRT9M7ys
//string builder is used to handle delete operation and to handle scenarios like
// [0,0,0]
// another solution: https://www.programcreek.com/2014/02/leetcode-largest-number-java/

public class ArrangementLargestNumber {

	public static void main(String[] args) {

		//int nums[] = {3,30,34,5,9};
		int nums[] = {10,2};
		// int nums[] = {999999998,999999997,999999999}; //long is used to handle this
		// scenario
		//int nums[] = { 0, 0 };
		//System.out.println(largestNumber(nums));
        System.out.println(largestNumberV1(nums));
	}

	private static String largestNumberV1(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return null;
		}
		
		String arr[] = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String a, String b) {
				
				return (b+a).compareTo(a+b);
			}
						
		});
		
		
		String result = "";

		for (int i = 0; i < arr.length; i++) {
			result = result + arr[i];
		}

		StringBuilder sb = new StringBuilder(result);

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
		
	}

	private static String largestNumber(int[] nums) {

		if (nums.length == 0 || nums == null) {
			return null;
		}

		int temp;
		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				if (specialLarger(nums[i], nums[j])) {

					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;

				}
			}

		}

		String result = "";

		for (int i = 0; i < nums.length; i++) {
			result = result + nums[i];
		}

		StringBuilder sb = new StringBuilder(result);

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();

	}

	private static boolean specialLarger(int x, int y) {

		String a = String.valueOf(x);
		String b = String.valueOf(y);

		String c = a + b;
		String d = b + a;

		if (Long.parseLong(d) > Long.parseLong(c)) {
			return true;
		}

		return false;
	}

}
