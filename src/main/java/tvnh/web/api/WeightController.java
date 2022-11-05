package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Weight;
import tvnh.service.WeightService;


@RestController
@RequestMapping(path = "/api/weight", produces = "application/json")
@CrossOrigin(origins = "*")
public class WeightController {

	
	@Autowired
	private WeightService weightService;
	
	@GetMapping
	public List<Weight> getAll(){
		return weightService.getAll();
	}
}

