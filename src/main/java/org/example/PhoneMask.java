package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneMask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Номер телефону у форматі  380 ХХ 9999 999\nВведіть 0 для завершення");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.exit(0);
            }
            boolean isValid = validPhone(input);
            if (isValid) {
                System.out.printf("Телефон: %s - валідний\n\n", input);
            } else {
                System.err.printf("Телефон: %s - не відповідає формату 380 ХХ 9999 999\n\n", input);
            }
        }
        while (true);
    }

    private static boolean validPhone(String input) {
        String reg = "^380(50|66|95|99|67|68|96|97|98|63|73|93|91|92|94)[0-9]{7,12}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
