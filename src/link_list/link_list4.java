package link_list;




public class link_list4 {
    // 找到两个链表的相交节点
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head; // 乌龟和兔子同时从起点出发
        while (fast != null && fast.next != null) {
            slow = slow.next; // 乌龟走一步
            fast = fast.next.next; // 兔子走两步
            if (fast == slow) { // 兔子追上乌龟（套圈），说明有环
                return true;
            }
        }
        return false; // 访问到了链表末尾，无环
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { // 相遇
                while (slow != head) { // 再走 a 步
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建一个有环的链表
        // 构建链表 1 -> 2 -> 3 -> 4 -> 2（形成环）
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 形成环

        // 创建一个无环的链表
        // 构建链表 5 -> 6 -> 7
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node5.next = node6;
        node6.next = node7;

        link_list4 solution = new link_list4();

        // 检测有环链表的环起始节点
        ListNode cycleStartNode = solution.detectCycle(node1);
        if (cycleStartNode != null) {
            System.out.println("有环链表的环起始节点的值为: " + cycleStartNode.val);
        } else {
            System.out.println("有环链表检测出错，未找到环起始节点。");
        }

        // 检测无环链表的环起始节点
        ListNode noCycleStartNode = solution.detectCycle(node5);
        if (noCycleStartNode == null) {
            System.out.println("无环链表不存在环。");
        } else {
            System.out.println("无环链表检测出错，不应找到环起始节点。");
        }
    }
}