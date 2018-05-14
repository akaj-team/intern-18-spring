package vn.asiantech.internship.unittest;

import java.util.regex.Pattern;

public class PasswordValidation {

    public static boolean isPasswordDifferentUserName(String userName, String password) {
        return userName.equals(password);
    }

    public static boolean isSpecialCharacterNumberPassword(String password) {
        Pattern patternSpecialCharacterNumber = Pattern.compile("[^a-zA-Z]", Pattern.CASE_INSENSITIVE);
        return patternSpecialCharacterNumber.matcher(password).find();
    }

    public static boolean isLengthPassword(String password) {
        return password.length() >= 8;
    }

    public static boolean isDontRepeatCharacterTwicePassword(String password) {
        int countCharacterPassword = 0;
        String pass[] = password.split("");
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                if (pass[i].equals(pass[j])) {
                    countCharacterPassword++;
                    if (countCharacterPassword > 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSpacePassword(String password) {
        return !password.contains(" ");
    }

    public static boolean isThreeUppercaseLetterPassword(String userName) {
        int countUppercaseLetterPassword = 0;
        for (int i = 0; i < userName.length(); i++) {
            if (Character.isUpperCase(userName.charAt(i))) {
                countUppercaseLetterPassword++;
            }
        }
        return countUppercaseLetterPassword >= 3;
    }
}
