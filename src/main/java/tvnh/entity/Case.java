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
	@JoinColumn(name = "idFruit", referencedColumnName = "id")
	private Fruit fruit;
	
	@ManyToOne
	@JoinColumn(name = "idSize", referencedColumnName = "id")
	private Size size;
	
	@ManyToOne
	@JoinColumn(name = "idWeight", referencedColumnName = "id")
	private Weight weight;
	
	@ManyToOne
	@JoinColumn(name = "idColor", referencedColumnName = "id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "idOdor", referencedColumnName = "id")
	private Odor odor;
	
	@ManyToOne
	@JoinColumn(name = "idQuality", referencedColumnName = "id")
	private Quality quality;

}