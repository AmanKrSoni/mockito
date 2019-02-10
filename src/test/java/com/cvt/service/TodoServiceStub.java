package com.cvt.service;

import java.util.Arrays;
import java.util.List;

//Stub is the dummy implementation of the interface services

//Stub Dis -> Dynamic Condition , Service Condition
public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retriveTodo(String user) {
        return Arrays.asList("Learn spring MVC","Learn spring","Learn To Dance");
    }

    @Override
    public void deleteTodo(String todo) {

    }

}
