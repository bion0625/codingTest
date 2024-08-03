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

        int[] arr = {5,3,7,4,7,4,0,9};
        int[] reversed = Arrays.stream(arr)
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .mapToInt(Integer::intValue)
                .toArray();

        // [9,7,7,5,4,4,3,0]
        System.out.println(Arrays.toString(reversed));

        String[] words = {"java","algorithm","programming","happy","fun","coding"};
        Arrays.sort(words, (v1, v2) -> v1.length() - v2.length());

        // [fun, java, happy, coding, algorithm, programming]
        System.out.println(Arrays.toString(words));
    }
}
