package Array;

public class RangeBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int nums [] = {5,7,7,8,8,10};
      System.out.println(searchRange(nums, 8));
		
	}

public static int[] searchRange(int[] nums, int target) {
        
        int result[] = new int[2];
        
        result[0] = search(nums,0,nums.length-1,target);
        if (result[0]== -1) {
        	result[1] = -1;
        }
        else if (result[0] == nums.length-1) {
        	result[1] = result[0];
        }
        else {
        result[1] = search(nums,result[0]+1,nums.length-1,target);
        }
        
      return result;   
        
    }
    
    
    public static int search(int[] nums, int start, int end,int target){
        int midpoint = 0;
        while(start<=end){
        	
//           if((end-start)%2 !=0  ) {	
//           midpoint = (start+end+1)/2;
//           }
//           else {
        	   midpoint = (start+end)/2;
        //   }
           
            if (nums[midpoint]== target){
                
                return midpoint;
                
            }
            else if (nums[midpoint]<target)
            {
            	start = midpoint+1;
            	if(start<=end) {
            	if(nums[start] == target) {
            		return start;
            	}
            }
                
            }
            else{
                
            	end = midpoint-1;
            	if(start<=end) {
            	if(nums[end] == target) {
            		return end;
            	}
            	}
            }
            
        }
        
        return -1;
    }
}
