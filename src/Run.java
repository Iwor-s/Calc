import java.util.Scanner;


public class Run {

    public static void main(String[] args) {

        String text;
        boolean isRoman = false;
        int[] numsArr = new int[2];
        char operator;
        String result;


        text = getInput();
        if (!isValid(text)) {
            System.out.println("Недопустимый формат ввода. Программа завершена");
            return;
        }

        String[] inputArr = text.split("[\\+\\-\\*/]");

        RomanNums rN = new RomanNums();
        for (int i = 0; i < inputArr.length; i++) {
            if (isRoman = rN.isRoman(inputArr[i].trim())) {
                numsArr[i] = rN.convertToNums(inputArr[i].trim());
            } else {
                numsArr[i] = Integer.parseInt(inputArr[i].trim());
            }
        }

        Calculator calc = new Calculator(numsArr[0], numsArr[1]);
        operator = text.charAt(inputArr[0].length());
        switch (operator) {
            case '+' -> calc.add();
            case '-' -> calc.subtract();
            case '*' -> calc.multiply();
            case '/' -> calc.divide();
        }

        if (isRoman) {
            result = rN.convertToRoman(Math.abs(calc.result));
            if (calc.result < 0)
                result = "-" + result;
        } else
            result = calc.result + "";

        System.out.printf("Ответ: %s", result);
    }

    static String getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Введите данные в формате: a + b, a - b, a * b или a / b\n(только римские либо только арабские натуральные числа от 1 до 10)");
        String input = in.nextLine().toUpperCase();  // на случай, если введена строка без пробелов вокруг оператора
        in.close();
        return input;
    }

    static boolean isValid(String input) {
        String regexRoman = "^(I{1,3}|I?[VX]|VI{1,3}) *[\\+\\-\\*/] *(I{1,3}|I?[VX]|VI{1,3})$";
        String regexArabic = "^([1-9]|10) *[\\+\\-\\*/] *([1-9]|10)$";
        return input.matches(regexRoman) || input.matches(regexArabic);
    }
}

