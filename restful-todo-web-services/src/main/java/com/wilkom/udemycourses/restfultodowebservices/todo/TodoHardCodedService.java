package com.wilkom.udemycourses.restfultodowebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {

	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "will", "Learn to Dance", new Date(), true));
		todos.add(new Todo(++idCounter, "will", "Take a breack 1", new Date(), false));
		todos.add(new Todo(++idCounter, "will", "Learn React", new Date(), false));
		todos.add(new Todo(++idCounter, "will", "Take a break 2", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todos.remove(todo)) {
			return null;
		} else
			return todo;
	}

	public Todo findById(long id) {
		for (Todo t : todos) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	public Todo save(Todo todo) {
		if (todo.getId() <= 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			this.deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
