package Java_06.src;// Java 프로그래밍 - 다차원 배열

public class Main {
    public static void main(String[] args) {
        
        // 1. 일차원 배열
        System.out.println("== 일차원 배열 ==");
        int[] myArray = {9,1,2,3};
        System.out.println("myArray[1] = " + myArray[1]);
        for(int i : myArray){
            System.out.print(i+" ");
        }
        System.out.println();
        // 2. 이차원 배열
        System.out.println("== 이차원 배열 ==");
        int[][] myArray2 = {{1,2,3},{4,5,6}};
        System.out.println("myArray2[1][2] = " + myArray2[1][2]);
        System.out.println("== 이차원 배열 반복문 추출 ==");
        for(int i=0;i<myArray2.length;i++){
            for(int j=0; j< myArray2[i].length; j++){
                System.out.printf("myArray2[%d][%d] = %d\n",i,j, myArray2[i][j]);
            }
        }
        System.out.println("== 이차원 배열 반복문 추출(for each) ==");
        for(int[] ints : myArray2){ //2차원 배열을 가져온거니까 자료형을 1차원 배열로 해서 반복문을 돌림 ?!
            for(int anInt : ints){ //1차원 배열을 anInt로 반복추출
                System.out.println("anInt = " + anInt);
            }
        }


        System.out.println("== Q1 ==");
//      Q1. 아래와 같이 3x3 행렬이 2차원 배열로 초기화 되어있다.
//          모든 원소를 1로 변경하고, 대각 원소는 10으로 변경하시오.
        int [][] testArray1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for(int i=0;i<testArray1.length;i++){
            for(int j=0; j< testArray1[i].length; j++){
                testArray1[i][j] = 1;
                if(i==j){testArray1[i][j] = 10;}
            }
        }

        for(int[] itemRow : testArray1){
            for(int itemCol : itemRow){
                System.out.print(itemCol + " ");
            }
            System.out.println();
        }
    }
}
