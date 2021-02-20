/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        ArrayList<Node> origArr = new ArrayList();
        ArrayList<Node> newArr = new ArrayList();
        Map<Node, Integer> map = new HashMap();

        // 创建基础的新链表（未处理random字段）
        Node newFakeHead = new Node(0);
        Node curOrig = head;
        Node curNew = newFakeHead;
        int idx = 0;
        while (curOrig != null) {
            curNew.next = new Node(curOrig.val);
            curNew.random = null;

            origArr.add(curOrig);
            newArr.add(curNew.next);
            map.put(curOrig, idx);

            ++idx;
            curOrig = curOrig.next;
            curNew = curNew.next;
        }
        curNew.next = null;

        // 处理新链表的random字段
        for (int i = 0; i < origArr.size(); ++i) {
            Node origArrNode = origArr.get(i);
            Node newArrNode = newArr.get(i);
            if (map.get(origArrNode.random) != null) {
                newArrNode.random = newArr.get(map.get(origArrNode.random));
            }
        }
        return newFakeHead.next;
    }
}
// @lc code=end

