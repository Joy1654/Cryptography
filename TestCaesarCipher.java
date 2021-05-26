
/**
 * Write a description of TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

import java.io.*;

public class TestCaesarCipher {

    public int[] countLetters(String Code) {
        StringBuilder sb = new StringBuilder(Code.toLowerCase());
        String Alphabets = ("abcdefghijklmnopqrstuvwxyz");
        int[] Frequency = new int[26];
        for (int k = 0; k < sb.length(); k++) {
            char Present = sb.charAt(k);
            if (!Character.isLetter(Present)) {
                continue;
            } else {
                int Index = Alphabets.indexOf(Present);
                Frequency[Index] += 1;

            }


        }


        return Frequency;

    }

    public int maxIndex(int[] Array) {
        boolean Test = true;
        int Max = 0, value = 0;
        for (int k = 0; k < Array.length; k++) {
            if (Test) {
                Max = Array[k];
                Test = false;
                value = k;
            } else if (Max < Array[k]) {
                Max = Array[k];
                value = k;
            }
        }
        return value;
    }

    public void simpleTests() {
        //FileResource fr=new FileResource();
        CaesarCipher_2 cc_2 = new CaesarCipher_2(11);
        String Encrypted_Message = cc_2.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("Encrypted Message " + Encrypted_Message);
        //String Decrypted_Message=cc_2.decrypt(Encrypted_Message);
        //System.out.println("Decrypted Message "+Decrypted_Message);
    }

    public void breakCaesarCipher(String Encrypted_Message) {
        for (int k = 0; k < 13; k++) {
            CaesarCipher_2 cc_3 = new CaesarCipher_2(k);
            System.out.println("Key for Below Code " + k);
            String Search = cc_3.encrypt(Encrypted_Message);
            System.out.println(Search);
            System.out.println("Key for Below Code " + (26 - k));
            Search = cc_3.decrypt(Encrypted_Message);
            System.out.println(Search);
        }

    }


}
          
    
    
    
    
    
    
    
    
    
    
    


