package doitStarter.ch0503;

import java.util.Arrays;
import java.util.Scanner;

public class Q {

    static String[] Hanoi = {"A","B","C"};

    static void move(int no, String x, String y) {
        if (no > 1)
            move(no - 1, x, Arrays.stream(Hanoi).filter(h -> !h.equals(x) && !h.equals(y)).toArray(String[]::new)[0]);

        System.out.printf("원반[%d]을(를) %s기둥에서 %s기둥으로 옮김\n", no, x, y);

        if (no > 1)
            move(no - 1, Arrays.stream(Hanoi).filter(h -> !h.equals(x) && !h.equals(y)).toArray(String[]::new)[0], y);
    }

    static void q7() {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = stdIn.nextInt();

        move(n, "A", "C");
    }

    public static void main(String[] args) {
//        q6(); // TODO

        q7();

//        q8; // TODO
    }
}
