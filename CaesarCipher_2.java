
/**
 * Write a description of CaesarCipher_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class CaesarCipher_2 {

    private String alphabet;
    private String shiftedAlphabet;
    private int decrypt_Key;

    public CaesarCipher_2(int Key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(Key) + alphabet.substring(0, Key);
        decrypt_Key = 26 - Key;
    }

    public String encrypt(String Original_Text) {
        StringBuilder Builder = new StringBuilder(Original_Text);
        StringBuilder Encrypted_Alphabet = new StringBuilder(shiftedAlphabet);
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
                int Index = alphabet.indexOf(Now);

                char temp = Encrypted_Alphabet.charAt(Index);
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

    public String decrypt(String input) {
        //For Multiple Time Usage
        CaesarCipher_2 cc_2 = new CaesarCipher_2(decrypt_Key);
        String Output = cc_2.encrypt(input);
        //For One time usage
        // shiftedAlphabet=alphabet.substring(decrypt_Key)+ alphabet.substring(0,decrypt_Key);
        //String Output=encrypt(input); 
        return Output;
    }


}
