package Array;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
//one pass solution : first tried two pass then converted to one pass
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		
		int numbers[] = {2,7,11,15};
		int result[] = twoSum(numbers,9);
	
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	private static int[] twoSum(int[] numbers, int target) {
			
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		/*
		 * for (int i = 0; i < numbers.length; i++) { map.put(numbers[i],i+1); }
		 */
		
		for (int i = 0; i < numbers.length; i++) {
			
			if(map.containsKey(target-numbers[i])) {
				
				int result[] = {map.get(target-numbers[i])+1, i+1};
				
				return result;
			}
			map.put(numbers[i],i);
		
		}
		
		 /* Two Pointer Solutions
		  * here Array should be sorted
		   int low = 0;
	        int high = numbers.length - 1;
	        while (low < high) {
	            if (numbers[low] + numbers[high] == target) {
	                return new int[]{low + 1, high + 1};
	            } else if (numbers[low] + numbers[high] < target) {
	                low++;
	            } else {
	                high--;
	            }
	        }
		*/
		
		return null;
	}
}
