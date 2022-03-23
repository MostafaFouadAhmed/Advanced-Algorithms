package challenges;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {

            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }

    }

    public static void main(String[] args) {

        // System.out.println(addTwoNumbers(creatListNode(new int []{2,4,3}), creatListNode(new int []{5,6,4})));
        System.out.println(addTwoNumbers(creatListNode(new int []{9,9,9,9,9,9,9}), creatListNode(new int []{9,9,9,9})));
        // System.out.println(addTwoNumbers(creatListNode(new int []{0}), creatListNode(new int []{0})));
        // System.out.println(addTwoNumbers(creatListNode(new int []{9}), creatListNode(new int []{9,9,9,9,9,9,9,9,9})));

    }

    public static ListNode addTwoNumbers(ListNode l1,  ListNode l2) {

        int summation;
        int reminder = 0;
        ArrayList<ListNode> resultListNodes = new ArrayList<>();

        while (l1 != null || l2 != null) {

            if (l1 == null) {

                if (l2.val + reminder >= 10) {

                    summation = (l2.val + reminder - 10);
                    reminder = 1;

                } else {
                    summation = (l2.val + reminder);
                    reminder = 0;
                }

                l2 = l2.next;

            } else if (l2 == null) {

                if (l1.val + reminder >= 10) {
                    summation = (l1.val + reminder - 10);
                    reminder = 1;

                } else {

                    summation = (l1.val + reminder);
                    reminder = 0;
                }

                l1 = l1.next;

            } else {

                if ((l1.val + l2.val) + reminder >= 10) {

                    summation = (l1.val + l2.val + reminder - 10);
                    reminder = 1;
                } else {

                    summation = (l1.val + l2.val + reminder);
                    reminder = 0;
                }

                l1 = l1.next;
                l2 = l2.next;

            }

            resultListNodes.add(new ListNode(summation));

        }

        if (reminder == 1) {
            resultListNodes.add(new ListNode(reminder));
        }

        for (int i = resultListNodes.size() - 2; i >= 0 ; i--) {

            resultListNodes.get(i).next = resultListNodes.get(i + 1);
        }

        return resultListNodes.get(0);
    }

    private static ListNode creatListNode(final int [] ar) {

        final List<ListNode> listNodes = new ArrayList<>();
        int pointer = 0;

        for (int i = ar.length - 1; i >= 0; i--) {
            if(i == ar.length - 1) {

                listNodes.add(new ListNode(ar[i]));
            } else {

                listNodes.add(new ListNode(ar[i], listNodes.get(pointer - 1)));
            }
            pointer++;

        }
        return listNodes.get(listNodes.size()-1);
    }

}