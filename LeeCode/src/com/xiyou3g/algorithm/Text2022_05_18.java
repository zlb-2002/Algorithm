package com.xiyou3g.algorithm;

/*
最长回文子串 （动态规划）
LeeCode 5
* */

public class Text2022_05_18 {

    public String longestPalindrome(String s) {
        int length = s.length();
        int max = 1;
        int start = 0;
        //长度小于2直接跳出
        if (length < 2) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];
        //dp[i][i]为true
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                //当s.charAt(i)，s.charAt(j)不相同时，就能够判断s[j...i]不为回文串
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else {
                    //当s.charAt(i)，s.charAt(j)相同时,判断除j，i之外长度是否大于1，不大于1就直接为true
                    if ((i-1)-(j+1) < 1) {
                        dp[j][i] = true;
                    } else {
                        //当大于1时，dp[j][i] = dp[j+1][i-1]
                        dp[j][i] = dp[j+1][i-1];
                    }
                }

                //更新开始值和长度
                if (dp[j][i] && (i-j+1) > max) {
                    start = j;
                    max = i-j+1;
                }
            }
        }
        //截取字符串
        return s.substring(start, start+max);
    }
}
