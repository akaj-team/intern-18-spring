package vn.asiantech.internship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UserValidation {
    private UserValidation() {
    }

    public static boolean isUserNameLengthValidate(String userName) {
        return userName.length() <= 7 || userName.length() >= 25;
    }

    public static boolean isUserNameCapitalValidate(String userName) {
        return countUpperCase(userName) < 2;
    }

    public static boolean isUserNameSpecialCharAndSpaceValidate(String userName) {
        return checkSpecialChar(userName);
    }

    public static boolean isUserNameDigitNumberValidate(String userName) {
        return countDigitNumber(userName) > 2;
    }

    public static boolean isPasswordSameUserNameValidate(String password, String userName) {
        return password.equals(userName);
    }

    public static boolean isPasswordSpecialCharOrNumberValidate(String password) {
        return !checkSpecialChar(password) && countDigitNumber(password) == 0;
    }

    public static boolean isPasswordLengthValidate(String password) {
        return password.length() < 8;
    }

    public static boolean isPasswordRepeatCharValidate(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                count += password.charAt(i) == password.charAt(j) ? 1 : 0;
            }
        }
        return count > 2;
    }

    public static boolean isPasswordSpaceValidate(String password) {
        return password.contains(" ");
    }

    public static boolean isPasswordCapitalValidate(String password) {
        return countUpperCase(password) < 3;
    }

    private static boolean checkSpecialChar(String string) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    private static int countDigitNumber(String string) {
        int count = 0;
        for (char x : string.toCharArray()) {
            count += Character.isDigit(x) ? 1 : 0;
        }
        return count;
    }

    private static int countUpperCase(String string) {
        int count = 0;
        for (char x : string.toCharArray()) {
            count += Character.isUpperCase(x) ? 1 : 0;
        }
        return count;
    }
}
