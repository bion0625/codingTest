package ch06;

public class Q06 {
    public static void main(String[] args) {
        String s = "dcbabcdd";

        Q06 q = new Q06();
        String result = q.longestPalindrome(s);

        System.out.println(s + " => " + result);
    }

//    public String solution(String s) {
//        if (s.length() < 2) return s;
//        String two = getSubString(0, 1, s);
//        String three = getSubString(0, 2, s);
//        return two.length() > three.length() ? two : three;
//    }
//
//    private String getSubString(int x, int y, String s) {
//        while (x >= 0 && y < s.length()) {
//            if(s.charAt(x) == s.charAt(y)) {
//                x--;
//                y++;
//            } else {
//                x++;
//                y++;
//            }
//        }
//        return s.substring(x+1, y);
//    }

    int left, maxLen;

    public void extendPalindrome(String s, int j, int k) {
        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 펠린드롬인 경우 범위 확장
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }
    }

    public String longestPalindrome(String s) {
        // 문자 길이 저장
        int len = s.length();

        // 길이가 1인 경우 예외 처리
        if (len < 2) return s;

        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i+1);
            extendPalindrome(s, i, i+2);
        }

        // 왼쪽과 최대 길이만큼을 더한 오른쪽만큼의 문자를 정답으로 리턴
        return s.substring(left, left + maxLen);
    }
}
