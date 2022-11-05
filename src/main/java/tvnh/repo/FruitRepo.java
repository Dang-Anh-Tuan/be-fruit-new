package tvnh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Fruit;

@Repository
public interface FruitRepo extends JpaRepository<Fruit, Integer>{

}
