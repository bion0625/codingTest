package doitStarter.ch0303;

import java.util.Arrays;
import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        Q q = new Q();
        q.q1();

        q2();

        q3();

        q4();

        q5();

        q6();
    }

    private int seqSearchSen(int[] a, int key, int[] result) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) result[cnt++] = i;
        }
        return cnt;
    }

    void q1() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);  // 바로 앞의 요소보다 작으면 다시 입력받음
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int[] results = new int[num];
        int idx = seqSearchSen(x, ky, results);

        if (idx == 0)
            System.out.println("그 값의 요소가 없습니다.");
        else
            for (int result : results)
                if (result != 0) System.out.println("그 값은 x[" + result + "]에 있습니다.");

    }

    static int seqSearch(int[] a, int n, int key) {
        System.out.print(" \t|");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println("-------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println(" \t|");
            System.out.print(" \t|");
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + (a[i] == a[j] ? "*" : " "));
            }
            System.out.println();
            System.out.println(i + "\t|\t"+Arrays.toString(a).replace("[","").replace("]","").replaceAll(", ","\t"));
            if (a[i] == key) return i;
        }

        return -1;
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);  // 바로 앞의 요소보다 작으면 다시 입력받음
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }

    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) idx[count++] = i;
        }
        return count;
    }

    static void q3() {
        int[] a = {1,9,2,9,4,6,7,9};
        int n = a.length;
        int key = 9;
        int[] idx = new int[n];

        int result = searchIdx(a, n, key, idx);

        idx = Arrays.stream(idx).filter(i -> i != 0).toArray();

        System.out.println("idx = " + Arrays.toString(idx));
        System.out.println("result = " + result);
    }

    static int binSearchWithPrint(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        System.out.print(" \t|");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println("---------------------------------------");

        do {
            int pc = (pl + pr) / 2;

            System.out.print(" \t|\t");
            for (int i : a) System.out.print((i == a[pc] ? "+" : i == a[pl] ? "<-" : i == a[pr] ? "->" : " ") + "\t");
            System.out.println();

            System.out.print(a[pc] + "\t|\t");
            for (int i : a) System.out.print(i + "\t");
            System.out.println();

            if (a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    static void q4() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);  // 바로 앞의 요소보다 작으면 다시 입력받음
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = binSearchWithPrint(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");

    }

    static int getFirst(int[] a, int idx) {
        for (int i = 0; i <= idx; i++) {
            if(a[i] == a[idx]) return i;
        }
        return idx;
    }

    static int binSearchWithFirst(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                return getFirst(a, pc);
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    static void q5() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);  // 바로 앞의 요소보다 작으면 다시 입력받음
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = binSearchWithFirst(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }

    static void q6() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);

        if (idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
            System.out.println("삽입 포인트는 x[" + (Math.abs(idx) - 1) + "] 입니다.");
        }
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
