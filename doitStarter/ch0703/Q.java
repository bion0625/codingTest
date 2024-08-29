package doitStarter.ch0703;

import java.util.Arrays;
import java.util.Scanner;

public class Q {
    static int bmpMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표

        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen;
        for (pt = 0; pt < patLen; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1; // pt = patLen - 1
        System.out.println("skip: " + Arrays.toString(skip));
        // 검색
        while (pt < txtLen) {
            pp = patLen - 1;
            System.out.println(txt);
            System.out.printf(String.format("%%%ds\n", pt + 1), (txt.charAt(pt) == pat.charAt(pp)) ? "+" : "|");
            System.out.printf(String.format("%%%ds\n", pt - pp + pat.length()), pat);
            System.out.println();

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) return pt;
                pp--;
                pt--;
                System.out.println(txt);
                System.out.printf(String.format("%%%ds\n", pt + 1), (txt.charAt(pt) == pat.charAt(pp)) ? "+" : "|");
                System.out.printf(String.format("%%%ds\n", pt - pp + pat.length()), pat);
                System.out.println();
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;
    }

    static void q4() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();

        System.out.print("패 턴: ");
        String s2 = stdIn.next();

        int idx = bmpMatch(s1, s2);

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

    public static void main(String[] args) {
        q4();
    }
}
