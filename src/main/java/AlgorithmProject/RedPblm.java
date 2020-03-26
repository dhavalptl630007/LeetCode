package AlgorithmProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RedPblm {

	static LinkedHashMap<String, ArrayList<String>> graph = new LinkedHashMap<String, ArrayList<String>>();
	static ArrayList<String> vertices = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfVertices = Integer.parseInt(sc.nextLine());

		String arr1[] = new String[numberOfVertices];
		char encode = 'A';
		for (int i = 0; i < numberOfVertices; i++) {
			String arr[] = sc.nextLine().split("\\s+");
			arr1[i] = encode + "-" + arr[0] + "-" + arr[1];
			encode++;
		}

		for (int i = 0; i < arr1.length; i++) {

			String interval[] = arr1[i].split("-");
			int starti = Integer.parseInt(interval[1]);
			int endi = Integer.parseInt(interval[2]);
			for (int j = i + 1; j < arr1.length; j++) {

				String intervalj[] = arr1[j].split("-");
				int startj = Integer.parseInt(intervalj[1]);
				int endj = Integer.parseInt(intervalj[2]);

				if (Math.max(starti, startj) <= Math.min(endi, endj)) {
					creategraph(arr1[i], arr1[j]);
					if (!vertices.contains(arr1[i])) {
						vertices.add(arr1[i]);
					}
					if (!vertices.contains(arr1[j])) {
						vertices.add(arr1[j]);
					}

				}

			}
		}

		System.out.println(graph);

		long q = 1000000007;
		long dominatingSets = (getSubsets(numberOfVertices)) % q;
		// long dominatingSets = 1000000009 % q ;
		System.out.println("number of dominating sets " + dominatingSets);
		sc.close();

	}

	private static long getSubsets(int numberOfVertices) {

		int dominatingSets = 0;
		HashSet<String> verticesSet = new HashSet<String>();

		for (int i = 0; i < (1 << numberOfVertices); i++) {

			for (int j = 0; j < numberOfVertices; j++) {

				if ((i & (1 << j)) > 0) {
					// System.out.print(vertices.get(j) + " ");
					String parent = vertices.get(j);
					if (graph.containsKey(parent)) {

						ArrayList<String> adjacentList = graph.get(parent);
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

		if (graph.containsKey(startVertex)) {
			graph.get(startVertex).add(endVertex);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(endVertex);
			graph.put(startVertex, list);
		}

		if (graph.containsKey(endVertex)) {
			graph.get(endVertex).add(startVertex);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(startVertex);
			graph.put(endVertex, list);
		}

	}

}
