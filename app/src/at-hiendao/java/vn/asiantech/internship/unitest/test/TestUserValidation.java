package vn.asiantech.internship.unitest.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import vn.asiantech.internship.unitest.UserValidation;

@RunWith(MockitoJUnitRunner.class)
public class TestUserValidation {
    @Mock
    UserValidation mUserValidation;

    @Test
    public void test()
    {
        mUserValidation = new UserValidation("123","123");
        Assert.assertEquals(mUserValidation.numOfUpperChar(mUserValidation.getUserName()),0);
    }

}
