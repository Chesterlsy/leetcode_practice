package com.chester.leetcode_practice.leetcodeutils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Chester
 * Date: 04/07/2019
 * TIME: 04:52
 * Description:
 */
public class LinkedListUtil {

    /**
     * Create a linked list from an array
     * @param data not null
     * @return the root node of the new list
     */
    public static ListNode create(int[] data) {
        ListNode root = new ListNode(data[0]);
        root.next = null;
        ListNode cur = root;
        for (int i = 1; i < data.length; i++) {
            ListNode newNode = new ListNode(data[i]);
            newNode.next = null;
            cur.next = newNode;
            cur = newNode;
        }
        return root;
    }

    public static int[] extract(ListNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode cur = root;
        while(cur.next != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        int size = arrayList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    public static boolean equalList(ListNode root1, ListNode root2) {
        ListNode tra1 = root1;
        ListNode tra2 = root2;
        while (tra1 != null && tra2 != null) {
            if (tra1.val != tra2.val) {
                return false;
            }
            tra1 = tra1.next;
            tra2 = tra2.next;
        }
        if (tra1 != null || tra2 != null) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    void equalTest() {
        int[] data = {1, 2, 3};
        ListNode root1 = create(data);
        ListNode root2 = create(data);
        assertTrue(equalList(root1, root2));
    }
}
