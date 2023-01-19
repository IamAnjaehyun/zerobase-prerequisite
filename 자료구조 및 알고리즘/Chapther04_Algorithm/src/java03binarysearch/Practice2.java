package java03binarysearch;
//Practice2
//원형 정렬 상태 배열에서의 이진 탐색
//nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
//이진 탐색으로 데이터를 찾는 프로그램을 작성하세요.
//O(log n) 유지
//배열을 재 정렬하지 않고 풀기

//입출력 예시
//arr: 4,5,6,7,8,0,1,2 -> 012345678 연결되어있는거임 (원형 정렬)

//target : 0
//출력 : 5

//target : 3
//출력 : -1
public class Practice2 {
    public static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            // 4,5,6,7,0,1,2 (중앙값보다 좌측값이 작은 상태)
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) { //4보다 크고 7보다 작을 때
                    right = mid - 1;
                } else { //7보다 크고 2보다 작을 때
                    left = mid + 1;
                }
            } else {
                // 11, 5, 6, 7, 8, 9,10 -> 중앙 데이터보다 좌측 데이터가 클 때
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //TestCode
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));
        System.out.println(solution(nums, 3));
    }
}
