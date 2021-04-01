package exercitii.unchecked;

public class ArithmeticExceptionDemo {
    //impartire la 0
    public static void main(String[] args) {
        int a = 30 , b = 0;


        divide(a, b);
    }

    private static void divide(int a, int b) throws IllegalArgumentException{
        if(b >0){
            int c = a / b;
            System.out.println(c);
        }
        else{
            throw new IllegalArgumentException("B is lower than 0");
        }
    }
}
