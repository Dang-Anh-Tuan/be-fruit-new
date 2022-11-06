package tvnh.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Fruit getById(Integer id) {
		Optional<Fruit> result = repo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
