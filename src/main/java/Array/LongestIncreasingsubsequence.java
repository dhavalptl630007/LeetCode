package Array;

import java.util.Arrays;

public class LongestIncreasingsubsequence {

	public static void main(String[] args) {
		
	//int X[] = {5,6,2,3,4,1,9,9,8,9,5};
	
	 int X[] = { 10, 3, 12, 18, 30, 4, 6, 21, 7, 20};

	 int Y[] = X.clone();
	 
	 Arrays.sort(Y);

		int m = X.length;
		int n = Y.length;

		int c[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}

		for (int j = 0; j <= n; j++) {
			c[0][j] = 0;
		}
         
		
		for(int i = 1 ; i<=m; i++) {
			
			 for(int j = 1; j<=n; j++) {
				 
				 
				 if(X[i-1] == Y[j-1]) {
					 
					 c[i][j] = c[i-1][j-1]+1;
				 }
				 
				 else if (c[i-1][j] >= c[i][j-1]) {
					 
					 c[i][j] = c[i-1][j];
				 }
				 else
				 {
					 c[i][j] = c[i][j-1];
				 }
				 
				 
			 }
			
		}
		
		for (int i = 0; i <=m; i++) {
			
			for (int j = 0; j <=n; j++) {
				
				System.out.print(c[i][j]+ " ");
			}
			System.out.println();
		}
		
	    print_LCS(X, Y, c, m, n);
		
	}
      
	
	private static void print_LCS(int[] x, int[] y, int [][]c,int i, int j) {
		// TODO Auto-generated method stub
		
		if(i == 0 || j ==0) {
			return;
		}
		
		if(x[i-1] == y[j-1]) {
			
			print_LCS(x, y, c, i-1,j-1);
			System.out.print(x[i-1]);
			
		}
		else if (c[i-1][j] >= c[i][j-1]) {
			print_LCS(x, y, c, i-1,j);
			
		}
		else
		{
			print_LCS(x, y, c, i,j-1);
		}
		
	}
	
}
