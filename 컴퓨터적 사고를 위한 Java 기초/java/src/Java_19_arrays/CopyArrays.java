package Java_19_arrays;

import java.util.Arrays;

// 1차원 배열의 활용
public class CopyArrays {
    public static void main(String[] args) {

        int[] origin = new int[]{1,2,3,4,5};
        int newArrayLength = 10;

        System.out.println("\nfirstCopyArray");
        int[] firstCopyArray = new int[newArrayLength];
        System.arraycopy(origin, 0, firstCopyArray, 0, origin.length);
        for(int i=0;i<origin.length;i++){
            System.out.print(firstCopyArray[i] +" ");
        }

        System.out.println("\nsecondCopyArray");
        int[] secondCopyArray = Arrays.copyOf(origin, newArrayLength);
        for(int i=0;i<origin.length;i++){
            System.out.print(secondCopyArray[i] +" ");
        }

        System.out.println("\nthirdCopyArray");
        int[] thirdCopyArray = (int[]) origin.clone();
        for(int i=0;i<origin.length;i++){
            System.out.print(thirdCopyArray[i] +" ");
        }

        System.out.println("\nfourthCopyArray");
        int[] fourthCopyArray = new int[newArrayLength];
        for(int i=0;i<origin.length;i++){
            fourthCopyArray[i] = i;
            System.out.print(fourthCopyArray[i] +" ");
        }
    }
}
