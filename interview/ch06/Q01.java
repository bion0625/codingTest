package interview.ch06;

public class Q01 {

    public static void main(String[] args) {
        Q01 q01 = new Q01();
        String s = "Do geese see God?";
        long startTime,endTime,duration;

        startTime = System.nanoTime();
        System.out.println("1" + s + " => " + q01.isPalindrom1(s));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("duration: " + duration);
        System.out.println();

        startTime = System.nanoTime();
        System.out.println("2" + s + " => " + q01.isPalindrom2(s));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("duration: " + duration);
        System.out.println();
    }


    public boolean isPalindrom1(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 서로 중앙으로 이동해가다 겹치는 지점에 이르면 종료
        while (start < end) {
            // 영숫자인지 판별하고 유효하지 않으면 한 칸씩 이동
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            // 유효한 문자라면 앞 글자와 뒷글자를 모두 소문자로 변경해 비교
            } else {
                // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
                start++;
                end--;
            }
        }
        // 무사히 종료될 겅우 펠린드롬이므로 true 리턴
        return true;
    }

    public boolean isPalindrom2(String s) {
        // 정규식으로 유효한 문자만 추출한 다음 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 문자열을 뒤집은 다음 String으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        // 두 문자열이 동일한지 비교
        return s_filtered.equals(s_reversed);
    }
}
