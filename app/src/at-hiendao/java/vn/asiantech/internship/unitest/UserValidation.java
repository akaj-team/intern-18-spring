package vn.asiantech.internship.unitest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UserValidation {
    public static final String USER_NAME_LOG = "USERNAME DOES NOT MATCHED";
    public static final String PASSWORD_LOG = "PASSWORD DOES NOT MATCHED";
    public static final String STATUS_OK = "OK";
    private static final int MAX_NUM_REPEAT = 2;

    public static String valid(User user) {
        if (!isValidUserName(user.getUserName())) {
            return USER_NAME_LOG;
        } else if (!isValidPassWord(user.getUserName(), user.getPassword())) {
            return PASSWORD_LOG;
        }
        return STATUS_OK;
    }

    public static boolean isValidUserName(String userName) {
        int numOfUpperChar = numOfUpperChar(userName);
        int numOfDigit = numOfDigit(userName);
        return userName.length() >= 7 && userName.length() <= 24 && numOfUpperChar >= 2
                && !isContainsSpecialChar(userName, true) && numOfDigit <= 2 && numOfDigit > 0;
    }

    public static boolean isValidPassWord(String userName, String password) {
        return !password.contains(userName) && (isContainsSpecialChar(password, false)
                || numOfDigit(password) > 0) && numOfUpperChar(password) >= 3 && !password.contains(" ")
                && password.length() >= 8 && !isRepeatChar(password);
    }

    public static int numOfUpperChar(String string) {
        int lenght = string.length();
        int numOfUpperChar = 0;
        for (int i = 0; i < lenght; i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                numOfUpperChar++;
            }
        }
        return numOfUpperChar;
    }

    public static boolean isContainsSpecialChar(String string, boolean isUserName) {
        Pattern special = Pattern.compile("[^A-Za-z0-9]");
        Matcher isSpecialChar = special.matcher(string);
        if (isUserName) {
            return isSpecialChar.find();
        } else {
            return isSpecialChar.find();
        }
    }

    public static int numOfDigit(String string) {
        int length = string.length();
        int numOfDigit = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(string.charAt(i))) {
                numOfDigit++;
            }
        }
        return numOfDigit;
    }

    public static boolean isRepeatChar(String string) {
        if (!string.equals("")) {
            char key = string.charAt(0);
            int length = string.length();
            int countRepeat = 0;

            for (int i = 0; i < length - 1; i++) {
                if (string.charAt(i + 1) == key) {
                    countRepeat++;
                } else {
                    if (countRepeat >= MAX_NUM_REPEAT) {
                        return false;
                    } else {
                        key = string.charAt(i + 1);
                        countRepeat = 0;
                    }
                }
            }
            return countRepeat >= MAX_NUM_REPEAT;
        } else {
            return false;
        }
    }
}
