package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Fruit;
import tvnh.service.FruitService;

@RestController
@RequestMapping(path = "/api/fruit", produces = "application/json")
@CrossOrigin(origins = "*")
public class FruitController {

	
	@Autowired
	private FruitService fruitService;
	
	@GetMapping
	public List<Fruit> getAll(){
		return fruitService.getAll();
	}
}
