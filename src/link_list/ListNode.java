package link_list;

public class ListNode {
    int val;
    ListNode next;

    // 无参构造函数，节点值初始化为 0，next 指针初始化为 null
    ListNode() {
        this.val = 0;
        this.next = null;
    }

    // 带一个参数的构造函数，用于指定节点的值，next 指针初始化为 null
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    // 带两个参数的构造函数，用于指定节点的值和 next 指针指向的节点
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

