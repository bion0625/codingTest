package programmers.exhaustivesearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q21 {
    public static void main(String[] args) {
        // 17   ->  3
        // 011  ->  2
        String numbers = "17";
        Q21 q = new Q21();
        int result = q.solution(numbers);
        System.out.println("result = " + result);

        Q21Solution solution = new Q21Solution();
        int result2 = solution.solution(numbers);
        System.out.println("result2 = " + result2);

        Q21Solution2 solution2 = new Q21Solution2();
        int result3 = solution2.solution(numbers);
        System.out.println("result3 = " + result3);

        Q21Solution3 solution3 = new Q21Solution3();
        int result4 = solution3.solution(numbers);
        System.out.println("result4 = " + result4);
    }

    public int solution(String numbers) {
        int result = 0;
        Set<Integer> numberList = getNumberList(numbers);
        for (Integer num : numberList) {
            if(isPrime(num)) result++;
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

    public Set<Integer> getNumberList(String numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            numberList.add(Integer.parseInt(String.valueOf(c)));
        }
        List<Integer> resultList = getNumberList(0, numberList);
        resultList.remove(0);
        return new HashSet<>(resultList);
    }

    public List<Integer> getNumberList(Integer number, List<Integer> numberList) {
        List<Integer> result = new ArrayList<>();
        result.add(number);
        for (int i = 0; i < numberList.size(); i++) {
            List<Integer> nextList = new ArrayList<>(numberList);
            nextList.remove(i);
            int nextNumber = number * 10 + numberList.get(i);
            result.addAll(getNumberList(nextNumber, nextList));
        }
        return result;
    }
}
