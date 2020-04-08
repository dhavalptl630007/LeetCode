package AlgorithmProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p_haval_40112312_2 {

	static LinkedHashMap<String, ArrayList<String>> intervalGraph = new LinkedHashMap<String, ArrayList<String>>();
	static ArrayList<String> vertices = new ArrayList<String>();
	static String listofVertices[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfVertices = Integer.parseInt(sc.nextLine());

		listofVertices = new String[numberOfVertices];
		//char encode = 'A';
		for (int i = 0; i < numberOfVertices; i++) {
			//listofVertices[i] = sc.nextLine() + " " + encode++;
			listofVertices[i] = sc.nextLine();
		}

		for (int i = 0; i < listofVertices.length; i++) {

			
			initializeGraph(listofVertices[i]);
			
			String intervali[] = listofVertices[i].split("\\s+");
			int starti = Integer.parseInt(intervali[0]);
			int endi = Integer.parseInt(intervali[1]);
			for (int j = i + 1; j < listofVertices.length; j++) {

				String intervalj[] = listofVertices[j].split("\\s+");
				int startj = Integer.parseInt(intervalj[0]);
				int endj = Integer.parseInt(intervalj[1]);

				if (Math.max(starti, startj) <= Math.min(endi, endj)) {
					creategraph(listofVertices[i], listofVertices[j]);

				}

			}
		}

		//System.out.println(graph);

		long q = 1000000007;
		long dominatingSets = (getSubsets(numberOfVertices)) % q;
		// long dominatingSets = 1000000009 % q ;
		//System.out.println("number of dominating sets " + dominatingSets);
		System.out.println(dominatingSets);
		sc.close();

	}

	private static void initializeGraph(String interval) {
		// TODO Auto-generated method stub
		if (!intervalGraph.containsKey(interval)) {
			
            ArrayList<String> list = new ArrayList<String>();
            intervalGraph.put(interval, list);
		}
		
	}

	//https://www.geeksforgeeks.org/power-set/ - just generate power sets
	private static long getSubsets(int numberOfVertices) {

		long dominatingSets = 0;
		HashSet<String> verticesSet = new HashSet<String>();

		long totalSubsets = (long) Math.pow(2, numberOfVertices);
        //finding power set of vertices 
		for (long i = 0; i < totalSubsets; i++) {

			for (int j = 0; j < numberOfVertices; j++) {

				if ((i & (1 << j)) > 0) {
					//System.out.print(vertices.get(j) + " ");
					String parent = listofVertices[j];
					if (intervalGraph.containsKey(parent)) {

						ArrayList<String> adjacentList = intervalGraph.get(parent);
						verticesSet.add(parent);
						verticesSet.addAll(adjacentList);

					}
				}

			}
			if (numberOfVertices == verticesSet.size()) {
				dominatingSets++;
			}

			verticesSet.clear();
		}

		return dominatingSets;

	}

	private static void creategraph(String startVertex, String endVertex) {

		if (intervalGraph.containsKey(startVertex)) {
			intervalGraph.get(startVertex).add(endVertex);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(endVertex);
			intervalGraph.put(startVertex, list);
		}

		if (intervalGraph.containsKey(endVertex)) {
			intervalGraph.get(endVertex).add(startVertex);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(startVertex);
			intervalGraph.put(endVertex, list);
		}

	}

}
