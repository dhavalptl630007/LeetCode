package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InterSectionofArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums1 = {1,2,2,1};
		int []nums2 = {2,2};
		
		
		intersection(nums1,nums2);
		

	}
	
	 public static int[] intersection(int[] nums1, int[] nums2) {
	        
	        if (nums1.length == 0 || nums1 == null ||nums2.length == 0 || nums2 == null  ){
	            return new int[0];
	        }
	        
	        //int n = 0;
	        
	       // if (nums1.length>nums2.length){
	          //  n = nums1.length;
	            
	        //}
	        //else{
	            
	          //    n = nums2.length;
	        //}
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        //int[] res = new int[];
	         List<Integer> res = new ArrayList<>();
	        
	        for (int num : nums1)
	        {
	            map.put(num,map.getOrDefault(num,0)+1);
	        }
	        
	        //int i = 0;
	        for (int num : nums2){
	            
	            if (map.containsKey(num)){
	                
	                res.add(num);
	            
	                      map.remove(num);
	                  
	                
	    
	            
	            }
	            
	            //i++
	        }
	        
	        int i = 0;
	        int arr[] = new int[res.size()];
	        
	        for (int num : res){
	            arr[i++]= num;
	            
	        }
	        
	        return arr;
	    }

}
