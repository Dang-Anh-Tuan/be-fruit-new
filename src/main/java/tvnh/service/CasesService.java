package tvnh.service;

import java.util.List;

import tvnh.entity.Cases;

public interface CasesService {
	List<Cases> getAll();

	Boolean create(Cases c);
}
