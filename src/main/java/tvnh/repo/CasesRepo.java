package tvnh.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Cases;
import tvnh.entity.Fruit;


@Repository
public interface CasesRepo extends JpaRepository<Cases, Integer>{
	List<Cases> findByFruit(Fruit fruit);
}
