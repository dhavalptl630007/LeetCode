package Matrix;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/rotate-image/
public class RotateImage {

	public static void main(String[] args) {
		
		int matrix[][] = 
			{
				  {1,2,3},
				  {4,5,6},
				  {7,8,9}
		};

		rotate(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			 for(int j = 0; j<matrix[i].length;j++){
				 System.out.print(matrix[i][j]+" ");
			 }
			 System.out.println();
		}
		
	}

	private static void rotate(int[][] matrix) {
		
		 if(matrix.length == 0 || matrix == null){
	            return;
	        }
	        
	        Collections.reverse(Arrays.asList(matrix));
	        
	        for(int i = 0; i<matrix.length;i++){
	            for(int j = i; j<matrix[i].length;j++){
	                int temp = matrix[i][j];
	                matrix[i][j]= matrix[j][i];
	                matrix[j][i]= temp;
	            }
	        }
	        
		
	}

}
