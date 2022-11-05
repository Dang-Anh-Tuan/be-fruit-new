package tvnh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Odor;



@Repository
public interface OdorRepo extends JpaRepository<Odor, Integer>{

}
