package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/diagonal-traverse/submissions/

public class DiagonalTraversalZigZIg {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int res[] = findDiagonalOrder(matrix);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}

	}

	public static int[] findDiagonalOrder(int[][] matrix) {

		if (matrix.length == 0 || matrix == null) {

			return new int[0];
		}

		int n = matrix.length;
		int m = matrix[0].length;
		int res[] = new int[n * m];
		List<Integer> list = new ArrayList<Integer>();

		int k = 0;

		for (int d = 0; d < n + m - 1; d++) {

		/*	int r = d < m ? 0 : d - m + 1;
			int c = d < m ? d : m - 1; */
			
			int r,c;
			if(d<m) { //conditions for first half
				r =0;
				c= d;
			}
			else //conditions for second half
			{
				r= d-m+1;
				c = m-1;
			}

			while (r < n && c > -1) {

				list.add(matrix[r][c]);
				r++;
				c--;
			}

			if (d % 2 == 0) {

				Collections.reverse(list);
			}

			for (int i = 0; i < list.size(); i++) {

				res[k++] = list.get(i);
			}

			list.clear();

		}

		return res;
	}

}
