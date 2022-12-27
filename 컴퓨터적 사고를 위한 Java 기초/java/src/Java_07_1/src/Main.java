package Java_07_1.src;// Java 프로그래밍 - 클래스와 객체_1

// Car 클래스 - 객체변수, 메소드
class Car{
    String name;
    String type;

    public void printCarInfo(){
        System.out.println("=== Car Info ===");
        System.out.println("name = " + name);
        System.out.println("type = " + type);
    }

    public void move(){
        System.out.println("이동 !");
    }

    public void brake(){
        System.out.println("정지 !");
    }

}

// Car2 클래스 - 생성자, this
class Car2{
    String name;
    String type;

    Car2(String name, String type){
        this.name = name;
        this.type = type;
        System.out.println("생성자 출력 !");
    }

    public void printCarInfo(){
        System.out.println("=== Car Info ===");
        System.out.println("name = " + name);
        System.out.println("type = " + type);
    }
    public void load(){
        System.out.println("짐을 주세요 !");
    }
    public void horn(){
        System.out.println("빵빵 !");
    }
}


public class Main {

    public static void main(String[] args) {
//      Car 클래스 사용
        Car c1 = new Car();
        c1.name = "a";
        c1.type = "suv";
        c1.printCarInfo();
        c1.move();
        c1.brake();


//      Car2 클래스 사용
        Car2 c2 = new Car2("b","sedan");
        c2.printCarInfo();
        c2.load();
        c2.horn();
    }
}
