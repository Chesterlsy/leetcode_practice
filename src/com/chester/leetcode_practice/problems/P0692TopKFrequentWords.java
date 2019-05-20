package com.chester.leetcode_practice.problems;

import java.util.*;

/**
 * Author: Chester
 * Date: 05/20/2019
 * TIME: 02:51
 * Description:
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class P0692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            String k1 = o1.getKey();
            String k2 = o2.getKey();
            int v1 = o1.getValue();
            int v2 = o2.getValue();
            if (v1 == v2) {
                return k1.compareTo(k2); // a ahead of b
            } else {
                return v2 - v1; // 10 ahead of 5
            }
        });
        pq.addAll(map.entrySet());

        List<String> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
