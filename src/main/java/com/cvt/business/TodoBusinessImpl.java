package com.cvt.business;

import com.cvt.service.TodoService;

import java.util.ArrayList;
import java.util.List;

//TodoBusinessImpl SUT
//TodoService dependency
public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    public List<String> retrieveTodoRelatedToSpring(String user){
        List<String> todos =todoService.retriveTodo(user);
        List<String> filterdTodo =new ArrayList<>();

        for(String todo : todos){
            if(todo.contains("spring"))
                filterdTodo.add(todo);
        }

        return filterdTodo;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retriveTodo(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
