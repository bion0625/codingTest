package programmers.sorting;

import java.util.Arrays;

public class Q25 {
    public static void main(String[] args) {
        // n편 논문 중
        // h번 이상 인용된 논문이
        // h편 이상
        // 나머지 논문이 h번 이하 인용
        // h의 최댓값이 H-Index
        // [3,0,6,1,5] -> 3
        int[] citations = {3,0,6,1,5};

        Q25 q = new Q25();
        int result = q.solution(citations);
        System.out.println("result = " + result);

        int result2 = q.solution2(citations);
        System.out.println("result2 = " + result2);

        Q25Solution solution = new Q25Solution();
        int result3 = solution.solution(citations);
        System.out.println("result3 = " + result3);
    }

    public int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for (int h : citations) {
            if (h == 0) continue;
            int tempH = Arrays.stream(citations).filter(citation -> citation >= h).toArray().length;
            if (tempH >= h && tempH >= result) result = h;
        }
        return result;
    }

    public int solution2(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - citations[i] < 0) continue;
            if(citations[citations.length - citations[i]] >= citations[i]) return citations[i];
        }
        return 0;
    }
}
