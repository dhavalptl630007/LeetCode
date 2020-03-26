package String;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String X = "ABCBDAB";
		String Y = "BDCABA";

		int m = X.length();
		int n = Y.length();

		int c[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}

		for (int j = 0; j <= n; j++) {
			c[0][j] = 0;
		}
         
		
		for(int i = 1 ; i<=m; i++) {
			
			 for(int j = 1; j<=n; j++) {
				 
				 
				 if(X.charAt(i-1) == Y.charAt(j-1)) {
					 
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
		//System.out.println("test");

	}

	private static void print_LCS(String x, String y, int [][]c,int i, int j) {
		// TODO Auto-generated method stub
		
		if(i == 0 || j ==0) {
			return;
		}
		
		if(x.charAt(i-1) == y.charAt(j-1)) {
			
			print_LCS(x, y, c, i-1,j-1);
			System.out.print(x.charAt(i-1));
			
		}
		else if (c[i-1][j] >= c[i][j-1]) {
			print_LCS(x, y, c, i-1,j);
			
		}
		else
		{
			print_LCS(x, y, c, i,j-1);
		}
	//	else if ( )
		
	}

}
