package String;
//https://leetcode.com/problems/most-common-word/submissions/
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BannedWord {

	public static void main(String[] args) {
		
		String paragraph ="Bob hit a ball, the hit BALL flew far after it was hit.";
		//String paragraph = "a, a, a, a, b,b,b,c, c";
		
		String banned[] = {"hit"};
		//String banned[] = {"a"};		
		System.out.println( mostCommonWord(paragraph, banned));
		
		
	}

	private static String mostCommonWord(String paragraph, String[] banned) {
		//carefully use the regex and replaceAll
	    String [] words =paragraph.replaceAll("[^a-zA-Z\\s+]", " ").toLowerCase().split("\\s+");
	    
	    Set<String> bannedSet = new HashSet<String>();
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    
	    for (String string : banned) {
	    	bannedSet.add(string);
	    }
	    
	    
	    for (String string : words) {
			
	    	if(!bannedSet.contains(string)) {
	    		map.put(string, map.getOrDefault(string, 0)+1);
	    	}
	    	 
		}
		 
	    List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});
	    
		//System.out.println(map);
		//System.out.println(list);
		
		 return (String) ((Map.Entry) list.get(0)).getKey();		
	}

}
