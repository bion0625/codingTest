package doitStarter.ch0501;

import java.util.Arrays;
import java.util.Scanner;

public class Q {
    static void q1() {
        Scanner stdIn = new Scanner(System.in);

        int x;
        System.out.print("정수를 입력하세요: ");
        x = stdIn.nextInt();
        if (x <= 0) {
            System.out.println(x + "의 팩토리얼은 1입니다.");
            return;
        }

        int result = 1;
        for (int i = x; i >= 1; i--) {
            result *= i;
        }
        System.out.println(x + "의 팩토리얼은 " + result + "입니다.");
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요.: "); int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요.: "); int y = stdIn.nextInt();

        while (y != 0) {
            int tempY = y;
            y = x % y;
            x = tempY;
        }

        System.out.println("최대 공약수는 " + x + "입니다.");
    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int tempY = y;
            y = x % y;
            x = tempY;
        }
        return x;
    }

    static int gcdArray(int[] a) {
        int init = gcd(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            init = gcd(init, a[i]);
        }
        return init;
    }

    static void q3() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열 내 모든 정수의 최대공약수를 구합니다.");

        System.out.print("배열의 갯수를 입력하세요.: "); int num = stdIn.nextInt();

        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = stdIn.nextInt();
        }
        System.out.print(Arrays.toString(a) + "의 최대약수는 " + gcdArray(a) + "입니다.");
    }

    public static void main(String[] args) {
        q1();

        q2();

        q3();
    }
}
