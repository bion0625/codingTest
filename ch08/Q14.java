package ch08;

public class Q14 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        int[] first = new int[]{1,2,5};
        int[] second = new int[]{1,3,4};
        ListNode current = head1;
        for (int i = 1; i < first.length; i++) {
            current.next = new ListNode(first[i]);
            current = current.next;
        }
        current = head2;
        for (int i = 1; i < second.length; i++) {
            current.next = new ListNode(second[i]);
            current = current.next;
        }

        Q14 q = new Q14();
        ListNode result = q.mergeTwoLists(head1, head2);
        while (result!= null) {
            System.out.println("result => " + result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 두 노드 중 한쪽이 널이면 널이 아닌 노드를 리턴
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // list2가 더 크면 list1에 재귀 호출 결과를 엮고 list1을 리턴
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
            // list1이 더 크거나 같으면 list2에 재귀 호출 결과를 엮고 list2를 리턴
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
