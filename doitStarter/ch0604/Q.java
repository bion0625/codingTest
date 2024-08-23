package doitStarter.ch0604;

import java.util.Scanner;

public class Q {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i; j < n; j++)
                if (a[min] > a[j]) min = j;
            for (int j = 0; j < n; j++) {
                System.out.print(j == i ? "* " : j == min ? "+ " : "  ");
            }
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
            swap(a, i, min);
        }
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];

            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();

            int idx = i;
            while (idx > 0 && a[idx-1] > tmp) {
                idx--;
            }
            for (int k = 0; k < n; k++) {
                System.out.print(k == i ? "+ " : k == idx ? "^-" : k < i && k > idx ? "--" : "  ");
            }
            System.out.println();

            int j;
            for (j = i; j > 0 && a[j-1] > tmp; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    static void binaryInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int pl = 0;
            int pr = i;
            int pm = (pl + pr) / 2;

            // 0부터 i까지 수 중에 a[i]와 같거나 큰 수 중에 가장 작은 값(pm) 이진 검색으로 찾아내기
            while (pl < pr) {
                if (a[pm] < a[i]) pl = pm + 1; // 작다
                else if (a[pm] >= a[i]) pr = pm; // 크다
                pm = (pl + pr) / 2;
            }

            // 찾아낸 큰 값(pm)부터 i값까지 뒤로 밀고, a[pm]에 a[i] 넣기
            int tmp = a[i];
            for (int j = i; j > pm; j--) {
                a[j] = a[j-1];
            }
            a[pm] = tmp;
        }
    }

    static void q6() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    static void q7() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    static void q9() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        binaryInsertionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    public static void main(String[] args) {
//        q6();
//
//        q7();

//        q8(); TODO

        q9();
    }
}
