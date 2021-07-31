package diegodemo.backendapi.dao.repository;

import diegodemo.backendapi.dao.dao.CnContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CnContactRepository extends JpaRepository<CnContact, Integer> {
}
