package nowcoder;

import java.util.Arrays;

public class ZZZSortMain {
    public static void main(String[] args) {
        int[] a = new int[]{5,1,9,3,7,4,8,6,2};

//        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(3);
//        ListNode listNode2 = new ListNode(2);
//        listNode.next = listNode1;
//        listNode1.next =listNode2;
//        listNode2.next = new ListNode(4);
////        int[] c = new int[]{144712,
//// 179444,185396,199706,224065,268779,359995};
//        System.out.println(new Palindrome().isPalindrome(listNode));
        System.out.println(Arrays.toString(new HeapSort().heapSort(a,a.length)));
    }
}
