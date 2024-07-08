package ch06;

import java.util.*;

public class Q05 {
    public static void main(String[] args) {
        String[] s = new String[] {"eat", "tea", "tan", "ate", "ant", "cat"};

        Q05 q = new Q05();

        System.out.println();
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + (i == s.length - 1 ? "" : ","));
        }
        System.out.println();
        System.out.println(q.groupAnagrams(s));
    }

    public List<List<String>> groupAnagrams(String[] str) {
        // 에너그램 결과를 보고나하기 위한 맵 선언
        Map<String, List<String>> results = new HashMap<>();
        // 입력값인 문자열 배열을 순회
        for (String s : str) {
            // 문자열을 문자 배열로 변환
            char[] chars = s.toCharArray();
            // 문자 배열 정렬
            Arrays.sort(chars);
            // 문자 배열을 키로 하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            List<String> list = results.getOrDefault(key, new ArrayList<>());
            // 키에 해당하는 리스트에 추가
            list.add(s);

            results.put(key, list);
        }
        // 문제에서 요구하는 출력값 형태로 변경
        return new ArrayList<>(results.values());
    }
}
