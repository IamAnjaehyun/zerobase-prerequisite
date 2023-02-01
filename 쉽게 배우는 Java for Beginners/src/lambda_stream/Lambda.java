package lambda_stream;

interface LambdaTest{
    int addOne(int i);
}

public class Lambda {
    public static void main(String[] args) {
        LambdaTest test = i -> ++i;
        System.out.println(test.addOne(1));
    }
}
