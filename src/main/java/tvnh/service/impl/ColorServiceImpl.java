package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Color;
import tvnh.repo.ColorRepo;
import tvnh.service.ColorService;

@Service
public class ColorServiceImpl  implements ColorService{


	@Autowired
	private ColorRepo repo;
	
	@Override
	public List<Color> getAll() {
		return repo.findAll();
	}

}
