package vn.asiantech.internship;

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
        return password.length() > 8;
    }

}
