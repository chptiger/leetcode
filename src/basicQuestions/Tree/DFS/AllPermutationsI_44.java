package basicQuestions.Tree.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Given a string with no duplicate characters, return a list with all
 * permutations of the characters. Examples Set = “abc”, all permutations are
 * [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”] Set = "", all permutations are
 * [""] Set = null, all permutations are []
 *
 */
public class AllPermutationsI_44 {

	@Test
	public void test_allPermutations() {
		Assert.assertEquals(new ArrayList<>(Arrays.asList("aba", "aab", "baa")), permutations("aba"));
		Assert.assertEquals(new ArrayList<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")),
				permutations("abc"));
	}

	private static ArrayList<String> permutations(String input) {
		ArrayList<String> result = new ArrayList<>();
		if (input == null || input.length() <= 1) {
			result.add(input);
			return result;
		}
		StringBuilder sb = new StringBuilder();
		permutationHelper(input.toCharArray(), new boolean[input.length()], 0, result, sb);
		return result;
	}

	private static void permutationHelper(char[] input, boolean[] used, int level, ArrayList<String> result,
			StringBuilder sb) {
		if (level == input.length) {
			result.add(new String(sb));
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (!used[i]) {
				used[i] = true;
				sb.append(input[i]);
				permutationHelper(input, used, level + 1, result, sb);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1); // get to the parent level for brother's nodes
			}
		}

	}
}
