package Repository;

import Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
