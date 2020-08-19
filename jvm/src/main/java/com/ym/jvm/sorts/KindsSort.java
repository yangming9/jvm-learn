package com.ym.jvm.sorts;

import java.util.Arrays;

/**
 * 各式各样的sort练习类
 */
public class KindsSort {
    public static void main(String[] args) {
        int arr[] = {5, 1, 12, 5, 1, 12, -5, 16, -5, 16};
//        bubble_sort(arr);//冒泡排序
//        select_sort(arr);//选择排序
//        insert_sort(arr);//插入排序
//        shell_sort(arr);//希尔排序
        quick_sort(arr, 0, arr.length - 1);//快速排序
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序：
     * 思路：
     * 1.将相邻的两个元素进行排序
     * 2.每次一个循环将最大的数放在数组的后面的位置
     * 3.直到全部都循环完毕----也是循环结束的标志
     * 因此冒泡排序的时间复杂度为：O(n^2)
     *
     * @param arr
     */
    private static void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序：
     * 思路：选择排序是在冒泡排序的基础之上减少了数据的交换，因为冒泡排序花费了大量的时间用在了数据的交换上
     * 1.先选择数组的第一个数值为最小值，并且记录下标
     * 2.进行遍历，如果发现比最小值小的数，那么将下标记录下来，等待一次循环结束，进行值的交换
     * 3.同2步骤，直到全部遍历完成
     * 时间复杂度为O(n^2)
     *
     * @param arr
     */
    private static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minVal = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    minIndex = j;
                    minVal = arr[minIndex];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }
        }
    }

    /**
     * 插入排序：
     * 思路：
     * 1.思想是先假设前面是一个有序序列
     * 2.不断的向后循环，将后面的值插入到前面有序序列的合适位置，直到循环完成
     * 3.不存在数据的交换 但是需要进行不断的对数据进行移动
     * 时间复杂度为O(n^2)
     *
     * @param arr
     */
    private static void insert_sort(int[] arr) {
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            insertIndex = i;//待插入的位置
            insertVal = arr[i + 1];//待插入的值
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }

    /**
     * 希尔排序
     * 思路：
     * 1.是简单插入排序的优化版本
     * 2.如果简单排序的最小数在最后面，那么数据移动的代价就会很大，排序的效率也就会下降很多
     * 3.利用增量的思想来减少这种操作
     */
    private static void shell_sort(int[] arr) {
        int temp = 0;
        int length = arr.length;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    } else {
                        break;
                    }
                }
            }
            gap /= 2;
        }
    }

    /**
     * 快速排序
     * 思路：
     * 1.快速排序采用了折半和递归的思想进行排序
     * 2.先取一个中间的值，然后将所有的数小的放在中间值的左边，大的放在右边
     * 3.以此递归下去  直到两个指针相遇便结束此次排序
     *
     * @param arr
     */
    private static void quick_sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midIndex = left + (right - left) / 2;
        int midVal = arr[midIndex];
        int temp = 0;
        while (l <= r) {
            while (arr[l] < midVal) {
                l++;
            }
            while (arr[r] > midVal) {
                r--;
            }
            if (l <= r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                //有可能l与r相遇了，需要将两个指针错开
                l++;
                r--;
            }
            if (l < right) {
                quick_sort(arr, l, right);
            }
            if (r > left) {
                quick_sort(arr, left, r);
            }
        }
    }
}
