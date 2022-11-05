package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Color;
import tvnh.service.ColorService;

@RestController
@RequestMapping(path = "/api/color", produces = "application/json")
@CrossOrigin(origins = "*")
public class ColorController {

	
	@Autowired
	private ColorService colorService;
	
	@GetMapping
	public List<Color> getAll(){
		return colorService.getAll();
	}
}

