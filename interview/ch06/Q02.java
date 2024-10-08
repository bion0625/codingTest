package interview.ch06;

public class Q02 {
    public static void main(String[] args) {
        char[] s = new char[] {'r', 'a', 'c', 'e', 'c', 'a', 'r'};

        Q02 q = new Q02();
        char[] result = q.reverseString(s);

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + (i == s.length - 1 ? "" : ","));
        }

        System.out.println();

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "" : ","));
        }
    }

    public char[] reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // 임시 변수를 이용해 값 스왑
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
            start++;
            end--;
        }
        return s;
    }
}
