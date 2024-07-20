package doitStarter.ch0102;

import java.util.Scanner;

public class SumVerbose1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while (n <= 0);

        // 합
        int sum = 0;

//        for (int i = 1; i <= n; i++) {
        for (int i = 1; i < n; i++) {
//            if (i < n)                          // 중간 과정
                System.out.print(i + " + ");
//            else System.out.print(i + " = ");   // 마지막 과정
            sum += i;                           // sum에 i를 더함
        }

        System.out.print(n + " = " + (sum += n));  // sum에 n을 더함
    }
}
