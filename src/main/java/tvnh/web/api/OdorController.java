package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Odor;
import tvnh.service.OdorService;

@RestController
@RequestMapping(path = "/api/odor", produces = "application/json")
@CrossOrigin(origins = "*")
public class OdorController {

	
	@Autowired
	private OdorService odorService;
	
	@GetMapping
	public List<Odor> getAll(){
		return odorService.getAll();
	}
}

