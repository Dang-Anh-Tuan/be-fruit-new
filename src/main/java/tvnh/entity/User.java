package tvnh.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 45)
	private String username;

	@Column(nullable = false, length = 64)
	private String password;

	private String role;
}
