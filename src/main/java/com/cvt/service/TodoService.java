package com.cvt.service;

import java.util.List;

public interface TodoService {
    List<String> retriveTodo(String user);
    void deleteTodo(String todo);
}
