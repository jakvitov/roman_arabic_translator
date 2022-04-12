package Translators;

/**
 * This class takes care of the translation of the arabic numbers for the GUIs.RomanTranslatorGUI
 */
public class romanTranslator {
    static int arab;
    public romanTranslator(int inputArab){
        arab = inputArab;
    }
    public String intToRoman(){
        String roman = "";
        while (this.arab > 0){
            //Each time we try if we can devide the remainder by the highest value
            //Than we lower it and continue
            if (this.arab / 1000 > 0){
                this.arab -= 1000;
                roman += 'M';
            }
            else if (this.arab / 500 > 0){
                if (this.arab % 500 >= 400){
                    this.arab -= 900;
                    roman += 'C';
                    roman += 'M';
                    continue;
                }
                this.arab -= 500;
                roman += 'D';
            }
            else if (this.arab / 100 > 0){
                if (this.arab / 100 == 4){
                    this.arab -= 400;
                    roman += 'C';
                    roman += 'D';
                    continue;
                }
                this.arab -= 100;
                roman += 'C';
            }
            else if (this.arab / 50 > 0){
                if (this.arab % 50 >= 40){
                    this.arab -= 90;
                    roman += 'X';
                    roman += 'C';
                    continue;
                }
                this.arab -= 50;
                roman += 'L';
            }
            else if (this.arab / 10 > 0){
                if (this.arab / 10 == 4){
                    this.arab -= 40;
                    roman += 'X';
                    roman += 'L';
                    continue;
                }
                this.arab -= 10;
                roman += 'X';
            }
            else if (this.arab / 5 > 0){
                if (this.arab % 10 == 9){
                    this.arab -= 9;
                    roman += 'I';
                    roman += 'X';
                    continue;
                }
                this.arab -= 5;
                roman += 'V';
            }
            else {
                //Speciální case 4ky
                if (this.arab / 4 > 0){
                    this.arab -= 4;
                    roman += 'I';
                    roman += 'V';
                    continue;
                }
                this.arab -= 1;
                roman += 'I';
            }
        }
        return roman;
    }

    public static void main(String[] args) {
    }
}
