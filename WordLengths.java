
/**
 * Write a description of WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

import java.io.*;


public class WordLengths {
    public int[] countWordLengths(FileResource fr, int[] Counts) {


        for (String Message : fr.words()) {
            StringBuilder Text = new StringBuilder(Message);

            if (Text.length() == 1 && !Character.isLetter(Text.charAt(0))) {
                Counts[0] += 1;
                //System.out.println("fOUND " +Text.toString());
            } else if (Text.length() == 1 && Character.isLetter(Text.charAt(0))) {
                Counts[1] += 1;

            } else if (!Character.isLetter(Text.charAt(0)) && !Character.isLetter(Text.charAt(Text.length() - 1))) {
                Counts[Text.length() - 2] += 1;

            } else if (Character.isLetter(Text.charAt(0)) && Character.isLetter(Text.charAt(Text.length() - 1))) {
                Counts[Text.length()] += 1;

            } else {
                Counts[Text.length() - 1] += 1;
            }
        }

        return Counts;
    }

    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] Value = new int[30];
        Value = countWordLengths(fr, Value);
        for (int k = 0; k < Value.length; k++) {
            System.out.println("No. of Words found having Length " + k + " are " + Value[k]);
        }
        System.out.println("Maximum times Word Length Recorded " + indexOfMax(Value));
        System.out.println("The Answer " + indexOfMax(Value));
    }

    public int indexOfMax(int[] Array) {
        boolean OTP = true;
        int Max_Value = 0, J = 0;
        for (int k = 0; k < Array.length; k++) {
            if (OTP) {
                Max_Value = Array[k];
                J = k;
                OTP = false;
            } else if (Max_Value < Array[k]) {
                Max_Value = Array[k];
                J = k;
            }
        }
        return J;
    }


}


