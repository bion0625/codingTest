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

        // Q11
        multi99Table();

        // Q12
        plus99Table();

        // Q13
        tetragon();
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

    static void multi99Table() {
        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                System.out.print("   |");
                for (int j = 1; j <=9; j++) {
                    System.out.print("  " + j);
                }
                System.out.print("\n---+---------------------------");
            }
            else {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) System.out.print(i + "  |");
                    else System.out.printf("%3d", i * j);
                }
            }
            System.out.println();
        }
    }

    static void plus99Table() {
        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                System.out.print("   |");
                for (int j = 1; j <=9; j++) {
                    System.out.print("  " + j);
                }
                System.out.print("\n---+---------------------------");
            }
            else {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) System.out.print(i + "  |");
                    else System.out.printf("%3d", i + j);
                }
            }
            System.out.println();
        }
    }

    static void tetragon() {
        Scanner stdIn = new Scanner(System.in);
        int n;
        do {
            System.out.print("변의 길이: ");
            n = stdIn.nextInt();
        } while (n <= 0);
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(n));
        }
    }
}
