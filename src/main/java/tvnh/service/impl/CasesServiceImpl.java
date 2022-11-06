package tvnh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Cases;
import tvnh.entity.Fruit;
import tvnh.repo.CasesRepo;
import tvnh.service.CasesService;


@Service
public class CasesServiceImpl  implements CasesService{


	@Autowired
	private CasesRepo repo;
	
	@Override
	public List<Cases> getAll() {
		return repo.findAll();
	}

	@Override
	public Boolean create(Cases c) {
		Cases result = repo.save(c);
		if(result != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Cases> getByFruit(Fruit fruit) {
		return repo.findByFruit(fruit);
	}
}
