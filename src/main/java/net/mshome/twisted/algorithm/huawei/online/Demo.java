// package net.mshome.twisted.algorithm.huawei.online;
//
// import java.math.BigDecimal;
// import java.util.Scanner;
//
// public class TowNumberMultiplex {
//
//     // 9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         while (scanner.hasNext()) {
//             String input = scanner.nextLine();
//             String[] numbers = input.split("\\s+");
//             String number1 = numbers[0];
//             String number2 = numbers[1];
//             int length = number1.length();
//             int length2 = number2.length();
//             String numberx = number1 ; //.substring(0, length / 2) + "." + number1.substring(length / 2);
//             String numbery = number2; //.substring(0, length2 / 2) + "." + number2.substring(length2 / 2);
//             BigDecimal decimal1 = new BigDecimal(numberx);
//             BigDecimal decimal2 = new BigDecimal(numbery);
//             BigDecimal result = decimal1.multiply(decimal2);
//             String resultStr = result.toString().replace(".", "");
//             if (resultStr.startsWith("0")) {
//                 String tmp = resultStr.replaceFirst("0+", "");
//                 if (tmp.isEmpty()) {
//                     System.out.println(0);
//                     continue;
//                 }
//                 System.out.println(tmp);
//             } else {
//                 System.out.println(resultStr);
//             }
//         }
//     }
//
// }
