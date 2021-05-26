
/**
 * Write a description of Part_1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

import java.io.*;


public class Part_1 {
    public boolean isVowel(char ch) {
        StringBuilder vowel = new StringBuilder("aeiou");
        boolean value = false;
        if (Character.isUpperCase(ch)) {
            ch = Character.toLowerCase(ch);
        }
        for (int i = 0; i < vowel.length(); i++) {
            if (vowel.charAt(i) != ch) {
                continue;
            } else {
                value = true;
                break;
            }
        }
        return value;
    }

    public StringBuilder replaceVowels(String phrase, char ch) {
        StringBuilder Message = new StringBuilder(phrase);
        for (int i = 0; i < Message.length(); i++) {
            if (!isVowel(Message.charAt(i))) {
                continue;

            } else {
                Message.setCharAt(i, ch);
            }
        }
        return Message;
    }

    public StringBuilder emphasize(String Phrase, char ch) {
        StringBuilder Message = new StringBuilder(Phrase);
        for (int i = 0; i < Message.length(); i++) {
            if (Message.charAt(i) != ch) {
                continue;
            } else if (i % 2 == 0) {
                Message.setCharAt(i, '*');

            } else
                Message.setCharAt(i, '+');
        }
        return Message;


    }


}
