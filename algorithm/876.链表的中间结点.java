/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head, p2 = head;
        while (p2 != null) {
            p2 = p2.next;
            if (p2 == null) return p1;
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
// @lc code=end

