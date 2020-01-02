package Array;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		
		System.out.println(fib(4));

	}

	private static int fib(int N) {
		
		int first = 0;
		int second = 1;
		int third;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		map.put(0,0);
		map.put(1,1);
		for(int i = 2; i<=N;i++) {
			
			third = first + second;
			first = second;
			second = third;
			map.put(i, third);
		}
	  
		if(map.containsKey(N)) {
			return map.get(N);
		}
		
		return 0;
	}

}
