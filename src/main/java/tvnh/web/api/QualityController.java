package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Quality;
import tvnh.service.QualityService;



@RestController
@RequestMapping(path = "/api/quality", produces = "application/json")
@CrossOrigin(origins = "*")
public class QualityController {

	
	@Autowired
	private QualityService qualityService;
	
	@GetMapping
	public List<Quality> getAll(){
		return qualityService.getAll();
	}
}

