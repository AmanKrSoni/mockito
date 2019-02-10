package com.cvt.business;

import com.cvt.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectionTest {
    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    //Argument Captor
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodoRelatedToSpring_usingBDDMock() throws Exception {

        //given
        List<String> todos= Arrays.asList("Learn spring MVC","Learn spring","Learn To Dance");

        given(todoServiceMock.retriveTodo("Dummy")).willReturn(todos); //when and then ..

        System.out.println(todoServiceMock.retriveTodo("Dummy"));



        //when
        List<String> filterd=todoBusiness.retrieveTodoRelatedToSpring("Dummy");

        //then
        assertThat(filterd.size(),is(2));
    }




    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retriveTodo("Ranga")).thenReturn(allTodos);

        todoBusiness.deleteTodosNotRelatedToSpring("Ranga");
        verify(todoServiceMock).deleteTodo(stringArgumentCaptor.capture());

        System.out.println(stringArgumentCaptor.getValue());
        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }
}
