package Java_07_1.src;//  Practice
//  다음 클래스 직접 만든 후 객체 생성
//  클래스명: Animal
//  특성: 이름, 무게, 분류
//  기능: 먹기, 잠자기, 걷기, 뛰기

class Human {
    private String sex;
    private int weight;
    private int height;
    private String name;
    private int age;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public long BMI() {
        return Math.round(weight/Math.pow(height,2)*10000);
    }

    public Human(String sex, int height, int weight, String name, int age) {
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "sex='" + sex + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        Human Anjaehyun = new Human("boy", 180,65,"안재현",20);

        System.out.println(Anjaehyun.toString());

        System.out.println( Anjaehyun.BMI());
    }
}
