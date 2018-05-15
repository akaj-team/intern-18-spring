package vn.asiantech.internship.unitest.test;

import static org.mockito.Mockito.when;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import vn.asiantech.internship.unitest.User;
import vn.asiantech.internship.unitest.UserValidation;


@RunWith(MockitoJUnitRunner.class)
public class TestUserValidation {
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
        assertEquals(UserValidation.isContainsSpecialChar(mUser.getUserName(), true), true);
    }

    @Test
    public void testCaseContainVietKeyChar() {
        when(mUser.getUserName()).thenReturn("fdxsDsdâ");
        assertEquals(UserValidation.isContainsSpecialChar(mUser.getUserName(), true), true);
    }

    @Test
    public void testCaseContainChar() {
        when(mUser.getUserName()).thenReturn("fdxsDSpace sd");
        assertEquals(UserValidation.isContainsSpecialChar(mUser.getUserName(), true), true);
    }

    @Test
    public void testCaseNoContainSpecialChar() {
        when(mUser.getUserName()).thenReturn("asdafdxsDsd");
        assertEquals(UserValidation.isContainsSpecialChar(mUser.getUserName(), true), false);
    }

    @Test
    public void testCaseHasNotContainSpecialCharWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.isContainsSpecialChar(mUser.getUserName(), true), false);
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
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), false);
    }

    @Test
    public void testCaseContainRepeatCharWithNullString() {
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), false);
    }

    @Test
    public void testCaseHasContainOneRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsadd");
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), false);
    }

    @Test
    public void testCaseHasContainTwoRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsaddd");
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), true);
    }

    @Test
    public void testCaseHasContainThreeRepeatChar() {
        when(mUser.getUserName()).thenReturn("0123456789asdsadddd");
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), true);
    }

    @Test
    public void testCaseHasContainRepeatMoreThanTwoTime() {
        when(mUser.getUserName()).thenReturn("0123456789asdsaddddddddd");
        assertEquals(UserValidation.isRepeatChar(mUser.getUserName()), true);
    }

    @Test
    public void testCaseCheckLengthUseName() {
        when(mUser.getUserName()).thenReturn("AAa2");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AAa2sdsadasdasdadasddasdasdcasdcsdssc");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AAa2dssc");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("asHHa22dvsc");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("asHHa22d");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("asHHa22dasfzasddafsasc");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
    }

    @Test
    public void testCaseCheckUserNameContainUpperCase() {
        when(mUser.getUserName()).thenReturn("89asdddddd");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("89Asdddddd");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("89AGsdddddd");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("89AGSdddddd");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("89AGSDDDDS");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
    }

    @Test
    public void testCaseHasCheckUserNameContainSpecialChar() {
        when(mUser.getUserName()).thenReturn("AA11asdaas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("AA11asd?as");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA*11asd?as");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA11asdasê");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA11as das");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA11êas das");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA11êas         das");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA11êêêêêêêêêêêêêas         das");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
    }

    @Test
    public void testCaseCheckUserNameContainDigit() {
        when(mUser.getUserName()).thenReturn("AAdasdasdas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA1dasdasdas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("AA11dasdasdas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getUserName()).thenReturn("AA111dasdasdas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("AA1112223111");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
        when(mUser.getUserName()).thenReturn("1112223111");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), false);
    }

    @Test
    public void testCaseCheckLengthPassword() {
        when(mUser.getUserName()).thenReturn("12ABsdsfwas");
        when(mUser.getPassword()).thenReturn("");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getUserName()).thenReturn("12AAsdswas");
        when(mUser.getPassword()).thenReturn("daA1HCA");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getUserName()).thenReturn("12ABsdswsas");
        assertEquals(UserValidation.isValidUserName(mUser.getUserName()), true);
        when(mUser.getPassword()).thenReturn("ASC1asd");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("ASC1asdg");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASC1asdga");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASC1asdasd");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASC1asdasdascfga");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
    }

    @Test
    public void testCaseCheckPasswordContainUserName() {
        when(mUser.getUserName()).thenReturn("15ABCsdfwas");
        when(mUser.getPassword()).thenReturn("");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("15ABCsdfwas");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("15ABCsdfwasdd");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("25ABCsdfwasdd");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("AHG12fawrxs");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
    }

    @Test
    public void testCaseCheckPasswordContainSpecialCharOrDigit() {
        when(mUser.getUserName()).thenReturn("15ABsdgwss");
        when(mUser.getPassword()).thenReturn("ASCasdscs");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("ASCasdscs1");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASCasdscs@");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASCasdscs@1");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASCasds cs@1");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
    }

    @Test
    public void testCaseCheckPasswordContainSpace() {
        when(mUser.getUserName()).thenReturn("15ABsdcgwss");
        when(mUser.getPassword()).thenReturn("UYCasdscs1@");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("UYCasd scs1@");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("UYCasd   scs1@");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
    }

    @Test
    public void testCaseCheckPasswordContainRepeatMoreThanTwoTime() {
        when(mUser.getUserName()).thenReturn("15ABsdgscgwss");
        when(mUser.getPassword()).thenReturn("UYC1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("UYC1@asfcc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("UYC1@asfccc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("UYC1@asfcccc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("UYC1@asfccccccc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
    }

    @Test
    public void testCaseCheckPasswordContainUpperChar(){
        when(mUser.getUserName()).thenReturn("15ABsgcdgscgwss");
        when(mUser.getPassword()).thenReturn("asa1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("Asa1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("ASa1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), false);
        when(mUser.getPassword()).thenReturn("ASA1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASAC1@asfc");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
        when(mUser.getPassword()).thenReturn("ASAC1@ASFC");
        assertEquals(UserValidation.isValidPassWord(mUser.getUserName(), mUser.getPassword()), true);
    }

    @Test
    public void testCaseCheckUserValid(){
        when(mUser.getUserName()).thenReturn("");
        assertEquals(UserValidation.valid(mUser),UserValidation.USER_NAME_LOG);
        when(mUser.getUserName()).thenReturn("15sggwss");
        assertEquals(UserValidation.valid(mUser),UserValidation.USER_NAME_LOG);
        when(mUser.getUserName()).thenReturn("15ABsggxwss");
        when(mUser.getPassword()).thenReturn("");
        assertEquals(UserValidation.valid(mUser),UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABssgwss");
        when(mUser.getPassword()).thenReturn("asc");
        assertEquals(UserValidation.valid(mUser),UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsgggwss");
        when(mUser.getPassword()).thenReturn("asc1akfg");
        assertEquals(UserValidation.valid(mUser),UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsgggwss");
        when(mUser.getPassword()).thenReturn("asc1akfgAA");
        assertEquals(UserValidation.valid(mUser),UserValidation.PASSWORD_LOG);
        when(mUser.getUserName()).thenReturn("15ABsxxlgwss");
        when(mUser.getPassword()).thenReturn("asc1akfgCVA");
        assertEquals(UserValidation.valid(mUser),UserValidation.STATUS_OK);
    }
}
