package tvnh.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Case {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_fruit", referencedColumnName = "id")
	private Fruit fruit;
	
	@ManyToOne
	@JoinColumn(name = "id_size", referencedColumnName = "id")
	private Size size;
	
	@ManyToOne
	@JoinColumn(name = "id_weight", referencedColumnName = "id")
	private Weight weight;
	
	@ManyToOne
	@JoinColumn(name = "id_color", referencedColumnName = "id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "id_odor", referencedColumnName = "id")
	private Odor odor;
	
	@ManyToOne
	@JoinColumn(name = "id_quality", referencedColumnName = "id")
	private Quality quality;

}