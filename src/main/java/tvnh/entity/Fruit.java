package tvnh.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Fruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	 @OneToMany(mappedBy = "fruit")
	 @JsonIgnore
	 private List<Cases> cases = new ArrayList<>();
}