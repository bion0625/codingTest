package ch08;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }

     @Override
     public String toString() {
         StringBuilder result = new StringBuilder();
         ListNode node = this;
         while (node != null) {
             result.append(" ").append(node.val).append(node.next != null ? "," : " ");
             node = node.next;
         }
         return "ListNode{" +
                 result +
                 '}';
     }
 }
