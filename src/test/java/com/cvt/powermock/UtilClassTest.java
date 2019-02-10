package com.cvt.powermock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import static org.powermock.api.mockito.PowerMockito.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilClass.class})
public class UtilClassTest {



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStaticMethod() throws Exception {
        mockStatic(UtilClass.class);
        String name="AMAN";

        PowerMockito.when(UtilClass.getToUpperCase(Mockito.anyString())).thenReturn("SUCCESS");
        System.out.println(UtilClass.getToUpperCase("aman"));
        Assert.assertTrue(UtilClass.getToUpperCase("aman").equals("SUCCESS"));





    }

    @Test
    public void testPrivateMethodWithParameter() throws Exception {

        UtilClass utilClass=spy(new UtilClass());

        doReturn("success").when(utilClass,"getToLowerCase",Mockito.any(String.class));

        String s=utilClass.lower("AMAN");
        System.out.println(s);

       PowerMockito.verifyPrivate(utilClass).invoke("getToLowerCase", "AMAN");

    }

    @Test
    public void testFinalMethodWithVoid() throws Exception {
        UtilClass utilClass=mock(UtilClass.class);

        doNothing().when(utilClass).get(Mockito.anyString());
        utilClass.get("AMAN");
        Mockito.verify(utilClass,Mockito.times(1)).get(Mockito.anyString());
    }
}