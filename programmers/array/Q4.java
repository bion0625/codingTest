package programmers.array;

public class Q4 {
    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{
//                {1,4},
//                {3,2},
//                {4,1}
//        };
//        int[][] arr2 = new int[][]{
//                {3,3},
//                {3,3}
//        };
        int[][] arr1 = new int[][]{
                {2,3,2},
                {4,2,4},
                {3,1,4}
        };
        int[][] arr2 = new int[][]{
                {5,4,3},
                {2,4,1},
                {3,1,1}
        };
        Q4 q4 = new Q4();
        int [][] arr = q4.solution(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + (j == arr[i].length-1 ? "" : ","));
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=0;
//                arr[i][j] = (arr1[i][0] * arr2[0][j])
//                        + (arr1[i][1] * arr2[1][j]);
                for (int k = 0; k < arr[i].length; k++) {
                    arr[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        return arr;
    }
}
