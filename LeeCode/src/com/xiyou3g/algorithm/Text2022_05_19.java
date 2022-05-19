package com.xiyou3g.algorithm;

import java.util.Arrays;


/* 最少移动次数使数组元素相等 II
    LeeCode 462

    需要找到中位数根据中位数来判断需要移动的步数。

    为什么是中位数：
        首先假设存在2n+1个数，然后将他们进行排序 就会得到 [...a,m,b...]
        再假设将m左边的数全部变成m需要x,将m右边的数全部变为m需要y，所以一共需要的步数就是x+y。
        如果将其变为a,那么a右边的步数就需要 (m-a)*(n+1)+y,a左边的步数就需要  x-(m-a)*n,
        所以一共就需要(m-a)*(n+1)+y+x-(m-a)*n,化简得到 ： x+y+(m-a)。
        如果要将其变成b,那么以此类推就能够得到一定是比变成中位数所需要的步数多的。

        再假设存在2n个数，将他们进行排序，就能够得到 [...a,b...]
        如果将a左边的变为a需要x,将a右边的变为a需要y，所以就需要x+y。
        如果将其全部变为b，b左边就需要 x+(b-a)*n，b左边的就需要y-(b-a)*n
        所以一共就需要 x+(b-a)*n+y-(b-a)*n ,所以需要的步数为x+y。所以不管是取a还是取b，结果都是需要x+y。
        如果要取其它数，证明过程如上。
* */
public class Text2022_05_19 {

    public int minMoves2(int[] nums) {
        int length = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += Math.abs(num - nums[length/2]);
        }
        return sum;
    }

}
