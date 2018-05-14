package vn.asiantech.internship.unittest;

import java.util.regex.Pattern;

public final class UsernameValidation {

    public static boolean isLengthUserName(String userName) {
        return !(userName.length() < 7 || userName.length() > 24);
    }

    public static boolean isTwoUppercaseLetterUsername(String userName) {
        int countUpppercaseLetterUsername = 0;
        for (int i = 0; i < userName.length(); i++) {
            if (Character.isUpperCase(userName.charAt(i))) {
                countUpppercaseLetterUsername++;
            }
        }
        return countUpppercaseLetterUsername >= 2;
    }

    public static boolean isSpecialCharacterSpaceUsername(String userName) {
        Pattern patternCpecialCharacterSpace = Pattern.compile("[^a-zA-Z0-9]", Pattern.CASE_INSENSITIVE);
        return !patternCpecialCharacterSpace.matcher(userName).find();
    }

    public static boolean isTwoDigitUsername(String userName) {
        int countDigitUsername = 0;
        for (int i = 0; i < userName.length(); i++) {
            if (Character.isDigit(userName.charAt(i))) {
                countDigitUsername++;
            }
        }
        return countDigitUsername <= 2;
    }
}
