package tvnh.service;

import java.util.List;

import tvnh.entity.Cases;
import tvnh.entity.Fruit;

public interface CasesService {
	List<Cases> getAll();

	Boolean create(Cases c);
	
	List<Cases> getByFruit(Fruit fruit);
}
