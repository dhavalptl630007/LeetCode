package String;
//https://leetcode.com/problems/split-a-string-in-balanced-strings/submissions/
public class BalancedString {

	public static void main(String[] args) {
		
		String s = "LRLR";
		
		System.out.println(balancedStringSplit(s));

	}

	private static int balancedStringSplit(String s) {
		
		 int count = 0;
	        int split = 0;
	        for(int i= 0; i < s.length(); i++){
	            if(s.charAt(i) == 'R'){
	                count += 1;
	                if (count == 0){
	                    split += 1;
	                }
	            }
	            else{
	                count -= 1;
	                if (count == 0){
	                    split += 1;
	                }
	                
	            }
	        }
	        return split;
		
	}

}
