package Java_18_3.src;

import java.util.ArrayList;

//빙글빙글 출력
public class Practice4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1; //정사각형 아닐 수 있으니

        while (rowStart <= rowEnd && colStart <= colEnd) {
            //오른쪽방향
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            //오른쪽끝에서 아래로
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            //왼쪽갈때
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--; //출력됐으면 한칸 올라감

            //위로올라갈때
            if(colStart <=colEnd){
                for(int i=rowEnd; i>= rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println((solution(matrix)));
    }
}
