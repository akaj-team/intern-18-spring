package internship;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.UserValidation;
import vn.asiantech.internship.model.UserLoginTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationTest extends UserValidation {

    @Mock
    private UserLoginTest mUserLoginTest;

    @Test
    public void testCheckUseName() {
        when(mUserLoginTest.getUserName()).thenReturn("VanV");
        Assert.assertEquals(checkUserName(mUserLoginTest.getUserName()), ERROR_1);
        when(mUserLoginTest.getUserName()).thenReturn("vanphucnguyen");
        Assert.assertEquals(checkUserName(mUserLoginTest.getUserName()), ERROR_2);
        when(mUserLoginTest.getUserName()).thenReturn("VanPhuc%Nguyen");
        Assert.assertEquals(checkUserName(mUserLoginTest.getUserName()), ERROR_3);
        when(mUserLoginTest.getUserName()).thenReturn("VanPhucNguyen0497");
        Assert.assertEquals(checkUserName(mUserLoginTest.getUserName()), ERROR_4);
        when(mUserLoginTest.getUserName()).thenReturn("VanPhucNguyen97");
        Assert.assertEquals(checkUserName(mUserLoginTest.getUserName()), CHECKPASS);
    }

    @Test
    public void testCheckPassword() {
        String useName = "PhucPhucPhuc";
        when(mUserLoginTest.getUserName()).thenReturn("NguyenNguyenNguyen");
        when(mUserLoginTest.getPassword()).thenReturn("NguyenNguyenNguyen");
        Assert.assertEquals(checkPassword(mUserLoginTest.getUserName(), mUserLoginTest.getPassword()), ERROR_1);
        when(mUserLoginTest.getPassword()).thenReturn("vanphucvanphuc");
        Assert.assertEquals(checkPassword(useName, mUserLoginTest.getPassword()), ERROR_2);
        when(mUserLoginTest.getPassword()).thenReturn("qwertyuiopppp97");
        Assert.assertEquals(checkPassword(useName, mUserLoginTest.getPassword()), ERROR_3);
        when(mUserLoginTest.getPassword()).thenReturn("qwerty@as dfg97");
        Assert.assertEquals(checkPassword(useName, mUserLoginTest.getPassword()), ERROR_4);
        when(mUserLoginTest.getPassword()).thenReturn("qwertyuiop97");
        Assert.assertEquals(checkPassword(useName, mUserLoginTest.getPassword()), ERROR_5);
        when(mUserLoginTest.getPassword()).thenReturn("VanPhucNguyen97");
        Assert.assertEquals(checkPassword(useName, mUserLoginTest.getPassword()), CHECKPASS);
    }

    @Test
    public void testIsExistSpecialChar() {
        when(mUserLoginTest.getUserName()).thenReturn("NguyenVanPh&uc");
        Assert.assertTrue(isExistSpecialChar(mUserLoginTest.getUserName()));
        when(mUserLoginTest.getUserName()).thenReturn("NguyenVanPhuc");
        Assert.assertFalse(isExistSpecialChar(mUserLoginTest.getUserName()));
    }

    @Test
    public void testCheckLengthPassword() {
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyen");
        Assert.assertTrue(checkLengthPassWork(mUserLoginTest.getPassword()));
        when(mUserLoginTest.getPassword()).thenReturn("PhucNgu");
        Assert.assertFalse(checkLengthPassWork(mUserLoginTest.getPassword()));
    }

    @Test
    public void testIsExistNumbOrIsExistSpecialChar() {
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyen100497");
        Assert.assertTrue(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassword()));
        when(mUserLoginTest.getPassword()).thenReturn("@PhucNguyen");
        Assert.assertTrue(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassword()));
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyenVann");
        Assert.assertFalse(isExistNumbOrIsExistSpecialChar(mUserLoginTest.getPassword()));
    }

    @Test
    public void testIsLimitedNReplaceChar() {
        int n = 3;
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyenuu");
        Assert.assertTrue(isLimitedNReplaceChar(mUserLoginTest.getPassword(), n));
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyentVan");
        Assert.assertFalse(isLimitedNReplaceChar(mUserLoginTest.getPassword(), n));
    }

    @Test
    public void testIsExistWhiteSpace() {
        when(mUserLoginTest.getPassword()).thenReturn("PhucN guyenu");
        Assert.assertTrue(isExistWhiteSpace(mUserLoginTest.getPassword()));
        when(mUserLoginTest.getPassword()).thenReturn("PhuckNguyenVan");
        Assert.assertFalse(isExistWhiteSpace(mUserLoginTest.getPassword()));
    }

    @Test
    public void testCountLengthString() {
        int n = 7;
        int m = 14;
        when(mUserLoginTest.getPassword()).thenReturn("PhucfNguyenVan");
        Assert.assertTrue(countLengthString(mUserLoginTest.getPassword(), n, m));
        when(mUserLoginTest.getPassword()).thenReturn("Phuc");
        Assert.assertFalse(countLengthString(mUserLoginTest.getPassword(), n, m));
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyenVanPhucNguyenVanPhuc");
        Assert.assertFalse(countLengthString(mUserLoginTest.getPassword(), n, m));
    }

    @Test
    public void testLimitTwoNumber() {
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyenu12");
        Assert.assertTrue(limitTwoNumber(mUserLoginTest.getPassword()));
        when(mUserLoginTest.getPassword()).thenReturn("PhucNguyenVan123");
        Assert.assertFalse(limitTwoNumber(mUserLoginTest.getPassword()));
    }

    @Test
    public void testRequiredNUpperCaseChar() {
        int n = 3;
        when(mUserLoginTest.getPassword()).thenReturn("PhucNyguyenVan");
        Assert.assertTrue(requiredNUpperCaseChar(mUserLoginTest.getPassword(), n));
        when(mUserLoginTest.getPassword()).thenReturn("Phucnguqyenvan");
        Assert.assertFalse(requiredNUpperCaseChar(mUserLoginTest.getPassword(), n));
    }
}
