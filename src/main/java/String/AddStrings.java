package String;

//https://leetcode.com/problems/add-strings/submissions/

public class AddStrings {

	public static void main(String[] args) {
		
		String num1 = "0";
		String num2 = "9";

		System.out.println(addStrings(num1,num2));
		
	}

	private static String addStrings(String num1, String num2) {
		
		StringBuilder res = new StringBuilder();
		int carry = 0;
        for (int i = num1.length()-1,j = num2.length()-1; i>=0 || j>=0 ; i--,j--) {
			
        	 int anum1 = i>=0 ? num1.charAt(i)-'0': 0;
        	 int bnum2 = j>=0 ? num2.charAt(j)-'0': 0;
        	 
        	 int sum = carry + anum1+ bnum2;
        	 carry = sum/10;
        	 res.append(sum%10);
		}		
        if(carry == 1) res.append(carry);
		return res.reverse().toString();
	}
}
