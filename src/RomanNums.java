import java.util.Arrays;

class RomanNums {

    boolean isRoman(String str) {
        return str.matches("^(I{1,3}|I?[VX]|VI{1,3})$");
    }

    int convertToNums(String roman) {
        return String.join("", roman)
                .replace("IX", "VIV")
                .replace("X", "VV")
                .replace("IV", "IIII")
                .replace("V", "IIIII").length();
    }

    String convertToRoman(int num) {
        return String.join("", numToChars(num))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("LL", "C")
                .replace("LXL", "XC");
    }

    private String numToChars(int num) {
        char[] charArr = new char[num];
        Arrays.fill(charArr, 'I');
        return String.valueOf(charArr);
    }
}
