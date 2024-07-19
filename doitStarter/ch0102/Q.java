package doitStarter.ch0102;

import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        // Q7
        System.out.println("gSum(10)=" + gSum(10));

        // Q8
        System.out.println("sumof(10,11)=" + sumof(10, 11));
        System.out.println("sumof(11,10)=" + sumof(11, 10));
        System.out.println("sumof(5,11)=" + sumof(5, 11));

        // Q9
        System.out.println("b - a는 " + minus() + "입니다.");

        // Q10
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        System.out.println("그 수는 " + tenString(n) + "자리입니다.");
    }

    static int gSum(int n) {
        return n * (n + 1) / 2;
    }

    static int sumof(int a, int b) {
        if (a > b) return gSum(a) - gSum(b-1);
        else return gSum(b) - gSum(a-1);
    }

    static int minus() {
        Scanner stdIn = new Scanner(System.in);

        int a, b;
        System.out.print("a값: "); a = stdIn.nextInt();
        do {
            System.out.print("b값: "); b = stdIn.nextInt();
            if (b <= a) System.out.println("a 보다 큰 값을 입력하세요.");
        } while (b <= a);

        return b - a;
    }

    static int tenString(int n) {
        int cnt = 1;
        do {
            n = n/10;
            cnt++;
        } while (n/10 >= 1);
        return cnt;
    }
}
