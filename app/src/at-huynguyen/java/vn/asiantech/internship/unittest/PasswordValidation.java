package vn.asiantech.internship.unittest;

import java.util.regex.Pattern;

public class PasswordValidation {

    public static boolean isPasswordDifferentUserName(String userName, String password) {
        return userName.equals(password);
    }

    public static boolean isSpecialCharacterNumber(String password) {
        Pattern patternSpecialCharacterNumber = Pattern.compile("^[a-zA-z]$", Pattern.CASE_INSENSITIVE);
        return patternSpecialCharacterNumber.matcher(password).find();
    }

    public static boolean isLengthPassword(String password) {
        return password.length() >= 8;
    }

    public static boolean isDontRepeatCharacterTwice(String password) {
        int count = 0;
        String pass[] = password.split("");
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                if (pass[i].equals(pass[j])) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSpace(String password) {
        return !password.contains(" ");
    }

    public static boolean isThreeUppercaseLetter(String userName) {
        Pattern patternTwoUppercaseLetter = Pattern.compile("^[A-Z]{3,}$");
        return patternTwoUppercaseLetter.matcher(userName).find();
    }
}
