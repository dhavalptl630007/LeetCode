package String;

public class PalimDromeSubStrings {

	public static void main (String [] args) {
		
		String s = "aaa";
		
		System.out.print(countSubstrings(s));
		
		
	}

	private static int countSubstrings(String s) {
		
		int count = 0;
		
	    for(int i = 0 ; i <s.length();i++) 
	     count = count + countSubstrings(i,i,s) + countSubstrings(i,i+1,s);
		
	    return count;
	}

	private static int countSubstrings(int start, int end,String s) {
		int count = 0;
		
		while(start >= 0 &&  end < s.length() && s.charAt(start--) == s.charAt(end++))
			count++;
		
	return count;	
	}
	
}
