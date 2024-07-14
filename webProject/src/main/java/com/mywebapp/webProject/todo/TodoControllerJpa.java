package com.mywebapp.webProject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")  
public class TodoControllerJpa {

	
	private TodoRepository todoRepository;



	public TodoControllerJpa( TodoRepository todoRepository) {
		super();
				this.todoRepository = todoRepository;
	}
	
	

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model){
		String username =getLoggedInUsername(model);
		List<Todo> todos=todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (String)model.get("name");
	}
	
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String username= getLoggedInUsername(model);
		Todo todo= new Todo(0,username,"",LocalDate.now().plusYears(0),false);
		model.put("todo",todo);   // samename as model atrbt where dscrptn binding
		return "addtodo" ;
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addtodo";
		}
		String username= getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
	//	todoservice.addTodo(username, todo.getDescription(), LocalDate.now().plusMonths(7), false);
		
		return "redirect:list-todos";       //redirect to above listall todos method	
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoRepository.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String updatePage(@RequestParam int id,ModelMap model){
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updatetodo(ModelMap model,@Valid Todo todo, BindingResult result) { //vlid used for chk rqrd in css
		if(result.hasErrors()) {
			return "addtodo";
		}
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	
	
	
}
