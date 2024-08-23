package doitStarter.ch0605;

import java.util.Scanner;

public class Q {
    static int cnt = 0;

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp= a[i];
            for (j = i; j > 0 && a[j-1] > tmp; j--) {
                cnt++;
                a[j] = a[j-1];
            }
            cnt++;
            a[j] = tmp;
        }
    }

    static void shellSort(int[] a, int n) {
        int h;
        for (h = 1; h < n; h = h * 3 + 1);

        for ( ; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    cnt++;
                    a[j + h] = a[j];
                }
                cnt++;
                a[j + h] = tmp;
            }
        }
    }

    static void q10() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(버전 2)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        cnt = 0;
//        insertionSort(x, nx);
        shellSort(x, nx);

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }

        System.out.println("cnt: " + cnt);
    }

    public static void main(String[] args) {
        q10();
    }
}
