package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//https://www.geeksforgeeks.org/arraylist-array-conversion-java-toarray-methods/
public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = {1,2,3,4,5,6};
		
		//Arrays.sort(arr,Collections.reverseOrder());
		Arrays.sort(arr,(num1,num2)-> Integer.compare(num2,num1));
		System.out.println(Arrays.toString(arr));
		
		
        List<Integer> list = new ArrayList();
        // Arrays.asList
        System.out.println(list.toArray(arr));
	}

}
