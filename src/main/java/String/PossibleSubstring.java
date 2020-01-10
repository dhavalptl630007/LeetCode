package String;
//https://leetcode.com/problems/longest-palindromic-substring/submissions/
//brute force approach
public class PossibleSubstring {

	public static void main(String[] args) {
		

		String str = new String("cbbd");
		int maxLen = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			
			for (int j = i; j < str.length(); j++) {
				
				System.out.println(str.substring(i,j+1));
				
				if(isPalimdrome(str.substring(i,j+1))) {
					if(str.substring(i,j+1).length()>maxLen)
					temp = str.substring(i,j+1);
					maxLen = Math.max(maxLen,temp.length() );
				}
			}
			
		}
		
		System.out.println(temp);
		
	}

	private static boolean isPalimdrome(String substring) {
		
		
		StringBuffer sf = new StringBuffer(substring);
		
		if(sf.reverse().toString().equals(substring)) {
			return true;
		}
				
		return false;
	}

}
