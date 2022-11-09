package tvnh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tvnh.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	List<User> findByUsername(String username);
}