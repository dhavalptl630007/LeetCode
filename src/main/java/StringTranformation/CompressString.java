package StringTranformation;

// https://leetcode.com/problems/string-compression/
public class CompressString {

	public static void main(String[] args) {
		char chars[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		System.out.println(compress(chars));
	}

	private static int compress(char[] chars) {

		if (chars == null || chars.length == 0) {
			return 0;
		}

		int insert = 0;

		for (int i = 0; i < chars.length; i++) {
			chars[insert++] = chars[i];
			int j = i + 1;
			while (j < chars.length && chars[i] == chars[j]) {
				j++;
			}

			if (j - i > 1) {
				for (char c : String.valueOf(j - i).toCharArray()) {
					chars[insert++] = c;
				}
			}
			i = j - 1;
		}
		return insert;
	}
}
