package tvnh.service;

import tvnh.entity.User;

public interface UserService {
	User getByUserName(String username);
	
	void insert(User user);
}
