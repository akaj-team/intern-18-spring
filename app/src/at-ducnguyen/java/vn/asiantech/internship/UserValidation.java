package vn.asiantech.internship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    public static boolean userNameLengthValidate(String userName) {
        return userName.length() <= 7 || userName.length() >= 25;
    }

    public static boolean userNameCapitalValidate(String userName) {
        return countUpperCase(userName) < 2;
    }

    public static boolean userNameSpecialCharAndSpaceValidate(String userName) {
        return checkSpecialChar(userName);
    }

    public static boolean userNameDigitNumberValidate(String userName) {
        return countDigitNumber(userName) > 2;
    }

    public static boolean passwordDifferenceUserNameValidate(String password, String userName) {
        return password.equals(userName);
    }

    public static boolean passwordSpecialCharOrNumberValidate(String password) {
        return !checkSpecialChar(password) && countDigitNumber(password) == 0;
    }

    public static boolean passwordLengthValidate(String password) {
        return password.length() < 8;
    }

    public static boolean passwordRepeatCharValidate(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                count += password.charAt(i) == password.charAt(j) ? 1 : 0;
            }
        }
        return count > 2;
    }

    public static boolean passwordSpaceValidate(String password) {
        return password.contains(" ");
    }

    public static boolean passwordCapitalValidate(String password) {
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
