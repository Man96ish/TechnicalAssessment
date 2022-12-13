import java.util.Scanner;

public class Recursion {
    static int factorial(int n){
        if(n==1)
            return 1;
        else
            return (n*factorial(n-1));
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please Enter the number :-");
        int n= input.nextInt();
        System.out.println("Factorial of "+n+" : "+factorial(n));
    }
}
