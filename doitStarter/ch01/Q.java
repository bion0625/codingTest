package doitStarter.ch01;

public class Q {
    public static void main (String[] args) {
        // Q1
        System.out.println("max4(1,2,3,4)=" + max4(1,2,3,4));
        System.out.println("max4(4,3,2,1)=" + max4(4,3,2,1));

        // Q2
        System.out.println("min3((4,3,2)=" + min3(4,3,2));
        System.out.println("min3((4,1,2)=" + min3(4,1,2));

        // Q3
        System.out.println("min4((4,1,2,3)=" + min4(4,1,2,3));
        System.out.println("min4((1,2,3,4)=" + min4(1,2,3,4));

        // Q4
        System.out.println("med3(3,2,1) = " + med3(3,2,1)); // a>b>c
        System.out.println("med3(3,2,2) = " + med3(3,2,2)); // a>b=c
        System.out.println("med3(3,1,2) = " + med3(3,1,2)); // a>c>b
        System.out.println("med3(3,2,3) = " + med3(3,2,3)); // a=c>b
        System.out.println("med3(2,1,3) = " + med3(2,1,3)); // c>a>b
        System.out.println("med3(3,3,2) = " + med3(3,3,2)); // a=b>c
        System.out.println("med3(3,3,3) = " + med3(3,3,3)); // a=b=c
        System.out.println("med3(2,2,3) = " + med3(2,2,3)); // c>a=b
        System.out.println("med3(2,3,1) = " + med3(2,3,1)); // b>a>c
        System.out.println("med3(2,3,2) = " + med3(2,3,2)); // b>a=c
        System.out.println("med3(1,3,2) = " + med3(1,3,2)); // b>c>a
        System.out.println("med3(2,3,3) = " + med3(2,3,3)); // b=c>a
        System.out.println("med3(1,2,3) = " + med3(1,2,3)); // c>b>a
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }

    static int med3(int a, int b, int c) {
//        if ((b >= a && c <= a) || (b <= a && c >= a)) return a;
//        else if (a > b && c < b || (a < b && c > b)) return b;
//        return c;

        if (a < b)
            if (a >= c) return a;
            else if (b > c) return c;
            else return b;
        else if (a < c) return a;
        else if (b >= c) return b;
        else return c;
    }
}
