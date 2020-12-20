/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode curNode = fakeHead;
        int addOne = 0;

        while(l1 != null || l2 != null) {
            int l1Val = (l1 != null ? l1.val : 0);
            int l2Val = (l2 != null ? l2.val : 0);

            curNode.next = new ListNode((l1Val + l2Val + addOne) % 10);
            curNode = curNode.next;

            addOne = (l1Val + l2Val + addOne) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (addOne > 0) {
            curNode.next = new ListNode(addOne);
        }

        return fakeHead.next;
    }
}
// @lc code=end

