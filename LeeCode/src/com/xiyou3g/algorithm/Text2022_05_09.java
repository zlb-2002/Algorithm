package com.xiyou3g.algorithm;

import java.util.Arrays;

/* LeeCode 942
* */

/*  使用双指针，由于字符 'I'对应的是数组的递增序列，字符'D'对应的是数组的递减序列，
    就能够遍历一遍用数组的递增递减来控制最终的数组。
* */

public class Text2022_05_09 {

    public int[] diStringMatch(String s) {
        int x, y;
        x = 0;
        y = s.length();
        int[] arr = new int[y+1];
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == 'I') {
                arr[i] = x++;
            } else if (s.charAt(i) == 'D') {
                arr[i] = y--;
            }
        }

        if (s.charAt(s.length()-1) == 'I') {
            arr[s.length()] = x;
        } else {
            arr[s.length()] = y;
        }
        return arr;
    }

}
