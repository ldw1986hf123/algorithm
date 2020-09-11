package com.ldw.algorithm;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class SimpleTopK {

    public static void topKFrequent(String[] words) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int count = map.get(words[i]);
                count++;
                map.put(words[i], count);
            }
        }

        map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

    }


    /**
     * 方法一：排序
     * 算法：
     * 计算每个单词的频率，并使用使用这些频率的自定义排序关系对单词进行排序。然后取前 k。
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }


    /**
     * 方法二：堆
     * 算法：
     * 计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。它将频率最小的候选项放在堆的顶部。最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。
     * 在 Python 中，我们使用 heapq\heapify，它可以在线性时间内将列表转换为堆，从而简化了我们的工作。
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentHeap(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }


    public static void main(String[] args) {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        SimpleTopK.topKFrequent(arr,2);


    }


}
