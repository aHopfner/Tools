import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileGen{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the direct path to your blank .txt file");
        System.out.println("Example: C:/files/file.txt");
        String file = input.nextLine();
        System.out.println();
        System.out.print("How many lines do you want the file to be?: ");
        int lines = input.nextInt();
        System.out.println();
        System.out.print("What length do you want the lines to be?: ");
        int length = input.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("---------Press any key to continue---------");
        System.out.println("-------------------------------------------");
        input.next();
        String generated = "";
        String[] chars = {"-", "_", ")", "(",  "*", "&", "^", "^", "%", "$","#", "@", "!", "=", "+"};  
        try{
            FileWriter writer = new FileWriter(file);
            for(int i = 0; i < lines; i++){
                generated = "";
                for(int j = 0; j < length; j++){
                        generated += chars[(int)(Math.random() * chars.length)];
                }
                writer.write(generated + "\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}