package link_list;// 定义链表节点类






public class link_list3 {
    // 找到两个链表的相交节点
    public boolean isPalindrome(ListNode head) {
        // 处理边界情况：如果链表为空或者只有一个节点，那么它一定是回文链表
        if (head == null || head.next == null) {
            return true;
        }
        // 慢指针，每次移动一步，用于找到链表的中间节点
        ListNode slow = head;
        // 快指针，每次移动两步，用于辅助慢指针找到链表的中间节点
        ListNode fast = head;
        // 快慢指针同时移动，当快指针到达链表末尾时，慢指针正好指向链表的中间节点（奇数长度链表）
        // 或者前半部分的最后一个节点（偶数长度链表）
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表，并获取反转后的链表头节点
        ListNode secondHalf = reverseList(slow.next);
        // 前半部分链表的头节点
        ListNode firstHalf = head;
        // 比较前半部分链表和反转后的后半部分链表的节点值
        while (secondHalf != null) {
            // 如果对应位置的节点值不相等，说明链表不是回文链表
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            // 移动前半部分链表的指针到下一个节点
            firstHalf = firstHalf.next;
            // 移动反转后的后半部分链表的指针到下一个节点
            secondHalf = secondHalf.next;
        }
        // 如果遍历完反转后的后半部分链表都没有发现不相等的节点值，说明链表是回文链表
        return true;
    }

    private ListNode reverseList(ListNode head) {
        // 用于保存当前节点的前一个节点，初始化为 null
        ListNode pre = null;
        // 当前正在处理的节点，初始化为链表的头节点
        ListNode cur = head;
        // 用于临时保存当前节点的下一个节点
        ListNode temp = null;
        // 遍历链表，直到当前节点为空
        while (cur != null) {
            // 保存当前节点的下一个节点
            temp = cur.next;
            // 将当前节点的 next 指针指向前一个节点，实现反转
            cur.next = pre;
            // 更新前一个节点为当前节点
            pre = cur;
            // 更新当前节点为下一个节点
            cur = temp;
        }
        // 返回反转后链表的头节点
        return pre;
    }

    public static void main(String[] args) {
        // 创建一个回文链表 1 -> 2 -> 2 -> 1
        ListNode palindromeList = new ListNode(1);
        palindromeList.next = new ListNode(2);
        palindromeList.next.next = new ListNode(2);
        palindromeList.next.next.next = new ListNode(1);

        // 创建一个非回文链表 1 -> 2 -> 3
        ListNode nonPalindromeList = new ListNode(1);
        nonPalindromeList.next = new ListNode(2);
        nonPalindromeList.next.next = new ListNode(3);

        link_list3 solution = new link_list3();

        // 判断回文链表
        boolean isPalindrome1 = solution.isPalindrome(palindromeList);
        System.out.println("链表 1 -> 2 -> 2 -> 1 是否为回文链表: " + isPalindrome1);

        // 判断非回文链表
        boolean isPalindrome2 = solution.isPalindrome(nonPalindromeList);
        System.out.println("链表 1 -> 2 -> 3 是否为回文链表: " + isPalindrome2);
    }
}