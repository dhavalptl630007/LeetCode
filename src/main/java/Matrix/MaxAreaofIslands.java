package Matrix;

//https://leetcode.com/problems/max-area-of-island/

public class MaxAreaofIslands {

	public static void main(String[] args) {
		
		int grid[][] =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(maxAreaOfIsland(grid));
		
		
	}

	private static int maxAreaOfIsland(int[][] grid) {
			
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		int MaxArea = 0;
		for(int i = 0; i<m ; i++) {
			
			for(int j = 0; j<n ; j++) {
				
				if(grid[i][j] == 1) {
					
				 MaxArea = Math.max(MaxArea, DFS(grid,i,j));	
				}
				
			}
			
		}
			
		return MaxArea;
	}

	private static int DFS(int[][] grid, int i, int j) {
		
		if(i<0|| i>grid.length-1||j<0 ||j>grid[0].length-1|| grid[i][j] == 0 ) {
			return 0;
		}
		
		grid[i][j] = 0;
		
		return 1 + DFS(grid,i,j-1)+DFS(grid,i,j+1)+DFS(grid,i-1,j) +DFS(grid,i+1,j);
		
		
	}

}
