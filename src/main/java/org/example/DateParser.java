package org.example;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    private static final Pattern datePattern = Pattern.compile(
            "^([0-9]{1,2})[/.]([0-9]{1,2})[/.]([0-9]{4})(\\s([0-9]{2}):([0-9]{2}):([0-9]{2}))?|([0-9]{4})|(([0-9]{1,2})[/.]([0-9]{4}))");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введіть дату:");
            String date = scanner.nextLine();
            if (date.equals("0")) System.exit(0);

            Matcher matcher = datePattern.matcher(date);
            if (matcher.matches()) {
                System.out.println("Дата коректна");

                if (matcher.group(1) != null && matcher.group(2) != null && matcher.group(3) != null) {
                    int day = Integer.parseInt(matcher.group(1));
                    int month = Integer.parseInt(matcher.group(2));
                    int year = Integer.parseInt(matcher.group(3));


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, month - 1, day);
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                    System.out.println("День тижня: " + dayOfWeek);
                    System.out.println("Місяць: " + month);
                    System.out.println("Рік: " + year);

                    if (matcher.group(4) != null) {
                        int hour = Integer.parseInt(matcher.group(5));
                        int minute = Integer.parseInt(matcher.group(6));
                        int second = Integer.parseInt(matcher.group(7));

                        System.out.println("Час: " + hour + ":" + minute + ":" + second);
                    }
                }

                if (matcher.group(8) != null) {
                    int onlyYear = Integer.parseInt(matcher.group(8));
                    System.out.println("Рік: " + onlyYear);
                }

                if (matcher.group(9) != null) {
                    int month1 = Integer.parseInt(matcher.group(10));
                    int year1 = Integer.parseInt(matcher.group(11));
                    System.out.println("Місяць: " + month1);
                    System.out.println("Рік: " + year1);
                }

            } else {
                System.err.println("Дата некоректна");
            }
        } while (true);

    }
}
