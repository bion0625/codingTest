package doitStarter.ch0201;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        // Q1
        q1();

        // Q2
        q2();

        // Q3
        System.out.print("Q3 요소수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        int sum = sumOf(x);
        System.out.println("sum = " + sum);

        // Q4
        System.out.print("Q4 요소수: ");
        num = stdIn.nextInt();
        x = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        int[] k = new int[x.length];
        copy(k, x);
        System.out.println(Arrays.toString(k));

        // Q5
        System.out.print("Q5 요소수: ");
        num = stdIn.nextInt();
        x = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        k = new int[x.length];
        rcopy(k, x);
        System.out.println(Arrays.toString(k));

        // Q6
        q6();
    }

    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    static void q1() {
        Random rand = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        int num = rand.nextInt(10);

        int[] height = new int[num];

        System.out.println("킷값은 아래와 같습니다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }

    static void swap(int[] a, int idx1, int idx2) {
        System.out.println("a[" + idx1 + "]과 a[" + idx2 + "]을 교환합니다.");
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
            System.out.println(Arrays.toString(a));
        }
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = stdIn.nextInt();

        int[] x = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.println(Arrays.toString(x));
        reverse(x);
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    static int sumOf(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    static void copy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++)
            a[i] = b[i];
    }

    static void rcopy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++)
            a[b.length - i - 1] = b[i];
    }

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            System.out.print(r + "|   " + x);
            d[digits] = dchar.charAt(x % r);
            System.out.println("..." + d[digits]);
            System.out.println(" +-----");
            digits++;
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return digits;
    }

    static void q6() {
        Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        int dno;
        int retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수: ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36): ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConv(no, cd, cno);

            System.out.print(cd + "진수로 ");
            for (int i = 0; i < dno; i++)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1_예/0_아니요): ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
