package com.xiyou3g.algorithm;

import java.util.HashSet;
import java.util.Set;

/*   无重复字符的最长子串
    LeeCode 3
    使用双指针，将左指针能够达到的最长无重复字符的字符串统计出来，选取最长的结果即为所求结果。
* */

public class Text2022_05_22 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int left, right, result;
        right = 0;
        result = 1;
        for (left = 0; left < length;left++ ) {
            if (left != 0) {
                set.remove(s.charAt(left-1));
            }
            while (right < length && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }

            result = Math.max(result, right-left);
        }
        return result;
    }

}
