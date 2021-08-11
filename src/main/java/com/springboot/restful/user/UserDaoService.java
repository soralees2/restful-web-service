package com.springboot.restful.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	// static으로 만들어져있는 변수이기 때문에 static 블록에 users의 초기값을 설정할 수 있음
	static {
		users.add(new User(1, "Kenneth", new Date()));
		users.add(new User(2, "Alice", new Date()));
		users.add(new User(3, "John", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
