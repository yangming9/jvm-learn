package com.ym.jvm.leetcode;

import java.util.Arrays;

/**
 * 分发糖果
 */
public class Number135 {
    public static void main(String[] args) {
        int[] ratings = {5,7,8,3,4,2,1};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings){
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
