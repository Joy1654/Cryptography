
/**
 * Write a description of CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

import java.io.*;

public class CaesarCipher {
    public String encrypt(String Original_Text, int Key) {
        StringBuilder Builder = new StringBuilder(Original_Text);
        String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder Encrpted_Alphabets = new StringBuilder(Alphabets.substring(Key) + Alphabets.substring(0, Key));

        for (int i = 0; i < Builder.length(); i++) {
            boolean LowerCase = false;
            Character Now = Builder.charAt(i);
            if (!Character.isLetter(Now)) {
                continue;
            } else {
                if (Character.isLowerCase(Now)) {
                    LowerCase = true;
                    Now = Character.toUpperCase(Now);
                }
                int Index = Alphabets.indexOf(Now);
                char temp = Encrpted_Alphabets.charAt(Index);
                if (LowerCase) {
                    temp = Character.toLowerCase(temp);
                    Builder.setCharAt(i, temp);
                } else {
                    Builder.setCharAt(i, temp);
                }
            }
        }
        //System.out.println(Builder.toString());
        return Builder.toString();
    }

    public void testCaesar() {
        FileResource fr = new FileResource();
        String Message = fr.asString();
        System.out.println(encrypt(Message, 23));
    }

    public String encryptTwoKeys(String Message, int Key1, int Key2) {
        StringBuilder Builder = new StringBuilder(Message);
        String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder Encrpted_Alphabets_1 = new StringBuilder(Alphabets.substring(Key1) + Alphabets.substring(0, Key1));
        StringBuilder Encrpted_Alphabets_2 = new StringBuilder(Alphabets.substring(Key2) + Alphabets.substring(0, Key2));
        // StringBuilder temp=Encrpted_Alphabets_2;
        for (int i = 0; i < Builder.length(); i++) {
            StringBuilder temp = Encrpted_Alphabets_2;
            boolean LowerCase = false;
            Character Now = Builder.charAt(i);
            if (i % 2 == 0) {
                temp = Encrpted_Alphabets_1;

            }

            if (!Character.isLetter(Now)) {
                continue;
            } else {
                if (Character.isLowerCase(Now)) {
                    LowerCase = true;
                    Now = Character.toUpperCase(Now);
                }
                int Index = Alphabets.indexOf(Now);
                char Encrypted_Char = temp.charAt(Index);
                if (LowerCase) {
                    //temp=Character.toLowerCase(Encrypted_Char);
                    Builder.setCharAt(i, Character.toLowerCase(Encrypted_Char));

                } else {
                    Builder.setCharAt(i, Encrypted_Char);
                }
            }
        }
        System.out.println(Builder.toString());
        return Builder.toString();
    }

    public void Testing() {
        FileResource fr = new FileResource();
        encryptTwoKeys(fr.asString(), 9, 22);
    }


}