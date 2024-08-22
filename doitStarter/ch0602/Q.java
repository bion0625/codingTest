package doitStarter.ch0602;

import java.util.Scanner;

public class Q {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < n - i; j++)
                if (a[j-1] > a[j])
                    swap(a, j-1, j);
    }

    static void bubbleSortWithPrint(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            System.out.println("패스" + (i + 1) + ":");
            for (int j = 1; j < n - i; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(a[k] + (j == k + 1 ? a[j-1] > a[j] ? "+" : "-" : " "));
                }
                System.out.println();
                if (a[j-1] > a[j])
                    swap(a, j-1, j);
            }
        }
    }

    static void bubbleSortWithPrintV2(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exChange = 0;
            System.out.println("패스" + (i + 1) + ":");
            for (int j = 1; j < n - i; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(a[k] + (j == k + 1 ? a[j-1] > a[j] ? "+" : "-" : " "));
                }
                System.out.println();
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                    exChange++;
                }
            }
            System.out.println();
            if (exChange == 0) return;
        }
    }

    static void bubbleSortWithPrintV3(int[] a, int n) {
        int k = n - 2;
        int last = n - 2;
        int cnt = 1;
        while (k > 0) {
            System.out.println("패스" + cnt + ":");
            int exChange = 0;
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[j] + (i == j ? a[i] > a[i+1] ? "+" : "-" : " "));
                }
                System.out.println();
                if (a[i] > a[i+1]) {
                    last = i;
                    exChange++;
                    swap(a, i, i+1);
                }
            }
            k = last;
            if (exChange == 0)break;
            System.out.println();
            cnt++;
        }
    }

    static void cocktailBubbleSortWithPrintV3(int[] a, int n) {
        int k = n - 2;
        int last = n - 2;
        int cnt = 1;
        while (k > 0) {
            System.out.println("패스" + cnt + ":");
            int exChange = 0;
            if (cnt%2 == 0) {
                for (int i = 0; i <= k; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(a[j] + (i == j ? a[i] > a[i+1] ? "+" : "-" : " "));
                    }
                    System.out.println();
                    if (a[i] > a[i+1]) {
                        last = i;
                        exChange++;
                        swap(a, i, i+1);
                    }
                }
            } else {
                for (int i = n - k - 1; i < n - 1; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        System.out.print((i == j ? a[i] > a[i+1] ? "+" : "-" : " ") + a[j]);
                    }
                    System.out.println();
                    if (a[i] > a[i+1]) {
                        last = i;
                        exChange++;
                        swap(a, i, i+1);
                    }
                }
            }

            k = last;
            if (exChange == 0)break;
            System.out.println();
            cnt++;
        }
    }

    static void q1() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSortWithPrint(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    static void q3() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 2)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSortWithPrintV2(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    static void q4() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSortWithPrintV3(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    static void q5() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        cocktailBubbleSortWithPrintV3(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    public static void main(String[] args) {
        q1();

        q2();

        q3();

        q4();

        q5();
    }
}
