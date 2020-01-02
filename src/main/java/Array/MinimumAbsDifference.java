package Array;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/minimum-absolute-difference/

public class MinimumAbsDifference {

	public static void main(String[] args) {
		
		int arr[] = {4,2,1,3};
		
		System.out.println(minimumAbsDifference(arr));
		

	}

	private static ArrayList<ArrayList<Integer>> minimumAbsDifference(int[] arr) {
		// TODO Auto-generated method stub
		
		Arrays.sort(arr);
		
		int min = arr[1]-arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			
			min = Math.min(min,arr[i]-arr[i-1]);
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[i]-arr[i-1] == min) {
				
				result.add((ArrayList<Integer>) Arrays.asList(arr[i-1],arr[i]));
			}
		}
		
		return result;
	}

}
