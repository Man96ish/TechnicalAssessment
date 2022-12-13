public class Loops {
    public static void main(String[] args) {

        System.out.println("---- For Loop Demo ----");
        System.out.println();
        for (int i=1;i <=10; i++){
            System.out.println(i);
        }
        System.out.println();
        System.out.println("---- End of For Loop Demo ----");
        System.out.println();
//----------------------------------------------------------------------//
        System.out.println("---- While Loop Demo ----");
        System.out.println();
        int j=1;
        while(j<=10){
            System.out.println(j);
            j++;
        }
        System.out.println();
        System.out.println("---- End of While Loop Demo ----");
        System.out.println();
//----------------------------------------------------------------------//
        System.out.println("---- Continue Statement ----");
        System.out.println();
        for(int k=1; k <=10; k++){
            if(k == 5){
                continue;
            }
            System.out.println(k);
        }
        System.out.println();
        System.out.println("---- End of Continue Statement ----");
        System.out.println();
//----------------------------------------------------------------------//
        System.out.println("---- If-Else Statement ----");
        System.out.println();
        int number= 13;
        if (number % 2==0){
            System.out.println("Number is Even");
        }else{
            System.out.println("Number is odd");
        }
        System.out.println();
        System.out.println("---- End of If-Else Statement ----");
        System.out.println();
//----------------------------------------------------------------------//
        System.out.println("---- Switch Statement ----");
        System.out.println();
        String levelString="Expert";
        int level=0;
        switch(levelString){
            case "Beginner":
                                level=1;
                                break;
            case "Intermediate":
                                level=2;
                                break;
            case "Expert":
                                level=3;
                                break;
            default:
                                level=0;
                                break;
        }
        System.out.println("Your Level is: "+level);
        System.out.println();
        System.out.println("---- End Switch Statement ----");
    }
}
