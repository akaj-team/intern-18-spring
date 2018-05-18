package vn.asiantech.internship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.model.User;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserValidationTest {
    @Mock
    private User mUser;

    @Test
    public void userNameLengthIsLongerThanTwentyFiveReturnTrue() {
        when(mUser.getUserName()).thenReturn("aaaaaaaaaaaaaaaaaaaaaaaaaa"); // 26 char ax
        assertTrue(UserValidation.isUserNameLengthValidate(mUser.getUserName()));
    }

    @Test
    public void userNameLengthIsShorterThanSevenReturnTrue() {
        when(mUser.getUserName()).thenReturn("a");
        assertTrue(UserValidation.isUserNameLengthValidate(mUser.getUserName()));
    }

    @Test
    public void userNameLengthIsLongerThanSevenAndShorterThanTwentyFiveReturnFalse() {
        when(mUser.getUserName()).thenReturn("aaaaaaaa");//8 char a
        assertFalse(UserValidation.isUserNameLengthValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveLessThanTwoCapitalCharReturnTrue() {
        when(mUser.getUserName()).thenReturn("aA");
        assertTrue(UserValidation.isUserNameCapitalValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveTwoCapitalCharOrMoreReturnFalse() {
        when(mUser.getUserName()).thenReturn("aAA");
        assertFalse(UserValidation.isUserNameCapitalValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveMoreThanTwoDigitReturnTrue() {
        when(mUser.getUserName()).thenReturn("a123");
        assertTrue(UserValidation.isUserNameDigitNumberValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveTwoDigitOrLessThanReturnFalse() {
        when(mUser.getUserName()).thenReturn("a1");
        assertFalse(UserValidation.isUserNameDigitNumberValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveASpaceReturnTrue() {
        when(mUser.getUserName()).thenReturn("Space Here");
        assertTrue(UserValidation.isUserNameSpecialCharAndSpaceValidate(mUser.getUserName()));
    }

    @Test
    public void userNameDoNotHaveASpaceReturnFalse() {
        when(mUser.getUserName()).thenReturn("SpaceHere");
        assertFalse(UserValidation.isUserNameSpecialCharAndSpaceValidate(mUser.getUserName()));
    }

    @Test
    public void userNameHaveASpecialCharacterReturnTrue() {
        when(mUser.getUserName()).thenReturn("SpecialCharacter!");
        assertTrue(UserValidation.isUserNameSpecialCharAndSpaceValidate(mUser.getUserName()));
    }

    @Test
    public void userNameDoNotHaveASpecialCharacterReturnFalse() {
        when(mUser.getUserName()).thenReturn("SpecialCharacter");
        assertFalse(UserValidation.isUserNameSpecialCharAndSpaceValidate(mUser.getUserName()));
    }

    @Test
    public void passwordLookLikeUserNameReturnTrue() {
        when(mUser.getPassword()).thenReturn("username");
        when(mUser.getUserName()).thenReturn("username");
        assertTrue(UserValidation
                .isPasswordSameUserNameValidate(mUser.getPassword(), mUser.getUserName()));
    }

    @Test
    public void passwordDoNotLookLikeUserNameReturnFalse() {
        when(mUser.getPassword()).thenReturn("password");
        when(mUser.getUserName()).thenReturn("username");
        assertFalse(UserValidation
                .isPasswordSameUserNameValidate(mUser.getPassword(), mUser.getUserName()));
    }

    @Test
    public void passwordDoNotHaveSpecialCharOrDigitReturnTrue() {
        when(mUser.getPassword()).thenReturn("password");
        assertTrue(UserValidation.isPasswordSpecialCharOrNumberValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveDigitReturnFalse() {
        when(mUser.getPassword()).thenReturn("password1");
        assertFalse(UserValidation.isPasswordSpecialCharOrNumberValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveSpecialCharReturnFalse() {
        when(mUser.getPassword()).thenReturn("password#");
        assertFalse(UserValidation.isPasswordSpecialCharOrNumberValidate(mUser.getPassword()));
    }

    @Test
    public void passwordLengthShorterThanEightReturnTrue() {
        when(mUser.getPassword()).thenReturn("a");
        assertTrue(UserValidation.isPasswordLengthValidate(mUser.getPassword()));
    }

    @Test
    public void passwordLengthLongerThanEightReturnFalse() {
        when(mUser.getPassword()).thenReturn("aaaaaaaaa"); // 9 char a
        assertFalse(UserValidation.isPasswordLengthValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveATriplicateCharReturnTrue() {
        when(mUser.getPassword()).thenReturn("aaabcd");
        assertTrue(UserValidation.isPasswordRepeatCharValidate(mUser.getPassword()));
    }

    @Test
    public void passwordDoNotHaveATriplicateCharReturnFalse() {
        when(mUser.getPassword()).thenReturn("abcd");
        assertFalse(UserValidation.isPasswordRepeatCharValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveASpaceReturnTrue() {
        when(mUser.getPassword()).thenReturn("Space here");
        assertTrue(UserValidation.isPasswordSpaceValidate(mUser.getPassword()));
    }

    @Test
    public void passwordDoNotHaveASpaceReturnFalse() {
        when(mUser.getPassword()).thenReturn("Spacehere");
        assertFalse(UserValidation.isPasswordSpaceValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveLessThanThreeCapitalCharReturnTrue() {
        when(mUser.getPassword()).thenReturn("CapitalChar");
        assertTrue(UserValidation.isPasswordCapitalValidate(mUser.getPassword()));
    }

    @Test
    public void passwordHaveThreeCapitalCharOrMoreThanReturnFalse() {
        when(mUser.getPassword()).thenReturn("CapitalCharThree");
        assertFalse(UserValidation.isPasswordCapitalValidate(mUser.getPassword()));
    }
}
