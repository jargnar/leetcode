/*https://leetcode.com/problems/add-two-numbers/*/
package org.suhas.leetcode;

import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class AddTwoNumbersSolution {
    public BigInteger getNumberFromListNode(ListNode l) {
        BigInteger num = BigInteger.valueOf(0);
        BigInteger multiplier = BigInteger.valueOf(1);
        ListNode ptr = l;
        while (ptr != null) {
            num = num.add(multiplier.multiply(BigInteger.valueOf(ptr.val)));
            multiplier = multiplier.multiply(BigInteger.valueOf(10));
            ptr = ptr.next;
        }
        return num;
    }

    public ListNode getListNodeFromNumber(BigInteger num) {
        ListNode l = new ListNode(num.mod(BigInteger.valueOf(10)).intValue());
        ListNode ptr = l;
        num = num.divide(BigInteger.valueOf(10));
        while (num.compareTo(BigInteger.valueOf(0)) == 1) {
            BigInteger val = num.mod(BigInteger.valueOf(10));
            ptr.next = new ListNode(val.intValue());
            ptr = ptr.next;
            num = num.divide(BigInteger.valueOf(10));
        }
        return l;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = getNumberFromListNode(l1);
        BigInteger num2 = getNumberFromListNode(l2);
        return getListNodeFromNumber(num1.add(num2));
    }

}

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();

        ListNode l1 = new ListNode(9);
        ListNode l2 = solution.getListNodeFromNumber(new BigInteger("9999999991"));


        solution.addTwoNumbers(l1, l2);
    }
}
