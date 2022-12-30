package Java_18_1.src;

public class Practice5 {
    public static int solution(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;

        while(left < right){ //오른쪽벽이 왼쪽벽 침범하면 중단
            int x = right - left;
            int y = height[left] < height[right] ? height[left] : height[right]; //높이 더 낮은쪽으로 height 넘치면안됨
//            int curArea = x*y; //계산한 면적
//            maxArea = maxArea > curArea ? maxArea : curArea;

            int curArea = x * Math.min(height[left], height[right]); //계산한 면적
            maxArea = Math.max(maxArea,curArea); //더 큰거나오면 갱신

            if(height[left] < height[right]){ //둘 중에 더 큰벽을 남기고 작은벽을 한칸씩 이동
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
