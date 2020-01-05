package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/solution/
//https://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
public class TopKFrequentElement {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3 };
		System.out.println(topKFrequent(nums, 2));

	}

	private static List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0 || nums == null) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		for (int i = 0; i < k; i++) {
			res.add((Integer) ((Map.Entry) list.get(i)).getKey());
		}

		Collections.sort(res);
		return res;

	}

}