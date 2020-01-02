package Matrix;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

	public static void main(String[] args) {
		
		int grid[][] =  {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		
		System.out.println(closedIsland(grid));

	}

	
	
	 public static int closedIsland(int[][] grid) {
		
		 //remember the base condition
		 if(grid == null || grid.length == 0 ){
	            return 0;
	        }
		 
		 int m = grid.length;
		 int n = grid[0].length;
		 int island = 0;
		 
		 for (int i = 0; i < m; i++) {
			
			 for (int j = 0; j < n; j++) {
				
				 if(grid[i][j]==1) {
					 
					 island++;
					 
					 DFS(grid,i,j);
				 }
				 
			}
			 
		}
		 
		 
		 
		 return island;
	               
	    }



	private static void DFS(int[][] grid, int i, int j) {
		
		if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0) {
			return;
		}
		
		grid[i][j] = 0;
		DFS(grid, i,j+1); //down
		DFS(grid, i,j-1);//up
		DFS(grid, i-1,j); //left
		DFS(grid, i+1,j);	//right
		
	}
	
}
