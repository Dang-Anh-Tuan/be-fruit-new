package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Cases;
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

}
