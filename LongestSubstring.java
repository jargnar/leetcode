/*https://leetcode.com/problems/longest-substring-without-repeating-characters/*/
package org.suhas.leetcode;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> cache = new HashSet<>();
        int biggestCount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = i; k < s.length(); k++) {
                if(cache.contains(s.charAt(k))) {
                    biggestCount = cache.size() > biggestCount ? cache.size() : biggestCount;
                    cache.clear();
                    break;
                }
                cache.add(Character.valueOf(s.charAt(k)));
            }
        }
        return cache.size() > biggestCount ? cache.size() : biggestCount;
    }
}

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstringSolution solution = new LongestSubstringSolution();
        int answer = solution.lengthOfLongestSubstring(" ");
        System.out.println(answer);
    }
}
