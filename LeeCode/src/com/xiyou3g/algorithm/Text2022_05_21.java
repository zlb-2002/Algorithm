package com.xiyou3g.algorithm;

import java.util.*;

/* 在长度 2N 的数组中找出重复 N 次的元素
*   LeeCode 961
* */
public class Text2022_05_21 {

    //统计个数
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length/2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);    
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == n) {
                a = key;
                break;
            }
        }
        return a;
    }


    //排序，因为有2N个元素，N个相等，所以只有相等元素为所求结果
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == nums[i+1])
                return nums[i];
        return -1;
    }

    //哈希set，和之前的方法是一样的，不需要排序就能够找出其答案
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

}
