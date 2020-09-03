package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class PalimDromePartition {

	public static void main(String[] args) {
		
      System.out.print(partition("aaa"));
	}

	
	  public static List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<>();
	        backtrack(res,new ArrayList<>(),s,0);
	        return res;
	    }
	    private static void backtrack(List<List<String>> res,List<String> tempList,String s,int start){
	        if(start==s.length()){
	            res.add(new ArrayList<>(tempList));
	            return;
	        }
	        for(int i=start;i<s.length();i++){
	            if(isPalindrome(s,start,i)){
	                tempList.add(s.substring(start, i + 1));
	                backtrack(res, tempList, s, i + 1);
	                tempList.remove(tempList.size() - 1);
	            }
	        }
	        
	    }
	    public static boolean isPalindrome(String s, int low, int high){
	       while(low < high)
	          if(s.charAt(low++) != s.charAt(high--)) return false;
	       return true;
	    } 
}
