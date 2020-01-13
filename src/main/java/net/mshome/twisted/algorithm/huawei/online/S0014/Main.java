package net.mshome.twisted.algorithm.huawei.online.S0014;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 进制转换，将a-z --> 1-26
 * 输入数字转换为字符串，输入字符串转换为数字
 */
public class Main {

    private static final Pattern CHAR_REGEXP = Pattern.compile("[a-z]+");
    private static final Pattern NUMBER_REGEXP = Pattern.compile("[0-9]+");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (CHAR_REGEXP.matcher(input).matches()) {
                System.out.println(convertStringToNumber(input));
                continue;
            }

            if (NUMBER_REGEXP.matcher(input).matches()) {
                System.out.println(convertNumberToString(input));
                continue;
            }
            System.out.println("ERROR");

        }
    }


    private static int convertStringToNumber(String input) {
        char[] inputChars = input.toCharArray();
        if (inputChars.length == 1) {
            return convertTo26(inputChars[0]);
        }

        int result = 0;
        double power = 0d;
        for (int i = inputChars.length - 1; i >= 0; i--) {
            result += Math.pow(26d, power++) * convertTo26(inputChars[i]);
        }
        return result;
    }

    private static String convertNumberToString(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber <= convertTo26('z')) {
            return String.valueOf((char) (inputNumber + 96));
        }
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        while (inputNumber > 0) {
            remainder = inputNumber % 26;
            result.insert(0, (char) (remainder + 96));
            inputNumber = (inputNumber - remainder) / 26;
        }

        return result.toString();
    }

    private static int convertTo26(char c) {
        return c - 96;
    }



}
