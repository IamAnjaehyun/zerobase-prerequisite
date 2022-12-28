package Java_12.src;// Java 프로그래밍 - 내부 클래스
// 내부 클래스에서 외부 클래스 멤버에 접근 가능
// 외부에서는 내부 클래스에 접근 불가

// 내부 클래스 종류
// 인스턴스 클래스(instance class) - 이름이 없음, 선언과 동시에 객체 생성, 일회용
// 정적 클래스(static class)
// 지역 클래스(local class)
// 익명 클래스(anonymous class)

// 내부 클래스 구조
class Outer{
    public void print(){
        System.out.println("Outer.print");
    }
    class Inner{
        public void innerPrint(){
            System.out.println("from innerclass");
            Outer.this.print(); //내부에서 외부로 접근 가능 but 반대 불가
        }
    }

    static class InnerStaticClass{
        void InnerPrint(){
//            Outer.this.print(); //안됨 밖에서 이너클래스 호출 불가
            System.out.println("InnerStaticClass.InnerPrint");
        }
    }
}

abstract class Person{
    public abstract void printInfo();
}

class Student extends Person{
    @Override
    public void printInfo() {
        System.out.println("Student.printInfo");
    }
}

public class Main {

    public static void main(String[] args) {

//      외부 클래스
        Outer o1  = new Outer();
        o1.print();
//      내부 클래스 - 인스턴스
        Outer.Inner i1 = new Outer().new Inner();
        i1.innerPrint();
//      내부 클래스 - 정적
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();
        is1.InnerPrint();
//      익명 클래스
        Person p1 = new Person() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };

        p1.printInfo();
    }
}
