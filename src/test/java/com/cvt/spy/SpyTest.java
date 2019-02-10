package com.cvt.spy;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SpyTest {



    @Test
    public void test1() throws Exception {

        List listMock=mock(ArrayList.class);
        assertEquals(0,listMock.size());

        when(listMock.size()).thenReturn(5);
        verify(listMock).size();
        listMock.add("Aman");
        assertEquals(5,listMock.size());

    }

    @Test
    public void testSpy() throws Exception { //spy also called as partial mock
        List listSpy=spy(ArrayList.class);
        when(listSpy.size()).thenReturn(5);
        listSpy.add("Aman"); // Override the size() of arraylist does`t effect any changes in that methpd
        assertEquals(5,listSpy.size());
    }
}
