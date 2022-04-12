package Translators;

import java.util.HashMap;

/**
 * This class takes care of the translation of the arabic numbers for the GUIs.ArabicTranslatorGUI
 */
public class arabicTranslator {
    public static String roman;
    HashMap<Character, Integer> lettersMap = new HashMap<Character, Integer>();

    public arabicTranslator(){
        lettersMap.put('I', 1);
        lettersMap.put('V', 5);
        lettersMap.put('X', 10);
        lettersMap.put('L', 50);
        lettersMap.put('C', 100);
        lettersMap.put('D', 500);
        lettersMap.put('M', 1000);
    }


    private int convertInt (char c){
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1000;
        }
    }

    public int Roman (){
        int number = 0;
        int i = 0;
        if (this.roman.isEmpty() == true){
            return 0;
        }
        while(true){
            //If the numbers do not follow the right pattern
            if (i == this.roman.length()-1){
                number += convertInt(this.roman.charAt(i));
                break;
            }
            if (convertInt(this.roman.charAt(i)) < convertInt(this.roman.charAt(i + 1))){
                number -= convertInt(this.roman.charAt(i));
            } else {
                number += convertInt(this.roman.charAt(i));
            }
            i ++;
        }
        return number;
    }
    //Function to check the input, if it is a correct roman number
    public boolean checkRoman(){
        boolean legit = true;
        char[] legitChars = {'I', 'V', 'X', 'L','C', 'D','M'};
        for (int i = 0; i < this.roman.length(); i++){
            if (lettersMap.containsKey(this.roman.charAt(i))){
                continue;
            }
            else {
                legit = false;
                return legit;
            }
        }
        return legit;
    }

    public static void main(String[] args) {

    }
}
