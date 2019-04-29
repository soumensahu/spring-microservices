package com.example.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	private static List<User> users=new ArrayList<User>();
	private static int userCount=3;
	static {
		users.add(new User(1, "Adam", new Date("13/06/1993")));
		users.add(new User(2, "Eve", new Date("13/07/1993")));
		users.add(new User(3, "Jack", new Date("13/08/1993")));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User getUserById(Integer id) {
		//User foundUser=null;
	
		User foundUser=users.stream().filter(usr -> usr.getId()==id).findFirst().get();
		
		System.out.println(foundUser);
		return foundUser;
	}
	
	
	public void deleteUserById(Integer id) {
		//User foundUser=null;
		boolean result= users.removeIf(usr-> usr.getId()==id);
		if(!result)
			throw new UserNotFoundException("user id : "+id+" not found");
	}
}
