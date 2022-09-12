import java.util.Scanner;

class SubStringNotFoundException extends Exception{
    public String toString(){
        return "Exception: SubStringNotFound ";
    }
}
public class question3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter a text");
        String str=scan.nextLine();
        scan.close();

        boolean check1=str.toLowerCase().contains("sdmcet".toLowerCase());

        if(check1 ){
            System.out.println("successful");
        }
        else{
            try{
                throw new SubStringNotFoundException();
            }catch(SubStringNotFoundException ee){
                System.out.println(ee);

            }
        }
    } 
}
