package com.lrn.prgcr.stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

	public int findWordLadder(final String beginWord, final String endWord, final List<String> wordList) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));
		Set<String> wordDict = new HashSet<>(wordList);
		wordDict.add(endWord);

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;

			if (word.equals(endWord)) {
				return top.numSteps;
			}

			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newWord = new String(arr);
					if (wordDict.contains(newWord)) {
						System.out.println(newWord);
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordDict.remove(newWord);
					}

					arr[i] = temp;
				}
			}
		}

		return 0;
	}

	public static void main(final String args[]) {
		// System.out.println(new WordLadder2().findWordLadder("a", "c", Arrays.asList("a", "b", "c")));
		System.out.println(new WordLadder2().findWordLadder("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}

}

class WordNode {
	String word;
	int numSteps;

	public WordNode(final String word, final int numSteps) {
		this.word = word;
		this.numSteps = numSteps;
	}
}
