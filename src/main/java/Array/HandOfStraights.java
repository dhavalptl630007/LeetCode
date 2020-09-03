package Array;

import java.util.TreeMap;

public class HandOfStraights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };

		System.out.println(isNStraightHand(hand, 3));
	}

	private static boolean isNStraightHand(int[] hand, int W) {
		// TODO Auto-generated method stub

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < hand.length; i++) {

			map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
		}

		// Arrays.sort(hand);
		while(!map.isEmpty()) {

			int num = map.firstKey();

			for (int j = num; j < num + W; j++) {

				if (map.containsKey(j)) {

					if (map.get(j) == 1) {
						map.remove(j);
					} else {
						map.put(j, map.get(j) - 1);
					}

				} else {
					return false;
				}

			}

		}

		return true;
	}

}
