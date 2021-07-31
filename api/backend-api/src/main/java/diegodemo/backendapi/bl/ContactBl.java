package diegodemo.backendapi.bl;

import diegodemo.backendapi.dao.dao.CnContact;
import diegodemo.backendapi.dao.repository.CnContactRepository;
import diegodemo.backendapi.dto.ContactRequestDto;
import diegodemo.backendapi.dto.ContactResponseDto;
import diegodemo.backendapi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.Optional;

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

    public ContactResponseDto getContactByUserId(Integer contactUserId, String username) throws ParseException {

        Optional<CnContact> foundContact = cnContactRepository.findById(contactUserId);
        if (foundContact.isEmpty()) {
            String message = "User with id" + contactUserId + " not found";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        } else {
            ContactResponseDto contactResponseDto = new ContactResponseDto();
            CnContact retrievedContact = foundContact.get();
            contactResponseDto.setContactId(retrievedContact.getContactId());
            contactResponseDto.setFirstName(retrievedContact.getFirstName());
            contactResponseDto.setLastName(retrievedContact.getLastName());
            contactResponseDto.setUsername(retrievedContact.getUserName());
            contactResponseDto.setEmail(retrievedContact.getEmail());
            contactResponseDto.setDateOfBirth(dateUtil.parseDateToString(retrievedContact.getDateOfBirth()));
            contactResponseDto.setSeed(retrievedContact.getSeed());
            return contactResponseDto;
        }
    }
}