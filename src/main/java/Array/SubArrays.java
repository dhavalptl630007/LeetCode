package Array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubArrays {

	public static void main(String[] args) {

		Integer a[] = { 4, 2, 3, 4 };
		Arrays.sort(a);
		List<Integer> list =  Arrays.asList(a);
		Collections.reverse(list);
		System.out.println(list);

		for (int i = 0; i < a.length; i++) {

			for (int k = i; k < a.length; k++) {
				for (int j = i; j <= k; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}

			System.out.println();
		}

	}

}
