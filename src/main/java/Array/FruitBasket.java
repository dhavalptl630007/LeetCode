package Array;

import java.util.HashSet;

public class FruitBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tree[] = {3,3,3,1,2,1,1,2,3,3,4};
		
		System.out.println(totalFruit(tree));

	}

	   public static  int totalFruit(int[] tree) {
	        
	        
	          if(tree == null || tree.length == 0)
	            return 0;
	        
	        int left = 0, right = 0;
	        
	        HashSet<Integer> set = new HashSet<Integer>();
	        
	        int max = 0;
	        while(right<tree.length){
	            
	            if(set.size()<=2){
	                
	                
	                max = Math.max(max,right-left+1);
	                set.add(tree[right]);
	                
	                right++;
	            }
	            else{
	                     
	                set.remove(tree[left]);
	                while(tree[left]==tree[left+1]) {
	                left++;
	                }
	            }
	            
	        }
	        
	       return max; 
	    }


}
