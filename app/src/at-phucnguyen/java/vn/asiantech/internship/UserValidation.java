/*
 * Nguyen Van Phuc
 */
package vn.asiantech.internship;

import java.util.regex.Pattern;

public class UserValidation {
    public static final int ERROR_1 = -1;
    public static final int ERROR_2 = -2;
    public static final int ERROR_3 = -3;
    public static final int ERROR_4 = -4;
    public static final int ERROR_5 = -5;
    public static final int CHECKPASS = 1;

    /**
     * UserName input Error
     * ERROR 1: Length is greater than 7 and less than 24 characters
     * ERROR 2: At least 2 characters in uppercase
     * ERROR 3: Does not contain special characters and spaces
     * ERROR 4: At most 2 digits
     */
    static int checkUserName(String userName) {
        if (!countLengthString(userName, 7, 24)) {
            return ERROR_1;
        }
        if (!requiredNUpperCaseChar(userName, 2)) {
            return ERROR_2;
        }
        if (isExistSpecialChar(userName) || isExistWhiteSpace(userName)) {
            return ERROR_3;
        }
        if (!limitTwoNumber(userName)) {
            return ERROR_4;
        }
        return CHECKPASS;
    }

    /**
     * ERROR 1: Other username, distinguish the normal flower character
     * ERROR 2: There is at least one special character or number
     * ERROR 3: The minimum length is 8 characters and can not be repeated 1 character more than 2 times
     * ERROR 4: Does not contain space
     * ERROR 5: There are at least 3 uppercase letters
     */
    static int checkPassword(String useNameBest, String passWork) {
        if (useNameBest.equals(passWork)) {
            return ERROR_1;
        }
        if (!isExistNumbOrIsExistSpecialChar(passWork)) {
            return ERROR_2;
        }
        if (isLimitedNReplaceChar(passWork, 2) || !checkLengthPassWork(passWork)) {
            return ERROR_3;
        }
        if (isExistWhiteSpace(passWork)) {
            return ERROR_4;
        }
        if (!requiredNUpperCaseChar(passWork, 3)) {
            return ERROR_5;
        }
        return CHECKPASS;
    }

    static boolean requiredNUpperCaseChar(String s, int n) {
        return Pattern.compile("^.*(.*[A-Z]){" + n + ",}.*$").matcher(s).matches();
    }

    static boolean limitTwoNumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.codePointAt(i))) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean countLengthString(String s, int n, int m) {
        return (s.length() >= n && s.length() <= m);
    }

    //Check the existence of Whitespace in the string
    static boolean isExistWhiteSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.codePointAt(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean isExistSpecialChar(String s) {
        return Pattern.compile("[^A-Za-z0-9].*").matcher(s).find();
    }

    static boolean isLimitedNReplaceChar(String s, int nReplace) {
        int count;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.codePointAt(i) == s.codePointAt(j)) {
                    count++;
                }
                if (count >= nReplace) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkLengthPassWork(String s) {
        return s.length() >= 8;
    }

    static boolean isExistNumbOrIsExistSpecialChar(String s) {
        return Pattern.compile("[0-9].*|[^A-Za-z0-9].*").matcher(s).find();
    }
}
