package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.entity.Size;
import tvnh.service.SizeService;

@RestController
@RequestMapping(path = "/api/size", produces = "application/json")
@CrossOrigin(origins = "*")
public class SizeController {

	
	@Autowired
	private SizeService sizeService;
	
	@GetMapping
	public List<Size> getAll(){
		return sizeService.getAll();
	}
}
