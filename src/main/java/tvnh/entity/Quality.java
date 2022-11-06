package tvnh.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Quality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	
	@OneToMany(mappedBy = "quality")
	 @JsonIgnore
	 private List<Cases> cases = new ArrayList<>();
}