package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Weight;
import tvnh.repo.WeightRepo;
import tvnh.service.WeightService;


@Service
public class WeightServiceImpl  implements WeightService{


	@Autowired
	private WeightRepo repo;
	
	@Override
	public List<Weight> getAll() {
		return repo.findAll();
	}

}
