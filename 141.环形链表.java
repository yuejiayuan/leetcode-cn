/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return false;
            } else {
                p2 = p2.next;
            }
            if (p1 == p2 && p1 != null) return true;
        }
        return false;
    }
}
// @lc code=end

