/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        int cnt = 1;
        ListNode p = head;

        while (p.next != null) {
            ++cnt;
            p = p.next;
        }
        p.next = head;

        p = head;
        for (int i = 0; i < cnt - k % cnt - 1; ++i) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        return newHead;
    }
}
// @lc code=end

