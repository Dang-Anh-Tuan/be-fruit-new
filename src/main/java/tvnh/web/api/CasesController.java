package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Cases;
import tvnh.service.CasesService;


@RestController
@RequestMapping(path = "/api/cases", produces = "application/json")
@CrossOrigin(origins = "*")
public class CasesController {

	
	@Autowired
	private CasesService casesService;
	
	@GetMapping
	public List<Cases> getAll(){
		return casesService.getAll();
	}
}
