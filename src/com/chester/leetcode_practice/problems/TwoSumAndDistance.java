package com.chester.leetcode_practice.problems;

/**
 * Author: Chester
 * Date: 07/15/2019
 * TIME: 01:51
 * Description:
 */
public class TwoSumAndDistance {

    public int solution(int[] A) {
        int n = A.length;
        int maxAppeal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int appeal = A[i] + A[j] + (j - i);
                if (appeal > maxAppeal) {
                    maxAppeal = appeal;
                }
            }
        }
        return maxAppeal;
    }
}
