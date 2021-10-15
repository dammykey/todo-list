package com.d1.QuickToDO;

import com.d1.QuickToDO.entity.Todo;
import com.d1.QuickToDO.entity.User;
import com.d1.QuickToDO.repository.TodoRepository;
import com.d1.QuickToDO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickToDoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuickToDoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setPassword("should be hashed");
		user.setUsername("Drey");

		Todo todo = new Todo();

		todo.setContent("Hold a meeting with my Team");

		user.getTodoList().add(todo);

		todoRepository.save(todo);
		userRepository.save(user);
	}
}
