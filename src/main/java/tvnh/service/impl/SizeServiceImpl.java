package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Size;
import tvnh.repo.SizeRepo;
import tvnh.service.SizeService;

@Service
public class SizeServiceImpl  implements SizeService{


	@Autowired
	private SizeRepo repo;
	
	@Override
	public List<Size> getAll() {
		return repo.findAll();
	}

}
