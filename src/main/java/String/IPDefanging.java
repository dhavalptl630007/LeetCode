package String;
//https://leetcode.com/problems/defanging-an-ip-address/submissions/
//faster approach


public class IPDefanging {

	public static void main(String[] args) {
	
		String address = "10.10.10.10";
		
		 String res = "";
	        
	        for(int i = 0; i<address.length();i++) {
	            
	            if(address.charAt(i) == '.'){
	                res = res + '[' + '.'+']';
	            }
	            else
	            {
	            res = res+ address.charAt(i);
	            }
	        }
	        // return address.replaceAll("[.]","[.]");
	       System.out.println(res);
	    }

	}


