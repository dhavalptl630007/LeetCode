package Array;

//https://www.geeksforgeeks.org/window-sliding-technique/
public class SlidingWindow {

	public static void main(String[] args) {
		
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20};
		int k = 4;
		System.out.println(maxSubArray(arr,k));
		

	}

	private static int maxSubArray(int[] arr, int k) {
		
		int max_sum = 0;
		
		for (int i = 0; i<k;i++)
			 max_sum+=arr[i];
		
		int curr_sum = max_sum;
		
		for (int i = k;i<arr.length;i++) {
			curr_sum = curr_sum + arr[i]-arr[i-k];
			max_sum = Math.max(curr_sum, max_sum);
		}
		
		return max_sum;
	}

}
