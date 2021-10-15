package com.d1.QuickToDO.controller;

import com.d1.QuickToDO.entity.Todo;
import com.d1.QuickToDO.entity.User;
import com.d1.QuickToDO.repository.TodoRepository;
import com.d1.QuickToDO.repository.UserRepository;
import com.d1.QuickToDO.request.AddTodoRequest;
import com.d1.QuickToDO.request.AddUserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

   private UserRepository userRepository;
    private TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping
    public User addUser(@RequestBody AddUserRequest userRequest) {
User user = new User();
user.setUsername(userRequest.getUname());
user.setPassword(userRequest.getPword());

        return userRepository.save(user);
    }


    @PostMapping("/{userId}/todos")
    public void addTodo (@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        todoRepository.save(todo);
userRepository.save(user);
    }


    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    @DeleteMapping("todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todoRepository.delete(todo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }
}
