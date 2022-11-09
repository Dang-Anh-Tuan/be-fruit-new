package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.dto.UserDTO;
import tvnh.entity.User;
import tvnh.service.UserService;


@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
public class Authen {

	
	@Autowired
	private UserService userService;

	
	@PostMapping("/login")
	public User login(@RequestBody UserDTO user) {
		User result = userService.getByUserName(user.getUsernameU());

		if(result == null) {
			return null;
		}
		
		if(result.getPassword().equals(user.getPasswordU())) {
			return result;
		}
		
		
		return null;
	}
	
	@PostMapping("/register" )
	public Boolean register(@RequestBody UserDTO user) {
		User result = userService.getByUserName(user.getUsernameU());
		if(result != null) return false;
		User newUser = new User();
		newUser.setPassword(user.getPasswordU());
		newUser.setUsername(user.getUsernameU());
		newUser.setRole("user");
		userService.insert(newUser);
		
		return true;
	}
}
