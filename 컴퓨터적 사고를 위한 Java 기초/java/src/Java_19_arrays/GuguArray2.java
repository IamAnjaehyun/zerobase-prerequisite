package Java_19_arrays;

import java.util.Arrays;

// 1차원 배열의 활용
public class GuguArray2 {
    public static void main(String[] args) {
        int[] guguClass = {1,3,5,7,9};
        for(int i : guguClass){
            for(int j=1;j<10;j++){
                System.out.printf("%d * %d = %d ",i,j,i*j);
            }
            System.out.println();
        }
    }
}
