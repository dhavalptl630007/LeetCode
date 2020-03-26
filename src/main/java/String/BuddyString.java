package String;

//https://leetcode.com/problems/buddy-strings/solution/

public class BuddyString {

	public static void main(String[] args) {
		
		String A = "aaaabc";
		String B = "aaaacb";
		System.out.println(buddyStrings(A,B));
		

	}
   
	 public static boolean buddyStrings(String A, String B) {
	        
	        if(A.length()!=B.length() || A.length() == 0 || B.length() == 0)
	            return false;
	        
	        int equalChar = 0;
	        
	        if(A.equals(B)){
	            
	            for(int i = 0 ; i<A.length();i++){
	                
	                if(A.charAt(0)==A.charAt(i))
	                    equalChar++;
	            }
	                
	                if(equalChar > 1){
	                    return true;
	                }
	                
	                return false;
	            }
	            
	            
	        
	        
	        
	        int diff=0;
	        
	        int unmatched = 0;
	        
	        for(int i = 0; i<A.length();i++){
	            
	            if(A.charAt(i)!=B.charAt(i)){
	                 unmatched++;
	                 diff=diff+(A.charAt(i)-B.charAt(i)); // for ensuring both character should be same
	            }
	                
	               
	        }
	        
	        
	        return unmatched == 2 && diff == 0;
	    }
}
