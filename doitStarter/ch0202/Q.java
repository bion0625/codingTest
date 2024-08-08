package doitStarter.ch0202;

public class Q {
    public static void main(String[] args) {
        q7();

        q8();
    }

    static void q7() {
        PhysicalExamination.PhyscData[] x = {
                new PhysicalExamination.PhyscData("강민하", 162, 0.3),
                new PhysicalExamination.PhyscData("김찬우", 173, 0.7),
                new PhysicalExamination.PhyscData("박준서", 175, 2.0),
                new PhysicalExamination.PhyscData("유서범", 171, 1.5),
                new PhysicalExamination.PhyscData("이수연", 168, 0.4),
                new PhysicalExamination.PhyscData("장경오", 174, 1.2),
                new PhysicalExamination.PhyscData("황지안", 169, 0.8),
        };
        int[] vdist = new int[PhysicalExamination.VMAX]; // 시력 분포

        System.out.println("■ 신체검사 리스트 ■");
        System.out.println("이름\t\t\t키\t시력");
        System.out.println("------------------------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

        System.out.printf("\n평균 키:%5.1fcm\n", PhysicalExamination.aveHeight(x));

        PhysicalExamination.distVision(x, vdist); // 시력 분포를 구함

        System.out.println("\n시력분포");
        for (int i = 0; i < PhysicalExamination.VMAX; i++) {
            System.out.printf("%3.1f~:", i/10.0);
            String star = "*";
            System.out.print(star.repeat(vdist[i]) + "\n");
        }
    }

    static void q8() {
        YMD ymd = new YMD(2024, 1, 31);
        YMD after = ymd.after(34);
        System.out.println("ymd = " + ymd);
        System.out.println("after = " + after);

        YMD before = ymd.before(31);
        System.out.println("ymd = " + ymd);
        System.out.println("before = " + before);
    }

    static class YMD {
        int y;  // 년
        int m;  // 월
        int d;  // 일

        YMD(int y,int m,int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        YMD after(int n) {
            int ay = this.y;
            int am = this.m;
            int ad = this.d;

            int day = ad + n;
            int monthNum = 28;
            while (day > monthNum) {
                monthNum = getMonthNum(am, ay);
                if (day > monthNum) day -= monthNum;
                am++;
                if (am == 13) {
                    am = 1;
                    ay++;
                }
                monthNum = getMonthNum(am, ay);
            }
            ad = day;
            return new YMD(ay, am, ad);
        }

        YMD before(int n) {
            int ay = this.y;
            int am = this.m;
            int ad = this.d;

            int day = ad - n;
            while (day <= 0) {
                am--;
                if (am == 0) {
                    am = 12;
                    ay--;
                }
                day += getMonthNum(am, ay);
            }
            ad = day;
            return new YMD(ay, am, ad);
        }

        private int getMonthNum(int month, int year) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: return 31;
                case 2:
                    if (isLeepYear(year)) return 29;
                    else return 28;
            }
            return 30;
        }

        private boolean isLeepYear(int year) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) return true;
                    else return false;
                } else return true;
            } else return false;
        }

        @Override
        public String toString() {
            return "YMD{" +
                    "y=" + y +
                    ", m=" + m +
                    ", d=" + d +
                    '}';
        }
    }
}
