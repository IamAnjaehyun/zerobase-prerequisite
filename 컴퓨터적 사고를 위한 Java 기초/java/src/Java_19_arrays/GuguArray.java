package Java_19_arrays;

import java.util.Arrays;

// 1차원 배열의 활용
public class GuguArray {
    public static void main(String[] args) {

        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.printf("%d * %d = %d ",i,j,i*j);
            }
            System.out.println();
        }
    }
}
