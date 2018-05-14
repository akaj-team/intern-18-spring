package vn.asiantech.internship;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.unittest.PasswordValidation;
import vn.asiantech.internship.unittest.UserUnitTest;
import vn.asiantech.internship.unittest.UsernameValidation;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserValidation {
    @Mock
    private UserUnitTest mUserUnitTest;

    @Test
    public void checkLengthUsername() {
        when(mUserUnitTest.getUserName()).thenReturn("huy");
        Assert.assertFalse(UsernameValidation.isLengthUserName(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen3");
        Assert.assertTrue(UsernameValidation.isLengthUserName(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen3huynguyen3huynguyen3");
        Assert.assertFalse(UsernameValidation.isLengthUserName(mUserUnitTest.getUserName()));
    }

    @Test
    public void checkTwoUppercaseLetterUsername() {
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen3");
        Assert.assertFalse(UsernameValidation.isTwoUppercaseLetterUsername(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen3AA");
        Assert.assertTrue(UsernameValidation.isTwoUppercaseLetterUsername(mUserUnitTest.getUserName()));
    }

    @Test
    public void checkSpecialCharacterSpaceUsername() {
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen$");
        Assert.assertFalse(UsernameValidation.isSpecialCharacterSpaceUsername(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen ");
        Assert.assertFalse(UsernameValidation.isSpecialCharacterSpaceUsername(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen");
        Assert.assertTrue(UsernameValidation.isSpecialCharacterSpaceUsername(mUserUnitTest.getUserName()));
    }

    @Test
    public void checkTwoDigitUsername() {
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen333");
        Assert.assertFalse(UsernameValidation.isTwoDigitUsername(mUserUnitTest.getUserName()));
        when(mUserUnitTest.getUserName()).thenReturn("huynguyen3");
        Assert.assertTrue(UsernameValidation.isTwoDigitUsername(mUserUnitTest.getUserName()));
    }

    @Test
    public void checkPasswordDifferentUserName() {
        when(mUserUnitTest.getUserName()).thenReturn("nguyenhuy");
        when(mUserUnitTest.getUserName()).thenReturn("nguyenhuy123");
        Assert.assertFalse(PasswordValidation.isPasswordDifferentUserName(mUserUnitTest.getUserName(), mUserUnitTest.getPassword()));
        when(mUserUnitTest.getUserName()).thenReturn("nguyenhuy3AA");
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy3AA");
        Assert.assertTrue(PasswordValidation.isPasswordDifferentUserName(mUserUnitTest.getUserName(), mUserUnitTest.getPassword()));
    }

    @Test
    public void checkSpecialCharacterNumberPassword() {
        when(mUserUnitTest.getPassword()).thenReturn("nguyenquanghuy");
        Assert.assertFalse(PasswordValidation.isSpecialCharacterNumberPassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy$");
        Assert.assertTrue(PasswordValidation.isSpecialCharacterNumberPassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy1");
        Assert.assertTrue(PasswordValidation.isSpecialCharacterNumberPassword(mUserUnitTest.getPassword()));
    }

    @Test
    public void checkLengthPassword() {
        when(mUserUnitTest.getPassword()).thenReturn("huy123");
        Assert.assertFalse(PasswordValidation.isLengthPassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy");
        Assert.assertTrue(PasswordValidation.isLengthPassword(mUserUnitTest.getPassword()));
    }

    @Test
    public void checkDontRepeatCharacterTwicePassword() {
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuyyy");
        Assert.assertFalse(PasswordValidation.isDontRepeatCharacterTwicePassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("huy123");
        Assert.assertTrue(PasswordValidation.isDontRepeatCharacterTwicePassword(mUserUnitTest.getPassword()));
    }

    @Test
    public void checkSpacePassword() {
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy ");
        Assert.assertFalse(PasswordValidation.isSpacePassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy");
        Assert.assertTrue(PasswordValidation.isSpacePassword(mUserUnitTest.getPassword()));
    }

    @Test
    public void checkThreeUppercaseLetterPassword() {
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuy");
        Assert.assertFalse(PasswordValidation.isThreeUppercaseLetterPassword(mUserUnitTest.getPassword()));
        when(mUserUnitTest.getPassword()).thenReturn("nguyenhuyAAA");
        Assert.assertTrue(PasswordValidation.isThreeUppercaseLetterPassword(mUserUnitTest.getPassword()));
    }
}
