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

public class SocratesCowsProblem {

	static LinkedHashMap<String, ArrayList<String>> graph = new LinkedHashMap<String, ArrayList<String>>();
	static LinkedHashMap<String, Integer> distmap = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<String, Integer> sourceDist = new LinkedHashMap<String, Integer>();
	static HashSet<String> vertices = new HashSet<String>();
	static PriorityQueue<VertexNode> queue;
	static HashSet<String> visited = new HashSet<String>();

	public static void main(String[] args) {

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

	

		queue = new PriorityQueue<VertexNode>(vertices.size(), new VertexNode());
		intialize();
		putAllnodestoQueue();

		findshortestPath("z");
		System.out.println(sourceDist);

		int minDistance = Integer.MAX_VALUE;
		String minDistanceVertexNode = "";

		for (Entry entry : sourceDist.entrySet()) {

			String vertice = (String) entry.getKey();

			if (vertice.charAt(0) >= 'A' && vertice.charAt(0) <= 'Z') {
				if (minDistance > (Integer) entry.getValue()) {
					minDistance = (Integer) entry.getValue();
					minDistanceVertexNode = vertice;
				}
			}

		}

		System.out.println(minDistanceVertexNode + " " + minDistance);

	}

	private static void putAllnodestoQueue() {

		for (Entry entry : sourceDist.entrySet()) {

			queue.add(new VertexNode((String) entry.getKey(), (Integer) entry.getValue()));

		}

	}

	private static void findshortestPath(String string) {

		while (visited.size() != vertices.size()) {

			String parent = queue.remove().vertex;

			visited.add(parent);

			ArrayList<String> adjacentList = graph.get(parent);

			for (String adjacentVertexNode : adjacentList) {

				if (!visited.contains(adjacentVertexNode)) {

					int newDistance = distmap.get(parent + adjacentVertexNode) + sourceDist.get(parent);
					int oldDistance = sourceDist.get(adjacentVertexNode);
					if (newDistance < oldDistance) {
						// relax the vertice
						sourceDist.put(adjacentVertexNode, newDistance);
					}

					queue.add(new VertexNode(adjacentVertexNode, sourceDist.get(adjacentVertexNode)));
				}

			}

		}

	}

	private static void intialize() {

		for (Entry entry : graph.entrySet()) {

			sourceDist.put((String) entry.getKey(), Integer.MAX_VALUE);

		}

		sourceDist.put("z", 0);

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

		distmap.put(startVertex + endVertex, dist);
		distmap.put(endVertex + startVertex, dist);

	}
}
