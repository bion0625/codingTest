package doitStarter.ch0701;

import java.util.Scanner;

public class Q {

    static int bfMatch(String txt, String pat) {
        int pt = 0; // txt 커서
        int pp = 0; // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            System.out.println(txt);
            System.out.printf(String.format("%%%ds\n", pt + 1), (txt.charAt(pt) == pat.charAt(pp)) ? "+" : "|");
            System.out.printf(String.format("%%%ds\n", pt - pp + pat.length()), pat);
            System.out.println();
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) // 검색 성공
            return pt - pp;
        return -1; // 검색 실패
    }

    static int bfMatchLast(String txt, String pat) {
        int pt = 0; // txt 커서
        int pp = 0; // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            System.out.println(txt);
            System.out.printf(String.format("%%%ds\n", pt + 1), (txt.charAt(pt) == pat.charAt(pp)) ? "+" : "|");
            System.out.printf(String.format("%%%ds\n", pt - pp + pat.length()), pat);
            System.out.println();
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) // 검색 성공
            return pt;
        return -1; // 검색 실패
    }

    static void q1() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();

        System.out.print("패 턴: ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패 턴: %%%ds\n", len), s2);
        }
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();

        System.out.print("패 턴: ");
        String s2 = stdIn.next();

        int idx = bfMatchLast(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx-s2.length(); i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx - s2.length() + 1) + "번째부터 " + idx + "번째까지 문자 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패 턴: %%%ds\n", len), s2);
        }
    }

    public static void main(String[] args) {
        q1();
        q2();
    }
}
