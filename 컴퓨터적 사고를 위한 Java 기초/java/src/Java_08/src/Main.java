package Java_08.src;// Java 프로그래밍 - 상속

class Person {
    String name;
    int age;
    public int a1;
    private int a2;

    Person() {
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Person.printInfo");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}

// Student 클래스 - Person 상속, 접근제어자 확인
class Student extends Person {
    Student(){
        a1=1;
//        a2=1; //private라서 안됨
    }
}

// Student 클래스 - Person 상속, super 사용, 오버라이딩
class Student2 extends Person{
    String name;
    int stdID;

    Student2(String name, int age, int stdID){
        this.name = name; //std2의 이름
//        super.name = name; //부모의 이름
// 부모생성자 호출 / 윗부분에 있는게 호출됨 / 이부분을 위로 넘겨서 부모의 생성자쪽에서 생성됨 / 부모꺼라 자식에서 이름 넣어도 null값 호출
//        super(name, age);
        this.age = age; //age 없으니까 상속받은 age
        this.stdID = stdID; //std2의 id
    }

    @Override
    public void printInfo() {
        System.out.println("Student2.printInfo");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("stdID: " + stdID);
    }
}

public class Main {

    public static void main(String[] args) {

//      Test code
//      1. 상속
        System.out.println("=============");
        Student s1 = new Student();
        s1.name = "a";
        s1.age = 25;
        s1.printInfo();


//      2. super, super(), 오버라이딩
        System.out.println("=============");
        Student2 s2 = new Student2("b",32, 1);
        s2.printInfo();

    }
}
