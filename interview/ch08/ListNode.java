package interview.ch08;

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
    ListNode(int[] nums) {
         this.val = nums[0];
         ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
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
