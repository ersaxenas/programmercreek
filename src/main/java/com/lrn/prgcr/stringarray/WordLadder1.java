package com.lrn.prgcr.stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

	class Node {
		String word;
		int step;

		public Node(final String word, final int step) {
			this.word = word;
			this.step = step;
		}

		@Override
		public String toString() {
			return "Node [word=" + word + ", step=" + step + "]";
		}

	}

	public int findWordLadder(final String beginWord, final String endWord, final List<String> wordList) {

		if ((wordList == null) || wordList.isEmpty()) {
			return 0;
		}
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.add(endWord);
		/* create a queue for bfs */
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(beginWord, 1));
		wordSet.remove(beginWord);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			String word = node.word;

			if (word.equals(endWord)) {
				System.out.println("end reached:" + word);
				return node.step;
			}
			char[] letterArray = word.toCharArray();
			for (int charIndex = 0; charIndex < letterArray.length; charIndex++) {
				char letterToBeReplaced = letterArray[charIndex];
				for (int atoz = 'a'; atoz <= 'z'; atoz++) {
					if (atoz == letterToBeReplaced) {
						continue;
					}
					letterArray[charIndex] = (char) atoz;
					String wordToCheck = new String(letterArray);
					if (wordSet.contains(wordToCheck)) {
						System.out.println(wordToCheck);
						queue.add(new Node(wordToCheck, node.step + 1));
						wordSet.remove(wordToCheck);
					}
				}
				letterArray[charIndex] = letterToBeReplaced;
			}

		}

		return 0;
	}

	public static void main(final String args[]) {
		System.out.println(new WordLadder1().findWordLadder("a", "c", Arrays.asList("a", "b", "c")));
		System.out.println(new WordLadder1().findWordLadder("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}

}
