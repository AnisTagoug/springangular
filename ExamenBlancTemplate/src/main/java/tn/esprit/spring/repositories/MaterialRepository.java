package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Material;

@Repository

public interface MaterialRepository extends JpaRepository<Material,Long> {
}
