package Matrix;

//https://leetcode.com/problems/set-matrix-zeroes/
//in such pblm replace element other than 0 or 1
//set other values and modify outside the modification loop
public class SetZeroMatrix {

	public static void main(String[] args) {
		
		int[][]matrix = {
				  {1,1,1},
				  {1,0,1},
				  {1,1,1}
				};

		setZeroes(matrix);
	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void setZeroes(int[][] matrix) {
		
		int modify = -100000; //trick
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				if(matrix[i][j]==0) {
					
					
					for (int c = 0; c < matrix[i].length; c++) {
						
						  if(matrix[i][c]!=0) {
							  matrix[i][c] = modify;
						  }
					}
					
					for (int r = 0; r < matrix.length; r++) {
						
						  if(matrix[r][j]!=0) {
							  matrix[r][j] = modify;
						  }
					}
					
				}
				
				
			}
		}
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				if(matrix[i][j]==modify) {
					matrix[i][j] = 0;
				}
			}
		}
		
		
	}

}
