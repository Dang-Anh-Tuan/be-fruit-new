package tvnh.service;

import java.util.List;

import tvnh.dto.CaseTest;
import tvnh.entity.Cases;
import tvnh.entity.Quality;

public interface GuessQualityService {
	Quality guessQuality(Cases c);
	
	void checkTestCase(List<CaseTest> listCaseTest);
}

