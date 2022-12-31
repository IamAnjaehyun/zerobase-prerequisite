package Java_19_arrays;
// 1차원 배열의 활용
public class Arrays_1 {
    public static void main(String[] args) {
        int[] scores = new int[]{75,77,90};
        int sum = 0;
//        for(int i=0;i<scores.length;i++){
//            sum += scores[i];
//        }
        // forEach
        // 요소(Element)를 변경하는 경우에는 적합하지 않음
        for(int i : scores){
            sum += i;
        }

        System.out.println("Score_Sum = " + sum);
        System.out.println("Score_Avg = " + sum / scores.length);


    }
}
