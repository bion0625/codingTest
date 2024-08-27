package doitStarter.ch0609;

import java.util.Arrays;
import java.util.Scanner;

public class Q {
    static void printSort(int[] a, int[] b, int[] f) {
        System.out.println("a= " + Arrays.toString(a));
        System.out.println("f= " + Arrays.toString(f));
        System.out.println("b= " + Arrays.toString(b));
        System.out.println();
    }

    static void countingSort(int[] a, int n, int max, int min) {
        int[] f = new int[max + 1]; // 누적 도수
        int[] b = new int[n]; // 작업용 목표 배열

        printSort(a, b, f);
        for (int i = 0; i < n; i++) f[a[i]]++;
        printSort(a, b, f);
        for (int i = min; i <= max; i++) f[i] += f[i-1];
        printSort(a, b, f);
        for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
        printSort(a, b, f);
        for (int i = 0; i < n; i++) a[i] = b[i];
        printSort(a, b, f);
    }

    static void countingSort(int[] a, int n, int max) {
        int[] f = new int[max + 1]; // 누적 도수
        int[] b = new int[n]; // 작업용 목표 배열

        printSort(a, b, f);
        for (int i = 0; i < n; i++) f[a[i]]++;
        printSort(a, b, f);
        for (int i = 1; i <= max; i++) f[i] += f[i-1];
        printSort(a, b, f);
        for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
        printSort(a, b, f);
        for (int i = 0; i < n; i++) a[i] = b[i];
        printSort(a, b, f);
    }

    static void q17() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 0; i < nx; i++)
            if (x[i] > max) max = x[i];

        countingSort(x, nx, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    static void q18() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        int min = x[0];
        for (int i = 0; i < nx; i++) {
            if (x[i] > max) max = x[i];
            if (x[i] < min) min = x[i];
        }

        countingSort(x, nx, max, min);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    public static void main(String[] args) {
        q17();

        q18();
    }
}
