package tvnh.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Cases {
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