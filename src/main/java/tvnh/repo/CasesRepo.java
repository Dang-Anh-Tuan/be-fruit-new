package tvnh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Cases;


@Repository
public interface CasesRepo extends JpaRepository<Cases, Integer>{

}
