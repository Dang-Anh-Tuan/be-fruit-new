package tvnh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tvnh.entity.Odor;
import tvnh.repo.OdorRepo;
import tvnh.service.OdorService;

@Service
public class OdorServiceImpl  implements OdorService{


	@Autowired
	private OdorRepo repo;
	
	@Override
	public List<Odor> getAll() {
		return repo.findAll();
	}

	@Override
	public Odor getById(Integer id) {
		Optional<Odor> result = repo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
