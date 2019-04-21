package com.chester.leetcode_practice.problems;

import com.chester.leetcode_practice.leetcodeutils.LinkedList;
import com.chester.leetcode_practice.leetcodeutils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Chester
 * Date: 03/30/2019
 * TIME: 03:56
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class P0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode cur = resultHead;
        int sum;
        boolean carry = false;
        do {
            sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
            }
            if (l2 != null) {
                sum = sum + l2.val;
            }
            if (carry) {
                sum += 1;
            }
            if (sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        if (carry) {
            ListNode last = new ListNode(1);
            last.next = null;
            cur.next = last;
        }

        return resultHead.next;
    }

    void testTemplate(int[] a, int[] b, int[] sum) {
        ListNode l1 = LinkedList.create(a);
        ListNode l2 = LinkedList.create(b);
        ListNode expected = LinkedList.create(sum);
        ListNode actual = addTwoNumbers(l1, l2);
        assertTrue(LinkedList.equalList(expected, actual));
    }

    @Test
    void test1() {
        int[] data1 = {0};
        int[] data2 = {0};
        int[] dataResult = {0};
        testTemplate(data1, data2, dataResult);
    }

    @Test
    void test2() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] sum = {2 ,4 ,6};
        testTemplate(a, b, sum);
    }

    @Test
    void test3() {
        int[] a = {5, 2};
        int[] b = {4};
        int[] sum = {9 ,2};
        testTemplate(a, b, sum);
    }

    @Test
    void test4() {
        int[] a = {5, 2};
        int[] b = {8,};
        int[] sum = {3 ,3};
        testTemplate(a, b, sum);
    }

    @Test
    void test5() {
        int[] a = {1};
        int[] b = {9, 9, 9, 9};
        int[] sum = {0 ,0, 0, 0, 1};
        testTemplate(a, b, sum);
    }
}
