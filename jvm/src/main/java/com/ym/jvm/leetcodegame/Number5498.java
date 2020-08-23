package com.ym.jvm.leetcodegame;

public class Number5498 {
    public static void main(String[] args) {
        int[] stoneValue = {6,2,3,4,5,5};
    }
    public static int stoneGameV(int[] stoneValue){
        int left = 0;
        int right = stoneValue.length-1;
        int mid = (left+right)/2;
        return 0;
    }

    /**
     * 获取分开后数组的值
     * @param val
     * @return
     */
    private static int getStoneValue(int[] val){
        int sum = 0;
        for (int i=0;i<val.length;i++){
            sum += val[i];
        }
        return sum;
    }
}
