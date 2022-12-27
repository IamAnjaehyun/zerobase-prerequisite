package java04permutation;
// practice1
// 1,2,3,4를 이용하여 세자리 자연수를 만드는 방법 (순서 O , 중복 x )의 각 결과를 출력하시오
// 방법1
public class Practice1  {
    void permutation(int[] arr, int depth, int n, int r){ //depth 는 각 자릿수

        if(depth == r){ //탈출 조건
            for(int i=0;i<r;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=depth; i<n ; i++){
            swap(arr, depth, i); //자릿수 바꿈
            permutation(arr, depth+1, n ,r);//호출
            swap(arr, depth, i); //과정끝나면 자리 그대로 다시 바꿈
        }

    }

    //자리바꾸는 swap 함수
    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }
    public static void main(String[] args) {
        // TestCode
        int[] arr = {1,2,3,4};

        Practice1 p = new Practice1();
        p.permutation(arr, 0,4,3);
    }
}
