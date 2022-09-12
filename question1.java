import java.util.Scanner;

class question1{
    public static void main(String[] args) {
        try{
            int a=100,b=0,c;
            c=a/b;
            System.out.println(c);
    
        }catch(Exception e){
            System.out.println("Exception: DIVIDE BY ZERO ERROR");
        }
        try{
            int arr[]=new int[10];
            System.out.println(arr[11]=55);
        }catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("Exception: ARRAY INDEX IS OUT OF BOUNDS");
        }
        try{
            Scanner sc=null;
            sc.nextLine();
            
        }catch(NullPointerException aee){
            System.out.println("Exception: NULL POINTER EXCEPTION");
        }
    }
}
