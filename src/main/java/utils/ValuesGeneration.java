package utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValuesGeneration {

    private final static String pattern = "^(.*)\\[([0-9]+)(alphaNumericRandomCase|alphabeticWithSpaces)\\](.*)$";

    private static String value;

    public static String generateValue(String valueInput) {
        if (valueInput == null) {
            return null;
        }
        value = valueInput;
        if (Pattern.matches(pattern, value)) {
            return generateStringValue();
        }
        return value;
    }

    private static String generateStringValue() {
        String type = extract(pattern, value, 3);
        String sizeString = extract(pattern, value, 2);
        int size = Integer.parseInt(sizeString);
        String sufix = extract(pattern, value, 4);
        String prefix = extract(pattern, value, 1);
        String generatedValue;

        switch (type) {
            case "alphaNumericRandomCase":
                generatedValue = generateAlphanumericRandomCase(size);
                break;
            case "alphabeticWithSpaces":
                generatedValue = randomAlphabeticWithSpaces(size);
                break;
            default:
                return value;
        }
        return prefix + generatedValue + sufix;
    }

    private static String generateAlphanumericRandomCase(int size) {
        char[] chArr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(chArr[r.nextInt(chArr.length - 1)]);
        }
        return sb.toString();
    }

    private static String randomAlphabeticWithSpaces(int size) {
        char[] chArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i % 7 == 0 && i != 0) {
                sb.append(" ");
            } else {
                sb.append(chArr[r.nextInt(chArr.length - 1)]);
            }
        }
        return sb.toString();
    }

    private static String extract(String regex, String value, int group) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return matcher.group(group);
        }
        return value;
    }


}
