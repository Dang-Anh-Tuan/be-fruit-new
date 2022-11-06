package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.entity.Cases;
import tvnh.entity.Fruit;
import tvnh.entity.Quality;
import tvnh.logic.CBR;
import tvnh.service.CasesService;
import tvnh.service.GuessQualityService;

@Service
public class GuessQualityServiceImpl implements GuessQualityService {
	
	@Autowired
	CasesService casesService;
	
	@Override
	public Quality guessQuality(Cases c) {
		Fruit currentFruit = c.getFruit();
		List<Cases> cases = casesService.getByFruit(currentFruit);
		
		return CBR.logicCBR(cases, c);
		
	}

}
