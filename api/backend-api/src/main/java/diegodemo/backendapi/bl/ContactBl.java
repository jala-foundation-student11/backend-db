package diegodemo.backendapi.bl;

import diegodemo.backendapi.dao.dao.CnContact;
import diegodemo.backendapi.dao.repository.CnContactRepository;
import diegodemo.backendapi.dto.ContactRequestDto;
import diegodemo.backendapi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ContactBl {

    private DateUtil dateUtil;
    private CnContactRepository cnContactRepository;
    @Autowired
    public ContactBl(DateUtil dateUtil, CnContactRepository cnContactRepository) {
        this.dateUtil = dateUtil;
        this.cnContactRepository = cnContactRepository;
    }

    public String createContact(ContactRequestDto contactRequestDto, String username) throws ParseException {

        CnContact insertDao = new CnContact();
        insertDao.setFirstName(contactRequestDto.getFirstName());
        insertDao.setLastName(contactRequestDto.getLastName());
        insertDao.setUserName(contactRequestDto.getUsername());
        insertDao.setEmail(contactRequestDto.getEmail());
        insertDao.setDateOfBirth(dateUtil.parseStringToDate(contactRequestDto.getDateOfBirth()));
        insertDao.setSeed(contactRequestDto.getSeed());
        cnContactRepository.saveAndFlush(insertDao);
        return "Contact created successfully";
    }
}
