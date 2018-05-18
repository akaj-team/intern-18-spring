package vn.asiantech.internship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.unitest.User;
import vn.asiantech.internship.unitest.UserValidation;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationTest {
    @Mock
    private User mUser;

    @Test
    public void testCaseHasNotContainUpperChar() {
        when(mUser.getUserName()).thenReturn("asdsd");
        assertEquals(UserValidation.numOfUpperChar(mUser.getUserName()), 0);
    }

    @Test
    public void testCaseCheckUpperCharWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.numOfUpperChar(mUser.getUserName()), 0);
    }

    @Test
    public void testCaseHasContainTwoUpperChar() {
        when(mUser.getUserName()).thenReturn("DsDsd");
        assertEquals(UserValidation.numOfUpperChar(mUser.getUserName()), 2);
    }

    @Test
    public void testCaseHasContainOneUpperChar() {
        when(mUser.getUserName()).thenReturn("fdxsDsd");
        assertEquals(UserValidation.numOfUpperChar(mUser.getUserName()), 1);
    }

    @Test
    public void testCaseContainSpecialChar() {
        when(mUser.getUserName()).thenReturn("?fdxsDsd*");
        assertTrue(UserValidation.isContainsSpecialChar(mUser.getUserName(), true));
    }

    @Test
    public void testCaseContainVietKeyChar() {
        when(mUser.getUserName()).thenReturn("fdxsDsdâ");
        assertTrue(UserValidation.isContainsSpecialChar(mUser.getUserName(), true));
    }

    @Test
    public void testCaseContainChar() {
        when(mUser.getUserName()).thenReturn("fdxsDSpace sd");
        assertTrue(UserValidation.isContainsSpecialChar(mUser.getUserName(), true));
    }

    @Test
    public void testCaseNoContainSpecialChar() {
        when(mUser.getUserName()).thenReturn("asdafdxsDsd");
        assertFalse(UserValidation.isContainsSpecialChar(mUser.getUserName(), true));
    }

    @Test
    public void testCaseHasNotContainSpecialCharWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertFalse(UserValidation.isContainsSpecialChar(mUser.getUserName(), true));
    }

    @Test
    public void testCaseHasNotContainDigitWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.numOfDigit(mUser.getUserName()), 0);
    }

    @Test
    public void testCaseHasContainOneDigit() {
        when(mUser.getUserName()).thenReturn("1asdsad");
        assertEquals(UserValidation.numOfDigit(mUser.getUserName()), 1);
    }

    @Test
    public void testCaseHasNotContainDigit() {
        when(mUser.getUserName()).thenReturn("asdasda<?");
        assertEquals(UserValidation.numOfDigit(mUser.getUserName()), 0);
    }

    @Test
    public void testCaseHasContainTenDigit() {
        when(mUser.getUserName()).thenReturn("0123456789asdsad");
        assertEquals(UserValidation.numOfDigit(mUser.getUserName()), 10);
    }

    @Test
    public void testCaseHasNotContainRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsad");
        assertFalse(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseContainRepeatCharWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertFalse(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseHasContainOneRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsadd");
        assertFalse(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseHasContainTwoRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsaddd");
        assertTrue(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseHasContainThreeRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsadddd");
        assertTrue(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseHasContainRepeatMoreThanTwoTime() {
        when(mUser.getUserName()).thenReturn("0123456789asdsaddddddddd");
        assertTrue(UserValidation.isRepeatChar(mUser.getUserName()));
    }

    @Test
    public void testCaseCheckLengthUseName() {
        when(mUser.getUserName()).thenReturn("AAa2");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AAa2sdsadasdasdadasddasdasdcasdcsdssc");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AAa2dssc");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("asHHa22dvsc");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("asHHa22d");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("asHHa22dasfzasddafsasc");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
    }

    @Test
    public void testCaseCheckUserNameContainUpperCase() {
        when(mUser.getUserName()).thenReturn("89asdddddd");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("89Asdddddd");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("89AGsdddddd");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("89AGSdddddd");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("89AGSDDDDS");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
    }

    @Test
    public void testCaseHasCheckUserNameContainSpecialChar() {
        when(mUser.getUserName()).thenReturn("AA11asdaas");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11asd?as");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA*11asd?as");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11asdasê");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11as das");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11êas das");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11êas         das");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11êêêêêêêêêêêêêas         das");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
    }

    @Test
    public void testCaseCheckUserNameContainDigit() {
        when(mUser.getUserName()).thenReturn("AAdasdasdas");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA1dasdasdas");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA11dasdasdas");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA111dasdasdas");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("AA1112223111");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getUserName()).thenReturn("1112223111");
        assertFalse(UserValidation.isValidUserName(mUser.getUserName()));
    }

    @Test
    public void testCaseCheckLengthPassword() {
        when(mUser.getUserName()).thenReturn("12ABsdsfwas");
        when(mUser.getPassword()).thenReturn("");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getUserName()).thenReturn("12AAsdswas");
        when(mUser.getPassword()).thenReturn("daA1HCA");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getUserName()).thenReturn("12ABsdswsas");
        assertTrue(UserValidation.isValidUserName(mUser.getUserName()));
        when(mUser.getPassword()).thenReturn("ASC1asd");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASC1asdg");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASC1asdga");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASC1asdasd");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASC1asdasdascfga");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckPasswordContainUserName() {
        when(mUser.getUserName()).thenReturn("15ABCsdfwas");
        when(mUser.getPassword()).thenReturn("");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("15ABCsdfwas");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("15ABCsdfwasdd");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("25ABCsdfwasdd");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("AHG12fawrxs");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckPasswordContainSpecialCharOrDigit() {
        when(mUser.getUserName()).thenReturn("15ABsdgwss");
        when(mUser.getPassword()).thenReturn("ASCasdscs");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASCasdscs1");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASCasdscs@");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASCasdscs@1");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASCasds cs@1");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckPasswordContainSpace() {
        when(mUser.getUserName()).thenReturn("15ABsdcgwss");
        when(mUser.getPassword()).thenReturn("UYCasdscs1@");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYCasd scs1@");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYCasd   scs1@");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckPasswordContainRepeatMoreThanTwoTime() {
        when(mUser.getUserName()).thenReturn("15ABsdgscgwss");
        when(mUser.getPassword()).thenReturn("UYC1@asfc");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYC1@asfcc");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYC1@asfccc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYC1@asfcccc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("UYC1@asfccccccc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckPasswordContainUpperChar() {
        when(mUser.getUserName()).thenReturn("15ABsgcdgscgwss");
        when(mUser.getPassword()).thenReturn("asa1@asfc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("Asa1@asfc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASa1@asfc");
        assertFalse(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASA1@asfc");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASAC1@asfc");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
        when(mUser.getPassword()).thenReturn("ASAC1@ASFC");
        assertTrue(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()));
    }

    @Test
    public void testCaseCheckUserValid() {
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.valid(mUser), UserValidation.USER_NAME_LOG);
        when(mUser.getUserName()).thenReturn("15sggwss");
        assertEquals(UserValidation.valid(mUser), UserValidation.USER_NAME_LOG);
        when(mUser.getUserName()).thenReturn("15ABsggxwss");
        when(mUser.getPassword()).thenReturn("");
        assertEquals(UserValidation.valid(mUser), UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABssgwss");
        when(mUser.getPassword()).thenReturn("asc");
        assertEquals(UserValidation.valid(mUser), UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsgggwss");
        when(mUser.getPassword()).thenReturn("asc1akfg");
        assertEquals(UserValidation.valid(mUser), UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsgggwss");
        when(mUser.getPassword()).thenReturn("asc1akfgAA");
        assertEquals(UserValidation.valid(mUser), UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsxxlgwss");
        when(mUser.getPassword()).thenReturn("asc1akfgCVA");
        assertEquals(UserValidation.valid(mUser), UserValidation.STATUS_OK);
    }
}
