package com.cvt.business;

import com.cvt.service.TodoService;
import com.cvt.service.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {

    TodoService todoServiceStub=new TodoServiceStub();
    TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceStub);

    @Test
    public void testRetrieveTodoRelatedToSpring_usingStub() throws Exception {
        List<String> filterd=todoBusiness.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(2,filterd.size());
    }




}