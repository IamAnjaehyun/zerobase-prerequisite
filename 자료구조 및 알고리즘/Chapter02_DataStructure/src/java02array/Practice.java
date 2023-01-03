package java02array;
//Practice
//기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {
    int[] arr;

    //배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    //배열에 데이터 삽입
    public void insertData(int index, int data) {
        if (index < 0 || index > this.arr.length) { //배열의 사이즈보다 큰 데이터를 추가하면 에러 출력 후 리턴
            System.out.println("Index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }

    //배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1;
        for (int i = 0; i < this.arr.length; i++) { //data가 기존의 배열에 있는지 확인
            if (this.arr[i] == data) { //배열에 위치한 데이터가 삭제하려고 요청한 데이터와 일치하면 targetIndex 해당인덱스로 넣어줌
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1) {
            System.out.println(data +" 에 해당하는 값의 데이터가 존재하지 않습니다.");
        } else {
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i]; //지우려고 하는 index 전까지 데이터 넣기
            }

            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1]; //지우려고 하는 데이터 빼고 배열에 넣어줌
            }
        }
    }
}


public class Practice {

    public static void main(String[] args) {
        //TestCode  
        int size = 5;
        MyArray myArray = new MyArray(size);
        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i+1;
        }
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.insertData(2,20);
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.insertData(6,60);
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.insertData(-1,0);

        myArray.removeData(4);
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.removeData(4);
        System.out.println("Arrays.toString(myArray.arr) = " + Arrays.toString(myArray.arr));

        myArray.removeData(99);

    }
}
