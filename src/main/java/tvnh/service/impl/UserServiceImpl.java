package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.User;
import tvnh.repo.UserRepo;
import tvnh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public User getByUserName(String username) {
		List<User> users = repo.findByUsername(username);
		if (users.size() > 0)
			return repo.findByUsername(username).get(0);
		return null;
	}

	@Override
	public void insert(User user) {
		repo.save(user);
	}

}
