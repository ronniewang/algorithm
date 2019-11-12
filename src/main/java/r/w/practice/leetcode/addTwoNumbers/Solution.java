package r.w.practice.leetcode.addTwoNumbers;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int added = l1.val + l2.val;
        int carry = 0;
        if (added >= 10) {
            carry = 1;
            added -= 10;
        }
        ListNode head = new ListNode(added);
        ListNode result = head;
        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;
        while (l1Next != null) {
            if (l2Next != null) {
                int nextResult = l1Next.val + l2Next.val + carry;
                carry = updateResultAndGetCarry(result, nextResult);
                l2Next = l2Next.next;
            } else {
                int nextResult = l1Next.val + carry;
                carry = updateResultAndGetCarry(result, nextResult);
            }
            l1Next = l1Next.next;
            result = result.next;
        }
        while (l2Next != null) { // L2 比 L1 长
            int nextResult = l2Next.val + carry;
            carry = updateResultAndGetCarry(result, nextResult);
            l2Next = l2Next.next;
            result = result.next;
        }
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        return head;
    }

    private int updateResultAndGetCarry(ListNode result, int nextResult) {

        int carry;
        if (nextResult >= 10) {
            nextResult -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        result.next = new ListNode(nextResult);
        return carry;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {

        val = x;
    }
}