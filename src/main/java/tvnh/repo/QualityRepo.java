package tvnh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Quality;


@Repository
public interface QualityRepo extends JpaRepository<Quality, Integer>{

}
