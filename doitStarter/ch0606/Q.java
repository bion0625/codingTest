package doitStarter.ch0606;

import doitStarter.ch0401.IntStack;

import java.util.Scanner;

public class Q {

    static void swap(int[] a, int idx1, int idx2) {
        int t= a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        System.out.println("lstack.push("+left+")");
        rstack.push(right);
        System.out.println("rstack.push("+right+")");

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            System.out.println("x = " + x);
            System.out.printf("lstack.pop() - a[%d] ~ rstack.pop() - a[%d]: {", left, right);
            for (int i = left; i < right; i++)
                System.out.printf("%d , ", a[i]);
            System.out.printf("%d}\n", a[right]);

            do {
                while (a[pl] < x)pl++;
                while (a[pr] > x)pr--;
                if (pl<=pr) swap(a, pl++, pr--);
            } while (pl <= pr);

            System.out.printf("lstack.pop() - a[%d] ~ rstack.pop() - a[%d]: {", left, right);
            for (int i = left; i < right; i++)
                System.out.printf("%d , ", a[i]);
            System.out.printf("%d}\n", a[right]);

            System.out.println();

            if (left < pr) {
                lstack.push(left);
                System.out.println("lstack.push("+left+")");
                rstack.push(pr);
                System.out.println("rstack.push("+pr+")");
            }
            if (pl < right) {
                lstack.push(pl);
                System.out.println("lstack.push("+pl+")");
                rstack.push(right);
                System.out.println("rstack.push("+right+")");
            }
        }
    }

    static void quickSort2(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        System.out.printf("a[%d]~a[%d]: {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x)pl++;
            while (a[pr] > x)pr--;
            if (pl<=pr) swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr && pl < right) {
            if(pr - left < right - pl) {
                quickSort(a, left, pr);
                quickSort(a, pl, right);
            } else {
                quickSort(a, pl, right);
                quickSort(a, left, pr);
            }
        } else {
            if (left < pr) quickSort(a, left, pr);
            if (pl < right) quickSort(a, pl, right);
        }
    }

    static void quickSort3(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            do {
                while (a[pl] < x)pl++;
                while (a[pr] > x)pr--;
                if (pl<=pr) swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr && pl < right) {
                if (pr - left < right - pl) {
                    lstack.push(left);
                    rstack.push(pr);
                    lstack.push(pl);
                    rstack.push(right);
                } else {
                    lstack.push(pl);
                    rstack.push(right);
                    lstack.push(left);
                    rstack.push(pr);
                }
            }
            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    static void insertionSort(int[] a, int nx) {
        for (int i = 1; i < nx; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    int t = a[i];
                    for (int k = i; k > j; k--)
                        a[k] = a[k - 1];
                    a[j] = t;
                }
            }
        }
    }

    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a]) swap(x, a, b);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);
        return b;
    }

    static void quickSort4(int[] a, int left, int right) {
        if (right <= 8) {
            insertionSort(a, right + 1);
            return;
        }
        int pl = left;
        int pr = right;
        int m = sort3elem(a, pl, (pl + pr) / 2, pr); // 처음, 가운데, 끝 요소를 정렬
        int x = a[m]; // 피벗

        swap(a, m, right - 1); // 가운데 요소와 끝에서 두 번째 요소를 교환
        pl++; // 왼쪽 커서를 오른쪽으로 1만큼 진행
        pr -= 2; // 오른쪽 커서를 왼쪽으로 2만큼 진행

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    static void quickSort5(int[] a, int n) {
        quickSort4(a, 0, n - 1);
    }

    static void q11() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i +"]=" + x[i]);
        }
    }

    static void q12() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort3(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i +"]=" + x[i]);
        }
    }

    static void q13() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort4(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    static void q14() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort5(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }

    public static void main(String[] args) {
        q11();

        q12();

        q13();

        q14();
    }
}
