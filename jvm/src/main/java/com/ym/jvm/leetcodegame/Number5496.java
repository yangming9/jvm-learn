package com.ym.jvm.leetcodegame;

import java.util.Arrays;

public class Number5496 {
    public static void main(String[] args) {
        int[] piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }
    public static int maxCoins(int[] piles){
        Arrays.sort(piles);
        int round = piles.length / 3;
        int res = 0;
        for (int i = round; i < piles.length; i += 2) {
            res += piles[i];
        }
        return res;
    }
}
