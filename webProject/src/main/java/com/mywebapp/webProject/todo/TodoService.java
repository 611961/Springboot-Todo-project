package com.mywebapp.webProject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo>todos = new ArrayList<>();
	private static int todosid=1;
	
	static {
		todos.add(new Todo(todosid++,"nitin","learn aws 1",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(todosid++,"sunidhi","learn physics 1",LocalDate.now().plusMonths(6),false));
	}
	
	public List<Todo> findByusername(String username){
		Predicate<? super Todo> predicate =todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo( String username, String description, LocalDate date, boolean done) {
		Todo todo = new Todo(todosid++,username,description,date,done);
		todos.add(todo);
	}
	
	public void deletebyId(int id) {
		// todo.getId=id;
		//lambda fnctn  todo->todo.getId=id;
		Predicate<? super Todo> predicate 	=todo->todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public Todo findbyId(int id) {
		// todo.getId=id;
		//lambda fnctn  todo->todo.getId=id;
		Predicate<? super Todo> predicate =todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get(); 
		return todo;
	}

	public void updateDone(@Valid Todo todo) {
		deletebyId(todo.getId());
		todos.add(todo);
		
	}
}
