package Array;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/discuss/463190/Java-Traverse-Backwards
// better solution

public class ReplaceElements {

	public static void main(String[] args) {

		int arr[] = { 17, 18, 5, 4, 6, 1 };

		int arr1[] = replaceElements(arr);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

	}

	public static int[] replaceElements(int[] arr) {

		if (arr == null || arr.length == 0) {
			return arr;
		}

		int max;
		for (int i = 0; i < arr.length - 1; i++) {
			max = 0;
			for (int j = i + 1; j < arr.length; j++) {

				max = Math.max(max, arr[j]);

			}

			arr[i] = max;
		}

		arr[arr.length - 1] = -1;

		return arr;
	}

}
