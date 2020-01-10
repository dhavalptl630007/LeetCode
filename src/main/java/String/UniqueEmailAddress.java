package String;

import java.util.LinkedHashSet;

//https://leetcode.com/problems/unique-email-addresses/
//look for better solution
public class UniqueEmailAddress {

	public static void main(String[] args) {
		
	//	String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
		
		System.out.println(numUniqueEmails(emails));	
	}

	private static int numUniqueEmails(String[] emails) {
		
		if(emails == null || emails.length == 0) {
			return 0;
		}
		
		LinkedHashSet<String> list = new LinkedHashSet<String>();
		
		for (int i = 0; i < emails.length; i++) {
			
			String parts[] = emails[i].split("@");
			
			String part[] = parts[0].split("[.]");
			
			String temp = "";
			for (int j = 0; j < part.length; j++) {
				
			  temp = temp+part[j];
			}
			String res = "";
			
			if(temp.contains("+")) {
				
				int index = temp.indexOf("+");
				res = res+temp.substring(0,index);		
			}
			else
			{
				res = temp;
			}
			System.out.println(res +"@"+ parts[1]);
			
			list.add(res +"@"+ parts[1]);
			
		}
	
		return list.size();
	}

	//better code
	
	  /*public int numUniqueEmails(String[] emails) {
	        
	       if(emails == null || emails.length == 0) {
				return 0;
			}
			
			Set<String> seen = new HashSet<String>();
	        for (String email: emails) {
	            int i = email.indexOf('@');
	            String local = email.substring(0, i);
	            String rest = email.substring(i);
	            if (local.contains("+")) {
	                local = local.substring(0, local.indexOf('+'));
	            }
	            local = local.replaceAll("\\.", "");
	            seen.add(local + rest);
	        }

	        return seen.size();
	    } */
	
}
