package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введіть E-Mail для валідації\n Введіть 0 для завершення");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.exit(0);
            }
            boolean isValid = validMail(input);
            if (isValid) {
                System.out.printf("E-Mail: %s - валідний\n\n", input);
            } else {
                System.err.printf("E-Mail: %s - не валідний\n\n", input);
            }
        }
        while (true);
    }

    private static boolean validMail(String input) {
        String reg = "^[a-zA-Z0-9+._-]+@([a-zA-z]{2,10}\\.){1,4}[a-zA-z]{2,5}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
