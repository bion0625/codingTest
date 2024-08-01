package programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2020001234, "홍길동", 90));
        list.add(new Student(2020002345, "김철수", 80));
        list.add(new Student(2020003456, "최아롬", 100));

        Student[] students = {
                new Student(2020001234, "홍길동", 90),
                new Student(2020002345, "김철수", 80),
                new Student(2020003456, "최아롬", 100),
        };

        int[] array = {5,10,7,9,3,2};
        Arrays.sort(array);
        // [2,3,5,7,9,10]
        System.out.println(Arrays.toString(array));

        List<Integer> collection = new ArrayList<>(List.of(5,10,7,9,3,2));
        Collections.sort(collection);
        // [2,3,5,7,9,10]
        System.out.println(collection);

        Stream<Integer> stream = Stream.of(5,10,7,9,3,2).sorted();
        // [2,3,5,7,9,10]
        System.out.println(stream.collect(Collectors.toList()));
    }
}
