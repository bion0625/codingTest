package doitStarter.ch0607;

import java.util.Arrays;
import java.util.Comparator;

public class Q {

    static class PhyscData {
        String name;
        int height;
        double vision;

        PhyscData(String name,int height,double vision) {
            this.name = name; this.height = height; this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new PhyscData.HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? 1:
                        (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    static void q15() {
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8)
        };

        Arrays.sort(x, (d1, d2) -> {
            double v = d2.vision - d1.vision;
            return v > 0 ? 1 : v < 0 ? -1 : 0;
        });

        System.out.println("■ 신체검사 리스트 ■");
        System.out.println("이름\t\t  키   시력");
        System.out.println("------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }
    
    public static void main(String[] args) {
        q15();
    }
}
