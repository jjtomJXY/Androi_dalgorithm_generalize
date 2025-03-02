package link_list;// 定义链表节点类

public class link_list2 {
    public ListNode reverseList(ListNode head) {
        // 重新创建一个链表，将之前的链表进行头插即可
        ListNode rphead = null;
        // 进行指针变换
        ListNode cur = head;
        while (cur != null) {
            // 用于保存下一个节点地址
            ListNode newnode = cur.next;
            // 头插
            cur.next = rphead;
            rphead = cur;
            cur = newnode;
        }
        return rphead;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建一个虚拟头节点，其 next 指针指向原链表的头节点
        ListNode dummy = new ListNode(0, head);
        // p0 指针用于定位反转区间的前一个节点
        ListNode p0 = dummy;

        // 遍历链表，找到反转区间的前一个节点
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }

        // pre 指针初始化为 null，用于反转链表时记录前一个节点
        ListNode pre = null;
        // cur 指针指向反转区间的第一个节点
        ListNode cur = p0.next;

        // 对反转区间内的节点进行反转操作
        for (int i = 0; i < right - left + 1; i++) {
            // 保存当前节点的下一个节点，防止链表断裂
            ListNode nxt = cur.next;
            // 当前节点的 next 指针指向前一个节点，实现反转
            cur.next = pre;
            // 更新前一个节点为当前节点
            pre = cur;
            // 当前节点移动到下一个节点
            cur = nxt;
        }

        // 反转区间的第一个节点（现在反转后变为该区间的最后一个节点）的 next 指针指向 cur
        p0.next.next = cur;
        // p0 的 next 指针指向反转后的区间的头节点
        p0.next = pre;

        // 返回反转后的链表的头节点
        return dummy.next;
    }
    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        link_list2 solution = new link_list2();
        ListNode reversedHead = solution.reverseList(head);

        // 打印反转后的链表
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


