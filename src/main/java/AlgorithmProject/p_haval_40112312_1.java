package AlgorithmProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

class VertexNode implements Comparator<VertexNode> {

	public String vertex;
	public int cost;

	public VertexNode() {
	}

	public VertexNode(String vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	@Override
	public int compare(VertexNode o1, VertexNode o2) {
		// TODO Auto-generated method stub
		if (o1.cost < o2.cost)
			return -1;
		if (o1.cost > o2.cost)
			return 1;
		return 0;

	}
}

public class p_haval_40112312_1 {

	static LinkedHashMap<String, ArrayList<String>> graph;
	static LinkedHashMap<String, Integer> edgeWeight;
	static LinkedHashMap<String, Integer> DistanceFromSource;
	static HashSet<String> vertices;
	static PriorityQueue<VertexNode> priorityQueue;
	static HashSet<String> visited;

	public static void main(String[] args) {

		graph = new LinkedHashMap<String, ArrayList<String>>();
		edgeWeight = new LinkedHashMap<String, Integer>();
		DistanceFromSource = new LinkedHashMap<String, Integer>();
		vertices = new HashSet<String>();
		visited = new HashSet<String>();

		Scanner sc = new Scanner(System.in);
		int numberOfEdges = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numberOfEdges; i++) {

			String arr[] = sc.nextLine().split("\\s+");
			String startVertex = arr[0];
			String endVertex = arr[1];
			int dist = Integer.parseInt(arr[2]);
			vertices.add(startVertex);
			vertices.add(endVertex);
			creategraph(startVertex, endVertex, dist);
		}
		priorityQueue = new PriorityQueue<VertexNode>(vertices.size(), new VertexNode());
		intialize();
		putAllnodestoQueue();

		findshortestPath("z");

		// System.out.println(DistanceFromSource);

		int minDistance = Integer.MAX_VALUE;
		String minDistanceVertexNode = "";

		for (Entry entry : DistanceFromSource.entrySet()) {

			String vertice = (String) entry.getKey();

			if (vertice.charAt(0) >= 'A' && vertice.charAt(0) <= 'Z') {
				if (minDistance > (Integer) entry.getValue()) {
					minDistance = (Integer) entry.getValue();
					minDistanceVertexNode = vertice;
				}
			}

		}

		sc.close();
		System.out.println(minDistanceVertexNode + " " + minDistance);

	}

	private static void putAllnodestoQueue() {

		for (Entry entry : DistanceFromSource.entrySet()) {

			priorityQueue.add(new VertexNode((String) entry.getKey(), (Integer) entry.getValue()));

		}

	}

	private static void findshortestPath(String source) {

		while (visited.size() != vertices.size()) {

			String parent = priorityQueue.remove().vertex;

			visited.add(parent);

			ArrayList<String> adjacentList = graph.get(parent);

			if (adjacentList != null) {

				for (String adjacentVertexNode : adjacentList) {

					if (!visited.contains(adjacentVertexNode)) {

						int newDistance = edgeWeight.get(parent + adjacentVertexNode) + DistanceFromSource.get(parent);
						int oldDistance = DistanceFromSource.get(adjacentVertexNode);
						if (newDistance < oldDistance) {
							// relax the vertice
							DistanceFromSource.put(adjacentVertexNode, newDistance);
						}

						priorityQueue
								.add(new VertexNode(adjacentVertexNode, DistanceFromSource.get(adjacentVertexNode)));

					}

				}

			}

		}

	}

	private static void intialize() {

		for (Entry entry : graph.entrySet()) {

			DistanceFromSource.put((String) entry.getKey(), Integer.MAX_VALUE);

		}

		DistanceFromSource.put("z", 0);

	}

	private static void creategraph(String startVertex, String endVertex, int dist) {

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

		edgeWeight.put(startVertex + endVertex, dist);
		edgeWeight.put(endVertex + startVertex, dist);

	}
}
