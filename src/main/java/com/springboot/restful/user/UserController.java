package com.springboot.restful.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;

//	public UserController(UserDaoService service) {
//		this.service = service;
//	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	// GET /users/1 or /users/10 --> 상세조회할 유저의 id값
	@GetMapping("/users/{id}")
	// 서버에서 받아온 값이 기본타입이 string인데 int로 선언해주면 자동으로 int형으로 매핑됨.
	public User retrieveUser(@PathVariable int id) { 
		return service.findOne(id);
	}
	
	
	@PostMapping("/users")
	// Put이나 Post메서드 방식에서 클라이언트 form-data의 data Type이 json이나 object일 경우 
	// 이 타입을 받으려면 매개변수에 @RequestBody를 붙여준다.
	public ResponseEntity<User> createUser(@RequestBody User user) { // 전달받는 데이타 형식은 requestbody의 형태로 처리한다라고 명시
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
