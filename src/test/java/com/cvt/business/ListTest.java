package com.cvt.business;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;

public class ListTest {

    @Test
    public void testMockListSizeMethod() throws Exception {
        List list=mock(List.class);

        when(list.size()).thenReturn(2);

        assertEquals(2,list.size());
    }

    @Test
    public void testMockListSize_ReturnMultipleValue() throws Exception {
        List list=mock(List.class);

        when(list.size()).thenReturn(2).thenReturn(3);

        assertEquals(2,list.size());
        assertEquals(3,list.size());
    }

    @Test
    public void testMockListGetMethod() throws Exception {
        List list=mock(List.class);


        when(list.get(0)).thenReturn("Aman Kumar Soni");

        //Argument Matcher
        when(list.get(anyInt())).thenReturn("Aman Kumar Soni");

        assertEquals("Aman Kumar Soni",list.get(0));
        assertEquals("Aman Kumar Soni",list.get(1)); // defualt return null if not tell mock for some stub
    }

    @Test(expected = RuntimeException.class)
    public void testMockListGetMethod_ThrowException() throws Exception {
        List list=mock(List.class);

        //Argument Matcher
        when(list.get(anyInt())).thenThrow(new RuntimeException("Something went Wrong .."));
        list.get(0);

       }

       //mockito -BDD => Behaviour Driven Development
    /*@Test
    public void letsMockList_MixingUp() throws Exception {
        //GIVEN
        List list=mock(List.class);

        given(list.subList(anyInt(),5)).thenThrow(new RuntimeException());

        list.get(0);
    }*/


    //mockito -BDD => Behaviour Driven Development is a good way to implement test its a style
    @Test
    public void letsMockList_BDD() throws Exception {
        //Given
        List<String> list=mock(List.class);
        given(list.get(anyInt())).willReturn("Aman");

        //when
        String first=list.get(0);

        //then
        assertThat(first,is("Aman"));
    }
}
