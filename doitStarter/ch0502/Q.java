package doitStarter.ch0502;

import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        q5();
    }

    static int cnt = 0;

    static void recur(int n) {
        cnt++;
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    static void qOne() {
        cnt = 0;
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        recur(x);

        System.out.println("cnt: " + cnt);
    }

    static String[] memo;

    static void recurMemo(int n) {
        cnt++;
        if (memo[n + 1] != null)
            System.out.println(memo[n + 1]);
        else {
            if (n > 0) {
                recurMemo(n - 1);
                System.out.println(n);
                recurMemo(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
            }
            else memo[n + 1] = "";
        }
    }

    static void qTwo() {
        cnt = 0;
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요.:");

        int x = stdIn.nextInt();

        memo = new String[x + 2];
        recurMemo(x);

        System.out.println("cnt: " + cnt);
    }

    static void q5() {

        qOne();

        qTwo();
    }
}
