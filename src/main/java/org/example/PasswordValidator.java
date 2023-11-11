package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введіть пароль для валідації\nВведіть 0 для завершення");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.exit(0);
            }
            boolean isValid = validPassword(input);
            if (isValid) {
                System.out.printf("Пароль: %s - валідний\n\n", input);
            } else {
                System.err.printf("Пароль: %s - не валідний\n\n", input);
            }
        }
        while (true);
    }

    private static boolean validPassword(String input) {
        String reg = "((?=.*[0-9])(?=.*[A-Z])(?=.*[,./?])).{8,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
