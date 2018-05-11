package vn.asiantech.internship;

import java.util.regex.Pattern;

public class UsernameValidation {

    public static boolean isLengthUserName(String userName) {
        return !(userName.length() < 7 || userName.length() > 24);
    }

    public static boolean isTwoUppercaseLetter(String userName) {
        Pattern patternTwoUppercaseLetter = Pattern.compile("^[A-Z]{2,}$");
        return patternTwoUppercaseLetter.matcher(userName).find();
    }

    public static boolean isSpecialCharacterUserName(String userName) {
        Pattern patternSpecialCharacterUserName = Pattern.compile("^[a-zA-Z0-9]$", Pattern.CASE_INSENSITIVE);
        return !patternSpecialCharacterUserName.matcher(userName).find();
    }

    public static boolean isTwoDigitNumber(String userName) {
        Pattern patternTwoDigitNumber = Pattern.compile("^[0-9]{1,2}$");
        return  patternTwoDigitNumber.matcher(userName).find();
    }

}
