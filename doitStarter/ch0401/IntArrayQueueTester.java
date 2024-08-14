package doitStarter.ch0401;

import java.util.Scanner;

public class IntArrayQueueTester {
    public static void main(String[] args) {
        IntArrayQueue queue = new IntArrayQueue(64);
        Scanner stdIn = new Scanner(System.in);

        while (true) {
            System.out.printf("%d / %d:", queue.size(), queue.getCapacity());

            System.out.print(" (1) enque; (2) deque; (3) peek; (4) clear; (5) dump; (0) close this\n -> ");
            int menu = stdIn.nextInt();
            int x;
            if (menu == 0) break;
            switch (menu) {
                case 1:
                    System.out.print("enque: ");
                    x = stdIn.nextInt();
                    queue.enque(x);
                    break;
                case 2:
                    System.out.println("deque: " + queue.deque());
                    break;
                case 3:
                    System.out.println("peek: " + queue.peek());
                    break;
                case 4:
                    queue.clear();
                    break;
                case 5:
                    queue.dump();
            }
        }
    }
}
