package com.chester.leetcode_practice.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Chester
 * Date: 07/15/2019
 * TIME: 02:02
 * Description:
 */
public class CarRefuel {
    public int solution(int[] A, int X, int Y, int Z) {
        int n = A.length;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < n; i++) { // choose from the available dispensers of which the accumulate time is minimum
            int xx = Integer.MAX_VALUE;
            int yy = Integer.MAX_VALUE;
            int zz = Integer.MAX_VALUE;
            if (A[i] <= X - x) { // X enough
                xx = x;
            }
            if (A[i] <= Y - y) { // Y enough
                yy = y;
            }
            if (A[i] <= Z - z) { // Z enough
                zz = z;
            }
            System.out.println("car" + i + ": xx=" + xx + " yy=" + yy +" zz=" + zz);
            Dispenser d = choose(xx, yy, zz);
            System.out.println("choose = " + d);
            switch (d) {
                case X:
                    if (i < n - 1) { // last car should not add
                        x += A[i];
                    }
                    break;
                case Y:
                    if (i < n - 1) {
                        y += A[i];
                    }
                    break;
                case Z:
                    if (i < n - 1) {
                        z += A[i];
                    }
                    break;
                case NONE:
                    return -1;
            }
        }
        return max(x, y, z);
    }

    enum Dispenser {
        X, Y, Z, NONE
    }

    private Dispenser choose(int x, int y, int z) {
        Dispenser d = Dispenser.NONE;
        if (x < Integer.MAX_VALUE) {
            d = Dispenser.X;
        }
        if (y < x) {
            d = Dispenser.Y;
        }
        if (z < x && z < y) {
            d = Dispenser.Z;
        }
        return d;
    }

    private int max(int x, int y, int z) {
        int max = x;
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    @Test
    void test1() {
        int[] arr = {2, 8, 4, 3, 2};
        assertEquals(8, solution(arr, 7, 11,3));
    }
}


