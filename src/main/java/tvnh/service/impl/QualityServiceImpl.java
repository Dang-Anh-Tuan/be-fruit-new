package tvnh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Quality;
import tvnh.repo.QualityRepo;
import tvnh.service.QualityService;

@Service
public class QualityServiceImpl  implements QualityService{


	@Autowired
	private QualityRepo repo;
	
	@Override
	public List<Quality> getAll() {
		return repo.findAll();
	}

	@Override
	public Quality getById(Integer id) {
		Optional<Quality> result = repo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
