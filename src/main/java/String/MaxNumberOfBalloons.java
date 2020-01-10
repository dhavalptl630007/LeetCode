package String;

//https://leetcode.com/problems/maximum-number-of-balloons/submissions/
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxNumberOfBalloons {

	public static void main(String[] args) {

		String text = "nlaebolko";

		System.out.println(maxNumberOfBalloons(text));

	}

	public static int maxNumberOfBalloons(String text) {
		if (text == null || text.length() < 7)
			return 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : text.toCharArray()) {

			if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
		}

		int res = Integer.MAX_VALUE;

		for (Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getKey() == 'l' || entry.getKey() == 'o') {

				res = Math.min(res, entry.getValue() / 2);
			} else {
				res = Math.min(res, entry.getValue());
			}

		}

		/*
		 * int[] c = new int[26]; for (char ch : text.toCharArray()) c[ch - 'a']++; int
		 * res = Integer.MAX_VALUE; res = Math.min(res, c['b' - 'a']); res =
		 * Math.min(res, c['a' - 'a']); res = Math.min(res, c['l' - 'a'] / 2); res =
		 * Math.min(res, c['o' - 'a'] / 2); res = Math.min(res, c['n' - 'a']);
		 */
		return res;
	}
}
