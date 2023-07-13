package com.example.APItest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    TodaDAO todaDAO;
    @PostMapping("/todos")
    @ResponseBody
    public String addNewTodo(@RequestBody Todo todo){
        todaDAO.save(todo);
        return "ok";
    }

    @GetMapping("/todos")
    @ResponseBody
    public Iterable<Todo> getAllTodoList(){
        return todaDAO.findAll();
    }
    @GetMapping("/todos/{id}")
    @ResponseBody
    public Todo getTodoById(@PathVariable("id")Integer id){
        return todaDAO.findById(id).get();
    }

    @PutMapping("todos/{id}")
    @ResponseBody
    public Todo updateTodoElement(@PathVariable("id")Integer id, @RequestBody Todo todo){
        //citesc din tabela intrarearea pe care o actualizez
        Todo todoExist=todaDAO.findById(id).get();
        //actualizez obiectul de mai sus cu ceea ce primesc de pe request
        todoExist.setDescriere(todo.getDescriere());
        todoExist.setCumparat(todo.isCumparat());
        //salvez obiectul cu noile valori in tabela
        todaDAO.save(todoExist);
        return todoExist;
    }

    @DeleteMapping("todos/{id}")
    @ResponseBody
    public void deleteTodoElement(@PathVariable("id")Integer id){
        todaDAO.deleteById(id);
    }
}
