package tvnh.dto;

import java.util.List;

import lombok.Data;
import tvnh.entity.Color;
import tvnh.entity.Fruit;
import tvnh.entity.Odor;
import tvnh.entity.Quality;
import tvnh.entity.Size;
import tvnh.entity.Weight;

@Data
public class InfoFormCaseDTO {
	private List<Fruit> fruit;
	private List<Size> size;
	private List<Weight> weight;
	private List<Color> color;
	private List<Odor> odor;
	private List<Quality> quality;
}
