package br.com.springboot.usuariosApi.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.usuariosApi.Models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private List<User> users = new ArrayList<>();

	@GetMapping("/{id}")
	public User user(@PathVariable("id") Long id) {
	Optional<User> userFind =	users.stream().filter(user ->user.getId() == id ).findFirst();
	
	if(userFind.isPresent()) {
		return userFind.get();
	}
	return null;
	}
	
	@PostMapping("/")
	public User user(@RequestBody User user) {
		users.add(user);
		return user;
	}
	
	@GetMapping("/list")
	public List<User> list(){
		return users;
		
	}
	
	
	
}
