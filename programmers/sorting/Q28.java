package programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q28 {
    public static void main(String[] args) {
        // [6,10,2]         ->  "6210"
        // [3,30,34,5,9]    ->  "9534330"
        int[] numbers = {6,10,2};
        Q28 q = new Q28();
        String result = q.solution(numbers);
        System.out.println("result = " + result);

        String result2 = q.solution2(numbers);
        System.out.println("result2 = " + result2);
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+","0");
    }

    public String solution2(int[] numbers) {
        List<String> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(String.valueOf(number));
        }
        List<String> permutations = new ArrayList<>();
        permute(numberList, 0, permutations);

        // 가장 큰 수 찾기
        String maxNumber = permutations.stream().max(String::compareTo).orElse("0");
        return maxNumber.replaceAll("^0+", "0");
    }

    private void permute(List<String> list, int index, List<String> permutations) {
        if (index == list.size() - 1) {
            permutations.add(String.join("", list));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            swap(list, index, i);
            permute(list, index + 1, permutations);
            swap(list, index, i); // backtrack
        }
    }

    private void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
