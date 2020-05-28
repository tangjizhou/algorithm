package net.mshome.twisted.algorithm.huawei.online;

import java.math.BigDecimal;
import java.util.Scanner;

public class TowNumberMultiply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] numbers = input.split("\\s+");
            String number1 = numbers[0];
            String number2 = numbers[1];
            BigDecimal decimal1 = new BigDecimal(number1);
            BigDecimal decimal2 = new BigDecimal(number2);
            BigDecimal result = decimal1.multiply(decimal2);
            System.out.println(result.toString());
        }
    }

}
