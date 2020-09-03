package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		System.out.println(canFinish(2, prerequisites));
     
	}
	
	
	
	public static  boolean canFinish(int numCourses, int[][] prerequisites) {
	    if (numCourses == 0 || prerequisites.length == 0) {
	        return true;
	    }
	   // int preCount[] = new int[numCourses];
	    HashMap<Integer, List<Integer>> dependentMap = new HashMap<Integer, List<Integer>>();
	    for (int[] item : prerequisites) {
	       // preCount[item[0]]++;
	        if (dependentMap.containsKey(item[0])) {
	            dependentMap.get(item[0]).add(item[1]);
	        } else {
	            List<Integer> list = new ArrayList<Integer>();
	           list.add(item[1]);
	            dependentMap.put(item[0], list);
	        }
	        
//	        if (dependentMap.containsKey(item[1])) {
//	            dependentMap.get(item[1]).add(item[0]);
//	        } else {
//	            List<Integer> list = new ArrayList<Integer>();
//	           // list.add(item[0]);
//	            dependentMap.put(item[1], list);
//	        }
	    }
	    //int freeCount = 0;
	    Queue<Integer> open_queue = new LinkedList<Integer>();
	    Queue<Integer>  visited = new LinkedList<Integer>();
	    
	    open_queue.add(prerequisites[prerequisites.length-1][0]);
	    System.out.println(open_queue);
	    while (!open_queue.isEmpty()) {
	        
	        int current = open_queue.poll();
	        
	        if(!visited.contains(current))
	           visited.add(current);
	        
	        if (dependentMap.get(current) != null) {
	            for (int dependent : dependentMap.get(current)) {
	                
	                  if(open_queue.contains(dependent)|| visited.contains(dependent) ){
	                      return false;
	                  }
	                 else{
	                     open_queue.offer(dependent);
	                   }
	        
	               }
	        }
	    }  
	    
	    return true;
	   
	  }

}
