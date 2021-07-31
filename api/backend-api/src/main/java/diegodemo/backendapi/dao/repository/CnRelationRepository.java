package diegodemo.backendapi.dao.repository;

import diegodemo.backendapi.dao.dao.CnRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CnRelationRepository extends JpaRepository<CnRelation, Integer> {
    @Query("SELECT cr FROM CnRelation cr WHERE cr.userId.userName = :requestUser AND cr.contactId.userName = :contactUser")
    public CnRelation findCnRelationByUsernames(String requestUser, String contactUser);
}
