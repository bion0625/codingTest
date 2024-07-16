package interview.ch08;

import java.math.BigInteger;

public class Q16 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3};
        ListNode list1 = new ListNode(nums[0]);
        ListNode cur = list1;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        nums = new int[]{5,6,2};
        ListNode list2 = new ListNode(nums[0]);
        cur = list2;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        Q16 q = new Q16();
        ListNode result = q.addTwoNumbers2(list1, list2);
        while (result != null) {
            System.out.println("result => " + result.val);
            result = result.next;
        }
    }

    public ListNode solution(ListNode list1, ListNode list2) {
        int t = 1;
        int resultInt = 0;
        while (list1 != null && list2 != null) {
            resultInt += (list1.val+list2.val) * t;
            list1 = list1.next;
            list2 = list2.next;
            t *= 10;
        }
        char[] cArr = String.valueOf(resultInt).toCharArray();
        ListNode result = new ListNode(Character.getNumericValue(cArr[cArr.length - 1]));
        ListNode cur = result;
        for (int i = cArr.length - 2; i >= 0 ; i--) {
            cur.next = new ListNode(Character.getNumericValue(cArr[i]));
            cur = cur.next;
        }
        return result;
    }

    public ListNode reverseList(ListNode head) {
        // 노드 끝으로 이동할 때까지 순회
        ListNode prev = null;
        while (head != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = head.next;
            // 현재 노드의 다음으로 이전 노드 지정
            head.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = head;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            head = next;
        }
        return prev;
    }

    // 연결 리스트를 임의 정밀도 정수형으로 변환
    public BigInteger toBigInteger(ListNode node) {
        String val = "";
        // 연결 리스트를 순회하며 한 글자씩 조합
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        // 조합한 글자를 임의 정밀도 정수형으로 변환
        return new BigInteger(val);
    }

    // 임의 정밀도 정수형을 연결 리스트로 변환
    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;
        // 정수형을 문자로 바꾼 다음 문자 배열로 전환하여 한 글자씩 순회
        for (char c : String.valueOf(val).toCharArray()) {
            // 한 글자씩 숫자로 변환하여 노드 지정
            node = new ListNode(Character.getNumericValue(c));
            // 최종 결과는 뒤집어야 하므로 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2개의 연결 리스트를 뒤집는다.
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        // 임의 정밀도 정수형으로 변환하여 더하기 연산 진행
        BigInteger result = toBigInteger(l1Reversed).add(toBigInteger(l2Reversed));
        // 결과를 다시 역순 연결 리스트로 변환
        return toReversedLinkedList(result);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry = 0, remainder;
        // 모든 연결 리스트를 끝까지 순회하고, 자리 올림수도 0이 될 때까지 진행
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫 번째 연결 리스트 합산 및 진행
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 ㅇ녀결 리스트 합산 및 진행
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10;
            // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10;
            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(remainder);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }
        // 첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
        return root.next;
    }
}
