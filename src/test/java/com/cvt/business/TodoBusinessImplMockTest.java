package com.cvt.business;

import com.cvt.service.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;

//what is mocking
//
public class TodoBusinessImplMockTest {
    TodoService todoServiceMock= mock(TodoService.class);

    @Test
    public void testRetrieveTodoRelatedToSpring_usingMock() throws Exception {


        List<String> todos= Arrays.asList("Learn spring MVC","Learn spring","Learn To Dance");

        when(todoServiceMock.retriveTodo("Dummy")).thenReturn(todos); //when and then ..

        System.out.println(todoServiceMock.retriveTodo("Dummy"));

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);

        List<String> filterd=todoBusiness.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(2,filterd.size());
    }

    @Test
    public void testRetrieveTodoRelatedToSpring_withEmptyList() throws Exception {


        List<String> todos= Arrays.asList();

        when(todoServiceMock.retriveTodo("Dummy")).thenReturn(todos); //when and then ..

        System.out.println(todoServiceMock.retriveTodo("Dummy"));

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);

        List<String> filterd=todoBusiness.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(0,filterd.size());
    }

    //MOCKITO -BDD
    @Test
    public void testRetrieveTodoRelatedToSpring_usingBDDMock() throws Exception {

        //given
        List<String> todos= Arrays.asList("Learn spring MVC","Learn spring","Learn To Dance");

        given(todoServiceMock.retriveTodo("Dummy")).willReturn(todos); //when and then ..

        System.out.println(todoServiceMock.retriveTodo("Dummy"));

        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);


        //when
        List<String> filterd=todoBusiness.retrieveTodoRelatedToSpring("Dummy");

        //then
        assertThat(filterd.size(),is(2));
    }
}
