package tvnh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Size;


@Repository
public interface SizeRepo extends JpaRepository<Size, Integer>{

}
