package String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(groupAnagrams(strs));

	}

	
	 public static List<List<String>> groupAnagrams(String[] strs) {
         
	        if (strs.length == 0 || strs == null){
	            return new ArrayList<>();
	        }
	        
	        List<List<String>> res = new ArrayList<>();
	        HashMap<String,List<String>> map = new HashMap<>();
	        
	        int freq[] = new int[26];
	        
	        for (String str : strs){
	        
	             Arrays.fill(freq,0);
	             for (char ch : str.toCharArray()){
	                 
	                   freq[ch-'a']++;
	                                  
	             }
	            
	            StringBuilder sb = new StringBuilder();
	            
	             for(int num : freq){    
	                 //sb.append("#");
	                 sb.append(num);
	             }
	              
	             String sorted_str = sb.toString();
	             if (!map.containsKey(sorted_str)){
	                               
	            	  map.put(sorted_str, new ArrayList());
	                 
	             }
	          
	             
	             map.get(sorted_str).add(str); 
	            
	        }
	        
	       
	       
	        return new ArrayList(map.values());
	        
	    }
}
