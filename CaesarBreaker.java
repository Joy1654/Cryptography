
/**
 * Write a description of CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarBreaker {
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
        //for(int k=97;k<122;k++)
        //{
        //   System.out.println((char)k +  " was found " +  Frequency[k-97]);
        // }

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


    public StorageResource decrypt() {
        StorageResource sr = new StorageResource();
        CaesarCipher cc = new CaesarCipher();
        String Encrypted = cc.encrypt("Break Me If You Can", 12);
        for (int k = 1; k < 26; k++) {
            String Hacked = cc.encrypt(Encrypted, k);
            sr.add(Hacked);
            //System.out.println(Hacked);
        }

        return sr;
    }

    public void testDecrypt() {
        StorageResource Khazana = decrypt();
        for (String Decode : Khazana.data()) {
            System.out.println(Decode);
        }
    }

    public String halfOfString(String Message, int Start) {
        StringBuilder Original = new StringBuilder(Message);
        StringBuilder Half = new StringBuilder();
        for (int k = Start; k < Original.length(); k += 2) {
            Half.append(Original.charAt(k));
        }
        return Half.toString();
    }

    public void getKey(String Message) {
        int[] Nazi = countLetters(Message);
        int Highest_Index = maxIndex(Nazi);
    }

    public void decryptTwoKeys() {
        CaesarCipher cc = new CaesarCipher();

        String Encrypted_Message = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";

        // int length=Encrypted_Message.length();
        String Encrypted_Message_1 = halfOfString(Encrypted_Message, 0);
        String Encrypted_Message_2 = halfOfString(Encrypted_Message, 1);
        // All this are I rrevelant 
        // Only useful if I know the most common words of the original Message

        int[] Test_1 = countLetters(Encrypted_Message_1);
        int Most_Common_Letter_Message_1 = maxIndex(Test_1);
        int[] Test_2 = countLetters(Encrypted_Message_2);
        int Most_Common_Letter_Message_2 = maxIndex(Test_2);
        for (int k = 0; k < 26; k++) {
            int key_1 = (26 - Math.abs(Most_Common_Letter_Message_1 - k));
            // int key_1=(26-i);
            //System.out.print("k value hahaha= "+k);

            for (int j = 0; j < 26; j++) {
                // cc.encryptTwoKeys(Encrypted_Message,k,j);
                //System.out.print("k value= "+k+" and j value= "+j+" ");
                int key_2 = (26 - Math.abs(Most_Common_Letter_Message_2 - j));
                //int key_2=(26-j);
                // System.out.print("Key 1 "+key_1+" Key 2 "+key_2);
                System.out.println("The Keys are " + (26 - key_1) + " and " + (26 - key_2) + "for below code");
                StringBuilder Broken_Piece_1 = new StringBuilder(cc.encrypt(Encrypted_Message_1, key_1));
                StringBuilder Broken_Piece_2 = new StringBuilder(cc.encrypt(Encrypted_Message_2, key_2));

                int l = 0;
                for (int t = 0; t < Broken_Piece_1.length(); t++) {
                    System.out.print(Broken_Piece_1.charAt(t));

                    while (l < Broken_Piece_2.length()) {
                        System.out.print(Broken_Piece_2.charAt(l));
                        l++;
                        break;
                    }
                }

                System.out.println(" ");
            }
        }
    }
}
                                 
    


