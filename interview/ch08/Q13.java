package interview.ch08;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class Q13 {
    public static void main(String[] args) {
//        ListNode first = new ListNode(1);
//        ListNode second = new ListNode(2, first);
//        ListNode three = new ListNode(3, second);
//        ListNode four = new ListNode(2, three);
//        ListNode head = new ListNode(1, four);

        int[] nums = new int[]{1,2,3,2,1};
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }


        Q13 q = new Q13();
        boolean isPalindrome = q.isPalindrome3(head);
        System.out.println("isPalindrome => " + isPalindrome);
    }

    public boolean isPalindrome(ListNode head) {
        // 주의: 스택을 이렇게 선언하면 안 됨
        Stack<Integer> stack = new Stack<>();
        // 연결 리스트를 스택에 삽입
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        // 연결 리스트가 모두 빌 때까지 비교
        while (head != null) {
            // 연결 리스트와 스택에서 추출한 값을 비교해 펠린드롬 판별
            if (head.val != stack.pop()) return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        // 연결 리스트를 데크에 삽입
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }

        // 데크가 모두 비거나(짝수 개일 때) 1개 이하(홀수 개일 때)가 될 때까지 비교
        while (!deque.isEmpty() && deque.size() > 1) {
            // 데크의 양 끝을 추출해 팰린드롬 여부 확인
            if (!Objects.equals(deque.pollFirst(), deque.pollLast())) return false;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        ListNode fast = head, slow = head;
        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
        if (fast != null) slow = slow.next;

        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다.
        ListNode rev = null;
        while (slow != null) {
            // 트린 러너로 역순 연결 리스트 rev를 만들어나간다.
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        // rev 연결 리스트를 끝까지 이동하며 비교
        while (rev != null) {
            // 역순 연결 리스트 rev오하 기존 연결 리스트 head를 차례대로 비교
            if (rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}
