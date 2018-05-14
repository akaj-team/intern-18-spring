package vn.asiantech.internship.unitest;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static vn.asiantech.internship.service_and_broadcast_receiver.MusicService.TAG;

public class UserValidation {
    private final String mUserName;
    private final String mPassWord;
    private static final String USER_NAME_LOG = "UserName Does Not Matched";
    private static final String PASSWORD_LOG = "PassWord Does Not Matched";
    private static final String STATUS_OK = "Ok";

    public UserValidation(String username, String password) {
        mUserName = username;
        mPassWord = password;
    }

    public String getPassWord() {
        return mPassWord;
    }

    public String getUserName() {
        return mUserName;
    }

    public String valid() {
        Log.e(TAG, "valid: " + isValidUserName());
        if (!isValidUserName()) {
            return USER_NAME_LOG;
        } else if (!isValidPassWord()) {
            return PASSWORD_LOG;
        }
        return STATUS_OK;
    }

    public boolean isValidUserName() {
        int numOfUpperChar = numOfUpperChar(mUserName);
        int numOfDigit = numOfDigit(mUserName);
        return mUserName.length() >= 7 && mUserName.length() <= 24 && numOfUpperChar >= 2
                && !isContainsSpecialChar(mUserName, true) && numOfDigit <= 2 && numOfDigit != 0;
    }

    private boolean isValidPassWord() {
        Log.e(TAG, "isValidPassWord: " + isRepeatChar(mPassWord, 3));
        return !mPassWord.contains(mUserName) && (isContainsSpecialChar(mPassWord, false)
                || numOfDigit(mPassWord) != 0) && numOfUpperChar(mPassWord) >= 3 && !mPassWord.contains(" ")
                && mPassWord.length() >= 8 && isRepeatChar(mPassWord, 2);
    }

    public int numOfUpperChar(String string) {
        int lenght = string.length();
        int numOfUpperChar = 0;
        for (int i = 0; i < lenght; i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                numOfUpperChar++;
            }
        }
        Log.e(TAG, "numOfUpperChar: " + numOfUpperChar);
        return numOfUpperChar;
    }

    private boolean isContainsSpecialChar(String string, boolean isUserName) {

        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher isSpecialChar = special.matcher(string);
        if (isUserName) {

            return string.contains(" ") || isSpecialChar.find();
        } else {
            Log.e(TAG, "isContainsSpecialChar: " + isSpecialChar.find());
            return isSpecialChar.find();
        }
    }

    private int numOfDigit(String string) {
        int length = string.length();
        int numOfDigit = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(string.charAt(i))) {
                numOfDigit++;
            }
        }
        Log.e(TAG, "numOfDigit: " + numOfDigit);
        return numOfDigit;
    }

    private boolean isRepeatChar(String string, int numOfRepeat) {
        if (!string.equals("")) {
            char key = string.charAt(0);
            int length = string.length();
            int countRepeat = 0;
            for (int i = 0; i < length - 1; i++) {
                if (string.charAt(i + 1) == key) {
                    countRepeat++;
                } else {
                    if (countRepeat > numOfRepeat) {
                        Log.e(TAG, "isRepeatChar: " + countRepeat + key );
                        return false;
                    } else {
                        key = string.charAt(i + 1);
                        countRepeat = 0;
                    }
                }
            }
            return countRepeat > numOfRepeat;
        } else {
            return false;
        }
    }

}
