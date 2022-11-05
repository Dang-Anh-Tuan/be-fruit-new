package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Fruit;
import tvnh.repo.FruitRepo;
import tvnh.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {

	@Autowired
	private FruitRepo repo;
	
	@Override
	public List<Fruit> getAll() {
		return repo.findAll();
	}

}
