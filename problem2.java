import java.util.Scanner;

class NegativeNumberNotAllowedException extends Exception{
    int num;
    NegativeNumberNotAllowedException(int num){
        this.num=num;
    }
    public String toString(){
        return "Exception: enter a positive number";
    }
}
class NumberNotPrimeException extends Exception{
    int num;
    NumberNotPrimeException(int a){
        this.num=a;
    }
    public String toString(){
        return "EXCEPTION: not prime";
    }
}
class PrimeOrNot{
    void checkPrime(int a){
        int count=0;
        for(int i=1;i<=a;i++){
            if(a%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println("prime");
        }
        else{
            try{
                throw new NumberNotPrimeException(a);
            }catch(NumberNotPrimeException ee){
                System.out.println(ee);
            }
        }        
    }    
}
public class question2 {
    public static void main(String[] args) {
        PrimeOrNot prn=new PrimeOrNot();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int number=sc.nextInt();
        sc.close();
        try{
            if(number<0){
                throw new NegativeNumberNotAllowedException(number);
            }
            prn.checkPrime(number);
        }catch(NegativeNumberNotAllowedException e){
            System.out.println(e);
        }
           
    }
}
