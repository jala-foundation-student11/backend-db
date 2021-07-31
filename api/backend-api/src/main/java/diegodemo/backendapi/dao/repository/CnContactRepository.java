package diegodemo.backendapi.dao.repository;

import diegodemo.backendapi.dao.dao.CnContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CnContactRepository extends JpaRepository<CnContact, Integer> {
    public List<CnContact> findByDateOfBirthBetween(Date lowerDate, Date upperDate);
    public List<CnContact> findByFirstNameIgnoreCaseContaining(String firstName);
    public List<CnContact> findByLastNameIgnoreCaseContaining(String lastName);
    public List<CnContact> findByUserNameIgnoreCaseContaining(String userName);
    public List<CnContact> findByEmailIgnoreCaseContaining(String email);
    public CnContact findByUserName(String userName);
}
