import java.util.Scanner;
public class CaesarBrute{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 1 to Encrypt, or 2 to Decrypt");
        int choice = input.nextInt();
        input.nextLine();
        if(choice == 1){
            System.out.println("What message would you like to encrypt?");
            String eMessage = input.nextLine();
            System.out.println("What would you like the shift to be?");
            int shift = input.nextInt();
            encrypt(eMessage, shift);
        }else if(choice == 2){
            System.out.println("What message would you like to Decrypt?");
            String dMessage = input.nextLine();
            decrypt(dMessage);
        }else{
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    public static void decrypt(String message){
        String encrypted = message.toLowerCase();
        int shift = 1;
        String plaintext = "";
        do{
            for (int i = 0; i < encrypted.length(); i++){
                char ch = encrypted.charAt(i);
                if(Character.isLetter(ch)){
                    ch = (char) (ch - shift);

                    if(ch > 'z'){
                        ch = (char) (ch - 26);
                    }else if(ch < 'a'){
                        ch = (char) (ch + 26);
                    }
                }
                plaintext += ch;
            }
            System.out.println("With a shift of " + shift + ", the message is: " + plaintext);
            shift++;
            plaintext = "";
        }while (shift < 26);
    }
    public static void encrypt(String message, int shift){
        String encrypt = message.toLowerCase();
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < encrypt.length(); i++){
            char ch = encrypt.charAt(i);
            if(Character.isLetter(ch)){
                ch = (char) (ch + shift);
                if(ch > 'z'){
                    ch = (char) (ch - 26);
                }else if(ch < 'a'){
                    ch = (char) (ch + 26);
                }
            }

            encrypted.append(ch);
        }
        System.out.println("Encrypted message: " + encrypted.toString());
    }
}