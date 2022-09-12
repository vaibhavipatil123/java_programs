import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class VowelNotAllowedException extends Exception{
    public String toString(){
        return "Exception: Vowels are not allowed";
    }
}

public class question4 {
    public static void main(String[] args) throws IOException, VowelNotAllowedException {
        
        //File file=new File("C://Users\//HP//OneDrive//Desktop//AOOP//read.txt");
        File file1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\AOOP\\alphabet.txt");
        FileReader fr=new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\AOOP\\alphabet.txt");
        //File file2=new File("C:\\Users\\HP\\OneDrive\\Desktop\\AOOP\\write.txt");
        FileWriter fw=new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\AOOP\\consonants.txt");

        try{
            file1.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        Scanner sc=new Scanner(fr);

        String str=sc.nextLine();
        sc.close();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            try{
                if((ch=='a') ||(ch=='e')|| (ch=='i') || (ch=='o') || (ch=='u')){
                    throw new VowelNotAllowedException();
                }
                else{
                    
                    fw.write(ch);
                    System.out.println("coppied");
                }
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
    } 
}
