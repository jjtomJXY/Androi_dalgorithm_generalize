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

    // 创建相交链表的辅助方法


    public static void main(String[] args) {
        // 创建一个无环链表 1 -> 2 -> 3
        ListNode nonCyclicList = new ListNode(1);
        nonCyclicList.next = new ListNode(2);
        nonCyclicList.next.next = new ListNode(3);

        // 创建一个有环链表 1 -> 2 -> 3，其中 3 指向 2
        ListNode cyclicList = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        cyclicList.next = node2;
        node2.next = node3;
        node3.next = node2; // 形成环

        link_list4 solution = new link_list4();

        // 判断无环链表是否有环
        boolean hasCycle1 = solution.hasCycle(nonCyclicList);
        System.out.println("链表 1 -> 2 -> 3 是否有环: " + hasCycle1);

        // 判断有环链表是否有环
        boolean hasCycle2 = solution.hasCycle(cyclicList);
        System.out.println("链表 1 -> 2 -> 3（存在环）是否有环: " + hasCycle2);
    }
}