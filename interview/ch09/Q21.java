package interview.ch09;

import java.util.*;

public class Q21 {
    public static void main(String[] args) {
        // acdb
        String s = "dbacdcbc";
        Q21 q = new Q21();
        String result = q.removeDuplicateLetters2(s);
        System.out.println("result => " + result);
    }

    public Set<Character> toSortedSet(String s) {
        // 문자열을 문자 단위 집합으로 저장할 변수 선언
        Set<Character> set = new TreeSet<>((c1, c2) -> {
            // 비교 메소드 재정의
            // 동일한 문자이면 무시
            if (c1 == c2) return 0;
            // 새로운 문자(c1)가 기본 문자(c2)보다 크면 뒤에 위치
            else if (c1 > c2) return 1;
            // 작으면 앞에 위치
            else return -1;
        });
        // 문자열을 문자 단위로 집합에 저장, 정렬된 상태로 저장된다.
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public String removeDuplicateLetters(String s) {
        // 정렬된 문자열 집합 순회
        for (Character c : toSortedSet(s)) {
            // 해당 문자가 포함된 위치부터 접미사로 지정
            String suffix = s.substring(s.indexOf(c));
            // 전체 집합과 접미사 집합이 일치하면 해당 문자 정답에 추가하고 재귀 호출 진행
            if (toSortedSet(s).equals(toSortedSet(suffix)))
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
        }
        return "";
    }

    public String removeDuplicateLetters2(String s) {
        // 문자 개수를 계산해서 담아둘 변수 선언
        Map<Character, Integer> counter = new HashMap<>();
        // 이미 처리한 문자 여부를 확인하기 위한 변수 선언
        Map<Character, Boolean> seen = new HashMap<>();
        // 문제 풀이에 이용할 스택 선언
        Deque<Character> stack = new ArrayDeque<>();

        // 문자별 개수 계산
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            // 현재 처리하는 문자는 카운터에서 - 1 처리
            counter.put(c, counter.get(c) - 1);
            // 이미 처리한 문자는 건너뛴다.
            if (seen.get(c) != null && seen.get(c) == true) continue;
            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙어야 할 문자라면 스택에서 제거하고 처리하지 않은 걸로 표시
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) seen.put(stack.pop(), false);
            // 현재 문자를 스택에 삽입
            stack.push(c);
            // 현재 문자를 처리한 걸로 선언
            seen.put(c, true);
        }

        // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        return sb.toString();
    }
}
