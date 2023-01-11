package java08practice;

public class Practice2 {
    //외각 부분에만 체크해두고 외각 체크되어있으면 0으로 바꿈
    public static void solution(int[][] matrix) {
        boolean frZero = false;
        boolean fcZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        frZero = true;
                    }
                    if (j == 0) {
                        fcZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) { //외각이 0이면 0으로 바꿔줌 (반복문 1부터 시작)
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(frZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] =0;
            }
        }
        if(fcZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //TestCode
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);


        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);

    }
}
