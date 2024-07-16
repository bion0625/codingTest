package interview.ch08;

public class Q15 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        Q15 q = new Q15();
        ListNode result = q.reverseList2(head);
        while (result != null) {
            System.out.println("result => " + result.val);
            result = result.next;
        }
    }

    public ListNode reverse(ListNode node, ListNode prev) {
        // 현재 노드인 node가 널이면 리턴
        if (node == null) return prev;
        // 현재 노드의 다음 노드 미리 지정
        ListNode next = node.next;
        // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출
        node.next = prev;
        return reverse(next, node);
    }

    public ListNode reverseList (ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverseList2 (ListNode head) {
        ListNode prev = null, node = head;
        // 노드 끝으로 이동할 때까지 순회
        while (node != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = node.next;
            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }
        // prev는 뒤집힌 연결 리스트의 첫 번째 노드
        return prev;
    }
}
