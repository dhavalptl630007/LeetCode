package AlgorithmProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BakeryPblm {

	//static LinkedHashMap<Integer, ArrayList<Integer>> queueMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> queueMap;
//	static ArrayList<Integer> patienceLevel = new ArrayList<Integer>();
	static int minPatienceLevel = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfQueues = Integer.parseInt(sc.nextLine());
		long startTime = System.currentTimeMillis();
		int numberofCustomers = 0;
		queueMap = new ArrayList<ArrayList<Integer>>(numberOfQueues);
		
		for (int i = 1; i <= numberOfQueues; i++) {

			String arr1[] = sc.nextLine().split("\\s+");

			ArrayList<Integer> list = new ArrayList<Integer>();
			numberofCustomers += Integer.parseInt(arr1[0]);
			for (int j = 1; j < arr1.length; j++) {
				list.add(Integer.parseInt(arr1[j]));
				// patienceLevel.add(Integer.parseInt(arr1[j]));
			}
			queueMap.add(list);
		}

		int maxCustomer = 0;
		while (numberofCustomers != maxCustomer) {
			// System.out.println(Collections.min(new
			// ArrayList<Integer>(queueMap.values())));
			int quequeId = findMinimum();

			if (maxCustomer == minPatienceLevel) {
				break;
			}

			ArrayList<Integer> list = queueMap.get(quequeId);
			list.remove(0);
			if (list.isEmpty()) {
				queueMap.remove(quequeId);
			} //else {
			//	queueMap.add(list);
			//}
			maxCustomer++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(maxCustomer);
		System.out.println(endTime - startTime);
		sc.close();
	}

	private static int findMinimum() {

		minPatienceLevel = Integer.MAX_VALUE;
		int quequeId = 0;
        
		for (ArrayList<Integer> list : queueMap) {

	        int minPatienceL=  Collections.min(list);

				if (minPatienceLevel > minPatienceL) {
					minPatienceLevel = minPatienceL;
					quequeId = queueMap.indexOf(list);

				}
			}

	
		return quequeId;

	}

}
