package tvnh.service;

import java.util.List;

import tvnh.entity.Quality;

public interface QualityService {
	List<Quality> getAll();
	
	Quality getById(Integer id);
}
