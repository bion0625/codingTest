package doitStarter.ch0401;

import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        q1();

        q2();

        q3();
    }

    static void q1() {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);
        Stack<String> s = new Stack<>(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }

    static void q3() {
        Scanner stdIn = new Scanner(System.in);
        IntDataStack stack = new IntDataStack(64);
        IntDataStack.BaseStack s = stack.getDataStack();

        while (true) {
            System.out.println();
            System.out.print("(1) forward (2) reverse (0) 종료: ");
            int direction = stdIn.nextInt();
            if (direction != 1 && direction != 2) break;
            switch (direction) {
                case 1: s = stack.getDataStack(); break;
                case 2: s = stack.getReverseStack(); break;
            }
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }
}
