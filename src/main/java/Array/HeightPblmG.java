package Array;

public class HeightPblmG {

	public static void main(String[] args) {
		
		int nums [] = {10,11,9,12,12,2,2};
		
		int row = 1;
		for (int i = 1; i < nums.length; i++) {
			
			if(nums[i]>nums[i-1]) {
				row++;
			}	
		}
		
		System.out.println(row);

	}

}
