package StringTranformation;
//https://leetcode.com/problems/goat-latin/submissions/ : similar pblm
import java.util.HashSet;
import java.util.Set;

public class MorseCode {

	public static void main(String[] args) {

		String[] words = { "gin", "zen", "gig", "msg" };
		System.out.println(uniqueMorseRepresentations(words));
	}

	private static int uniqueMorseRepresentations(String[] words) {

		if (words == null || words.length == 0) {
			return 0;
		}

		String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> seen = new HashSet<String>();
		for (String string : words) {
			StringBuilder sb = new StringBuilder();
			for (char c : string.toCharArray())
				sb.append(morse[c - 'a']);
			seen.add(sb.toString());
		}

		return seen.size();
	}

}
