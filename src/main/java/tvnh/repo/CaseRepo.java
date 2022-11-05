package tvnh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvnh.entity.Case;


@Repository
public interface CaseRepo extends JpaRepository<Case, Integer>{

}
