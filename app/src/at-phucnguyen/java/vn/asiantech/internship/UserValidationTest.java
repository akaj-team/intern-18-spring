/*
 * Nguyen Van Phuc
 */
package vn.asiantech.internship;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.model.UserLoginTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationTest extends UserValidation {

    @Mock
    private UserLoginTest mUserLoginTest;

    @Test
    public void testIsExistSpecialChar() {
        when(mUserLoginTest.getUserName()).thenReturn("NguyenVanPh&uc");
        Assert.assertTrue(isExistSpecialChar(mUserLoginTest.getUserName()));
        when(mUserLoginTest.getUserName()).thenReturn("NguyenVanPhuc");
        Assert.assertFalse(isExistSpecialChar(mUserLoginTest.getUserName()));
    }

    @Test
    public void testCheckLengthPassWork() {
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyen");
        Assert.assertTrue(checkLengthPassWork(mUserLoginTest.getPassWork()));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNgu");
        Assert.assertFalse(checkLengthPassWork(mUserLoginTest.getPassWork()));
    }

    @Test
    public void testIsExistNumbOrIsExistSpecialChar() {
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyen100497");
        Assert.assertTrue(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassWork()));
        when(mUserLoginTest.getPassWork()).thenReturn("@PhucNguyen");
        Assert.assertTrue(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassWork()));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan");
        Assert.assertFalse(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassWork()));
    }

    @Test
    public void testIsLimitedNReplaceChar() {
        int n=3;
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenuu");
        Assert.assertTrue(isLimitedNReplaceChar(mUserLoginTest.getPassWork(), n));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan");
        Assert.assertFalse(isLimitedNReplaceChar(mUserLoginTest.getPassWork(), n));
    }

    @Test
    public void testIsExistWhiteSpace() {
        when(mUserLoginTest.getPassWork()).thenReturn("PhucN guyenu");
        Assert.assertTrue(isExistWhiteSpace(mUserLoginTest.getPassWork()));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan");
        Assert.assertFalse(isExistWhiteSpace(mUserLoginTest.getPassWork()));
    }

    @Test
    public void testCountLengthString() {
        int n = 7;
        int m = 14;
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan");
        Assert.assertTrue(countLengthString(mUserLoginTest.getPassWork(), n, m));
        when(mUserLoginTest.getPassWork()).thenReturn("Phuc");
        Assert.assertFalse(countLengthString(mUserLoginTest.getPassWork(), n, m));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVanPhucNguyenVanPhuc");
        Assert.assertFalse(countLengthString(mUserLoginTest.getPassWork(), n, m));
    }

    @Test
    public void testLimitTwoNumber() {
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenu12");
        Assert.assertTrue(limitTwoNumber(mUserLoginTest.getPassWork()));
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan123");
        Assert.assertFalse(limitTwoNumber(mUserLoginTest.getPassWork()));
    }

    @Test
    public void testRequiredNUpperCaseChar() {
        int n = 3;
        when(mUserLoginTest.getPassWork()).thenReturn("PhucNguyenVan");
        Assert.assertTrue(requiredNUpperCaseChar(mUserLoginTest.getPassWork(), n));
        when(mUserLoginTest.getPassWork()).thenReturn("Phucnguyenvan");
        Assert.assertFalse(requiredNUpperCaseChar(mUserLoginTest.getPassWork(), n));
    }
}
