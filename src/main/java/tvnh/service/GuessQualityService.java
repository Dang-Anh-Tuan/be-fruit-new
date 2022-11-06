package tvnh.service;

import tvnh.entity.Cases;
import tvnh.entity.Quality;

public interface GuessQualityService {
	Quality guessQuality(Cases c);
}
