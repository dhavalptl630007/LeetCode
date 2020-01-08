package Matrix;

//https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {

	public static void main(String[] args) {
	
		int grid[][] = {{0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		
		
		System.out.println(islandPerimeter(grid));

	}

	private static int islandPerimeter(int[][] grid) {
		
		int ans = 0;
		if(grid.length == 0 || grid == null) {
			return 0;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				
				if(grid[i][j]==1) {
					
					//top
					if( i-1 <0 || grid[i-1][j] == 0) {
						ans++;
					}
					//bottom
					if( i+1 >=grid.length || grid[i+1][j] == 0) {
						ans++;
					}
					
					//left
					if( j-1 <0 || grid[i][j-1] == 0) {
						ans++;
					}
					
					//right
					if( j+1 >=grid[i].length || grid[i][j+1] == 0) {
						ans++;
					}
					
				}
				
			}
		}
		
		
		return ans;
	}

}
