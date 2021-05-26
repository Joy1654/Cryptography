
/**
 * Write a description of CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String string_1;
    private String string_2;
    private String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CaesarCipherTwo(int Key1, int Key2) {
        string_1 = Alphabets.substring(Key1) + Alphabets.substring(0, Key1);
        string_2 = Alphabets.substring(Key2) + Alphabets.substring(0, Key2);
    }


    public String encrypt(String Message) {
        StringBuilder Builder = new StringBuilder(Message);
        StringBuilder Encrpted_Alphabets_1 = new StringBuilder(string_1);
        StringBuilder Encrpted_Alphabets_2 = new StringBuilder(string_2);
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

    public String halfOfString(String Message, int Start) {
        StringBuilder Original = new StringBuilder(Message);
        StringBuilder Half = new StringBuilder();
        for (int k = Start; k < Original.length(); k += 2) {
            Half.append(Original.charAt(k));
        }

        return Half.toString();
    }

    public void decrypt(String input) {
        // String Encrypted_Message=input;
        // String Encrypted_Message_1=halfOfString(Encrypted_Message,0);
        //String Encrypted_Message_2=halfOfString(Encrypted_Message,1);
        for (int i = 0; i < 26; i++) {
            int key_1 = (26 - i);
            System.out.println("First " + key_1);
            for (int j = 26; j > 0; j--) {
                int key_2 = (26 - j);
                System.out.println("Second " + key_2);
                CaesarCipherTwo cc_2 = new CaesarCipherTwo(key_1, key_2);
                System.out.println("Keys for Below Code " + key_1 + " " + key_2);
                cc_2.encrypt(input);
                System.out.println(" ");
                continue;
            }
            continue;
        }
    }
}
    
    
    


