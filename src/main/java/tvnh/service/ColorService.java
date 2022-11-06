package tvnh.service;

import java.util.List;

import tvnh.entity.Color;

public interface ColorService {
	List<Color> getAll();
	
	Color getByID(Integer id);
}
