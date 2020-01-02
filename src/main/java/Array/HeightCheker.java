package Array;

import java.util.Arrays;

public class HeightCheker {

	public static void main(String[] args) {

		int heights[] = { 1, 1, 4, 2, 1, 3 };

		System.out.println(heightChecker(heights));

	}

	private static int heightChecker(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}

		int tmp[] = heights.clone(); // copy array
		int count = 0;
		Arrays.sort(heights);
		for (int i = 0; i < heights.length; i++) {

			if (tmp[i] != heights[i]) {
				count++;
			}
		}
		return count;
	}

}
