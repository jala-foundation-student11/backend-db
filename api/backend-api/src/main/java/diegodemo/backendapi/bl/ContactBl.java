package diegodemo.backendapi.bl;

import diegodemo.backendapi.dao.dao.CnContact;
import diegodemo.backendapi.dao.dao.CnRelation;
import diegodemo.backendapi.dao.repository.CnContactRepository;
import diegodemo.backendapi.dao.repository.CnRelationRepository;
import diegodemo.backendapi.dto.ContactRelationRequestDto;
import diegodemo.backendapi.dto.ContactRequestDto;
import diegodemo.backendapi.dto.ContactResponseDto;
import diegodemo.backendapi.dto.GenericResponseDto;
import diegodemo.backendapi.util.DaoToDtoMapperUtil;
import diegodemo.backendapi.util.DateUtil;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactBl {

    private Logger LOGGER = LoggerFactory.getLogger(ContactBl.class);
    private DateUtil dateUtil;
    private CnContactRepository cnContactRepository;
    private DaoToDtoMapperUtil daoToDtoMapperUtil;
    private CnRelationRepository cnRelationRepository;

    @Autowired
    public ContactBl(DateUtil dateUtil, CnContactRepository cnContactRepository, DaoToDtoMapperUtil daoToDtoMapperUtil, CnRelationRepository cnRelationRepository) {
        this.dateUtil = dateUtil;
        this.cnContactRepository = cnContactRepository;
        this.daoToDtoMapperUtil = daoToDtoMapperUtil;
        this.cnRelationRepository = cnRelationRepository;
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

    public ContactResponseDto getContactByUserId(Integer contactId, String username) throws ParseException {

        Optional<CnContact> foundContact = cnContactRepository.findById(contactId);
        if (foundContact.isEmpty()) {
            String message = "User with id" + contactId + " not found";
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

    public List<ContactResponseDto> getContactList(String code, String value) throws ParseException {

        List<CnContact> foundList;
        switch (code) {
            case "all":
                foundList = cnContactRepository.findAll();
                return daoToDtoMapperUtil.mapCnContactToDto(foundList.stream()).collect(Collectors.toList());
            case "dateOfBirth":
                String[] splitted = value.split(";");
                LOGGER.info("Spliited: " + splitted[0] + " " + splitted[1]);
                foundList = cnContactRepository.findByDateOfBirthBetween(
                        dateUtil.parseStringToDate(splitted[0]),
                        dateUtil.parseStringToDate(splitted[1])
                );
                return daoToDtoMapperUtil.mapCnContactToDto(foundList.stream()).collect(Collectors.toList());
            default:
                String msg = "Code " + code + " does not exist.";
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);

        }
    }

    public GenericResponseDto updateContactByContactId(Integer contactId, String username, ContactRequestDto contactRequestDto) throws ParseException {

        Optional<CnContact> foundContact = cnContactRepository.findById(contactId);
        if (foundContact.isEmpty()) {
            String message = "User with id" + contactId + " not found";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        } else {
            CnContact retrievedContact = foundContact.get();
            retrievedContact.setFirstName(contactRequestDto.getFirstName());
            retrievedContact.setLastName(contactRequestDto.getLastName());
            retrievedContact.setUserName(contactRequestDto.getUsername());
            retrievedContact.setEmail(contactRequestDto.getEmail());
            retrievedContact.setDateOfBirth(dateUtil.parseStringToDate(contactRequestDto.getDateOfBirth()));
            retrievedContact.setSeed(contactRequestDto.getSeed());
            cnContactRepository.saveAndFlush(retrievedContact);
            return new GenericResponseDto("200", "Contact updated successfully");
        }
    }

    public GenericResponseDto createContactRelation(ContactRelationRequestDto contactRelationRequestDto, String username) throws ParseException {

        CnContact requestContact = cnContactRepository.findByUserName(username);
        CnContact relationContact = cnContactRepository.findByUserName(contactRelationRequestDto.getContactUsername());
        if (requestContact == null || relationContact == null) {
            String msg = "The provided users were not found";
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
        }
        CnRelation relationDao = cnRelationRepository.findCnRelationByUsernames(requestContact.getUserName(), relationContact.getUserName());
        if (relationDao == null) {
            relationDao = new CnRelation();
            relationDao.setContactId(new CnContact(relationContact.getContactId()));
            relationDao.setUserId(new CnContact(requestContact.getContactId()));
        }
        relationDao.setAcquaintanceDate(dateUtil.parseStringToDate(contactRelationRequestDto.getAcquaintanceDate()));
        relationDao.setRelation(contactRelationRequestDto.getRelation());
        relationDao.setStatus((short) 1);

        cnRelationRepository.saveAndFlush(relationDao);
        return new GenericResponseDto("201", "Contact created successfully");
    }
}
