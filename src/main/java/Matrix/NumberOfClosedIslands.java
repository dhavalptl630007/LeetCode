package Matrix;

//https://leetcode.com/problems/number-of-closed-islands/submissions/
public class NumberOfClosedIslands {

	public static void main(String[] args) {

		// int grid[][] = {{1,1,1,1,1,1,1,0},
		// {1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};

		int grid[][] = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		System.out.println(closedIsland(grid));

	}

public static int closedIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0) {
			return 0;
		}
        
         int m = grid.length;
		 int n = grid[0].length;
        
        for (int j = 0; j < n ; j++) {
			
			if(grid[0][j] == 0) {
				//grid[0][j] = 1;
                DFS(grid,0,j);
			}
			if(grid[m-1][j] == 0) {
				//grid[m-1][j] = 1;
                 DFS(grid,m-1,j);
			}
			
		}
		
      for (int i = 0; i < m ; i++) {
			
			if(grid[i][0] == 0) {
				//grid[i][0] = 1;
                 DFS(grid,i,0);
			}
			if(grid[i][n-1] == 0) {
				//grid[i][n-1] = 1;
                DFS(grid,i,n-1);
			}
			
		}
        
		 int island = 0;
		 
		 for (int i = 0; i < m; i++) {
			
			 for (int j = 0; j < n; j++) {
				
				 if(grid[i][j]==0) {
					 
					 island++;
					 
					 DFS(grid,i,j);
				 }
				 
			}
			 
		}
		 	  
		 return island;
        
    }
    
    
    public static void DFS(int[][] grid, int i, int j) {
		
		if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==1) {
			return;
		}
		
		grid[i][j] = 1;
		DFS(grid, i,j+1);
		DFS(grid, i,j-1);
		DFS(grid, i-1,j);
		DFS(grid, i+1,j);	
		
	}

}
