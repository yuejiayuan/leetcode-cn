/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 解法1：迭代
        return reverseListIteration(head);
        // 解法2：递归
        // return reverseListRecursive(head);
    }

    /* 解法1：迭代 */
    public ListNode reverseListIteration(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;    
        }
        cur.next = pre;
        head.next = null;
        return cur;
    }

    /* 解法2：递归 */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseListRecursiveImpl(head);
    }
    private ListNode reverseListRecursiveImpl(ListNode head) {
        if (head.next == null) return head;

        ListNode prevTail = head; 
        while(prevTail.next.next != null) {
            prevTail = prevTail.next;
        }
        ListNode tail = prevTail.next;
        prevTail.next = null;
        tail.next = reverseListRecursiveImpl(head);

        return tail;
    }
}
// @lc code=end

