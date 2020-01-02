package Matrix;

public class NumberOfClosedIslands {

	public static void main(String[] args) {
		
		//int grid[][] = {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		
		int grid[][] ={{0,0,1,1,0,1,0,0,1,0},
			{1,1,0,1,1,0,1,1,1,0},
			{1,0,1,1,1,0,0,1,1,0},
			{0,1,1,0,0,0,0,1,0,1},
			{0,0,0,0,0,0,1,1,1,0},
			{0,1,0,1,0,1,0,1,1,1},
			{1,0,1,0,1,1,0,0,0,1},
			{1,1,1,1,1,1,0,0,0,0},
			{1,1,1,0,0,1,0,1,0,1},
			{1,1,1,0,1,1,0,1,1,0}};
		System.out.println(numberOfClosedIslands(grid));
		
		

	}

	private static int numberOfClosedIslands(int[][] grid) {
		
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		
		for (int j = 0; j < n ; j++) {
			
			if(grid[0][j] == 0) {
				grid[0][j] = 1;
			}
			if(grid[m-1][j] == 0) {
				grid[m-1][j] = 1;
			}
			
		}
		
      for (int i = 0; i < m ; i++) {
			
			if(grid[i][0] == 0) {
				grid[i][0] = 1;
			}
			if(grid[i][n-1] == 0) {
				grid[i][n-1] = 1;
			}
			
		}
		
      int Islands = 0;
      
      for (int i = 0; i < m; i++) {
    	  
    	  for (int j = 0; j < n; j++) {
			
    		  if(grid[i][j] == 0) {
    			 
    			  dfs(grid,i,j);
    			  Islands++;
    		  }
		}
		
	}
		
		return Islands;
	}

	public static void dfs(int[][] grid, int i, int j) {
		
		
		if(j<0 || j> grid[0].length-1|| grid[i][j] == 1 || i<0 || i>grid.length-1 ) {
			return;
		}
		
		grid[i][j] = 1;
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);
	}

}
