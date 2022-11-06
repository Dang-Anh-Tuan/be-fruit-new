package tvnh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Case;
import tvnh.repo.CaseRepo;
import tvnh.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService{
	@Autowired
	private CaseRepo repo;

	@Override
	public Boolean create(Case c) {
		Case result = repo.save(c);
		if(result != null) {
			return true;
		}
		return false;
	}
	
	
}
