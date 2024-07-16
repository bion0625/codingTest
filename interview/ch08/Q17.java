package interview.ch08;

public class Q17 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6};
//        int[] nums = new int[]{1,2,3};

        ListNode head = new ListNode(nums[0]);

        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        Q17 q = new Q17();
        ListNode result = q.swapPairs3(head);
        q.printListNode(result);

    }

    private void printListNode(ListNode node) {
        while (node != null) {
            System.out.println("node => " + node.val);
            node = node.next;
        }
    }

    public ListNode solution (ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode result = head.next;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            ListNode temp = cur;
            cur = cur.next;
            cur.next = temp;
            cur.next.next = next;
            if (prev != null) prev.next = cur;
            prev = cur.next;
            cur = next;
        }
        return result;
    }

    public ListNode swapPairs(ListNode head) {
        // 스왑을 진행할 노드 선언
        ListNode node = head;

        // 현재 노드와 다음 노드가 존재하면 계속 진행
        while (node != null && node.next != null) {
            // 임시 변수를 이용해 값만 교환
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        // 첫 번째 노드를 정답으로 리턴
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;
        // 다음 노드는 첫 번째 노드로 지정
        node.next = head;
        // 다음 노드와 다음 다음 노드가 있으면 반복
        while (node.next != null && node.next.next != null) {
            // a는 다음 노드
            ListNode a = node.next;
            // b는 다음 다음 노드
            ListNode b = node.next.next;
            // 위치 변경
            a.next = b.next;
            node.next = b;
            node.next.next = a;
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        // 첫 번째 노드는 임시 노드이브로 그다음부터 결과로 리턴
        return root.next;
    }

    public ListNode swapPairs3(ListNode head) {
        // 현재 노드와 다음 노드가 있으면 반복
        if (head != null && head.next != null) {
            // 다음 노드 선언
            ListNode p = head.next;
            // 다음 다음 노드를 파라미터로 전달하고 스왑된 값을 리턴 받음
            head.next = swapPairs3(head.next.next);
            // 다음 노드는 현재 노드로 지정
            p.next = head;
            // 다음 노드 리턴
            return p;
        }
        return head;
    }
}
