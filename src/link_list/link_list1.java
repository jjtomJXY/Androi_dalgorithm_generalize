package link_list;// 定义链表节点类


public class link_list1 {
    // 找到两个链表的相交节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 创建相交链表的辅助方法
    public static ListNode[] createIntersectingLists() {
        // 创建公共部分链表
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // 创建链表 A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // 创建链表 B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        return new ListNode[]{headA, headB};
    }

    public static void main(String[] args) {
        link_list1 solution = new link_list1();
        // 创建相交链表
        ListNode[] lists = createIntersectingLists();
        ListNode headA = lists[0];
        ListNode headB = lists[1];

        // 调用方法找到相交节点
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println("相交节点的值为: " + intersectionNode.val);
        } else {
            System.out.println("两个链表没有相交节点。");
        }
    }
}