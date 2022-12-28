package Java_09.src;// Java 프로그래밍 - 다형성
// 다형성 - 한 객체가 여러 타입 가질 수 있는것
// 부모 클래스 타입의 참조 변수로 자식클래스 인스턴스 참조
// instanceof > 실제 참조하고있는 인스턴스의 타입 확인
class Person {
    public void print() {
        System.out.println("Person.print");
    }
}

class Student extends Person {
    public void print() {
        System.out.println("Student.print");
    }

    public void print2() {
        System.out.println("Student.print2");
    }
}

class CollegeStudent extends Person {
    public void print() {
        System.out.println("CollegeStudent.print");
    }
}


public class Main {

    public static void main(String[] args) {

//      1. 다형성
        System.out.println("== 다형성 ==");
        Person p1 = new Person();
        Student s1 = new Student();

        Person p2 = new Student();
//        Student s2 = new Person(); //자식이 부모 가르키는건 안됨

        p1.print();
        s1.print();
        s1.print2();
        p2.print();
//        p2.print2(); // 안된다 이건 person이 알고있는 그냥 print는 student의 print로 접근 가능한데 student의 print2는 접근이 불가능

        Person p3 = new CollegeStudent();
//        CollegeStudent c1 = new Student(); //같은 부모 상속하는 자식들 끼리 다형성 안됨
        p3.print();
//      2. 타입 변환
        System.out.println("== 타입 변환 ==");
        Person pp1 = null;
        Student ss1 = null;

        Person pp2 = new Person();
        Student ss2 = new Student();
        Person pp3 = new Student(); // up casting 자식클래스의 객체가 부모타입 객체로 형변환 되는것 / 실객체는 student
        pp1 = pp2; //same type ok
        pp1 = ss2; //polymorphism ok

        ss1 = ss2; //same type ok
//        ss1 = pp2; //거꾸로 x
        ss1 = (Student) pp3; //down casting

//        CollegeStudent cc1;
//        CollegeStudent cc2 = new CollegeStudent();
//        ss1 = (Student) cc2; 같은부모 클래스여도 자식 클래스끼리 형변환 불가
//        cc1 = (CollegeStudent) ss2; 불가


//      3. instanceof
        System.out.println("== instanceof ==");
        Person pe1 = new Person();
        Student st1 = new Student();
        Person pe2 = new Student();
        Person pe3 = new CollegeStudent();

        System.out.println(pe1 instanceof Person);
        System.out.println(pe1 instanceof Student);

        System.out.println(st1 instanceof Student);
        System.out.println(st1 instanceof Person);

        System.out.println(pe2 instanceof Person);
        System.out.println(pe2 instanceof Student);

        System.out.println(pe3 instanceof Person);
        System.out.println(pe3 instanceof CollegeStudent);

        if(pe1 instanceof Student){
            Student stu1 = (Student) pe1;
        }

        if(st1 instanceof Person){
            Person per1 = (Person)st1;
        }
    }
}
