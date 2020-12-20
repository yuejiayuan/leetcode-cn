/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return head;

        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        ListNode p = head;
        int cnt = 0;
        while(p != null) {
            arr.add(p);
            ++cnt;
            p = p.next;
        }
        
        if (cnt == n) {
            return head.next;
        } else {
            ListNode delPreNode = arr.get(cnt - n - 1);
            delPreNode.next = delPreNode.next.next;
            return head;
        }
    }
}
// @lc code=end

