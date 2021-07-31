package diegodemo.backendapi.api;

import diegodemo.backendapi.bl.ContactBl;
import diegodemo.backendapi.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private ContactBl contactBl;
    private Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    public ContactController(ContactBl contactBl) {
        this.contactBl = contactBl;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createContact(@RequestBody ContactRequestDto contactRequestDto,
                                                @RequestHeader("x-username") String username) throws ParseException {
        try {
            String response = contactBl.createContact(contactRequestDto, username);
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }

    @RequestMapping(
            value = "/{contactId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ContactResponseDto> getContactByUserId(@RequestHeader("x-username") String username,
                                                                 @PathVariable("contactId") Integer contactId) throws ParseException {
        try {
            ContactResponseDto response = contactBl.getContactByUserId(contactId, username);
            return new ResponseEntity<ContactResponseDto>(response, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ContactResponseDto>> getContactList(@RequestHeader("x-username") String username,
                                                                   @RequestParam(value = "code", defaultValue = "all") String code,
                                                                   @RequestParam(value = "value", defaultValue = "all") String value) throws ParseException {
        try {
            List<ContactResponseDto> response = contactBl.getContactList(code, value);
            return new ResponseEntity<List<ContactResponseDto>>(response, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }

    @RequestMapping(
            value = "{contactId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GenericResponseDto> updateContactByContactId(
            @RequestBody ContactRequestDto contactRequestDto,
            @RequestHeader("x-username") String username,
            @PathVariable("contactId") Integer contactId) throws ParseException {
        try {
            GenericResponseDto response = contactBl.updateContactByContactId(contactId, username, contactRequestDto);
            return new ResponseEntity<GenericResponseDto>(response, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }

    @RequestMapping(
            value = "/relation",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GenericResponseDto> createContactRelation(@RequestBody ContactRelationRequestDto contactRelationRequestDto,
                                                                    @RequestHeader("x-username") String username) throws ParseException {
        try {
            GenericResponseDto response = contactBl.createContactRelation(contactRelationRequestDto, username);
            return new ResponseEntity<GenericResponseDto>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }

    @RequestMapping(
            value = "/relation/{relationId}",
            method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GenericResponseDto> updateAcquaintanceDate(@RequestBody PatchRelationRequestDto patchRelationRequestDto,
                                                                    @PathVariable("relationId") Integer relationId,
                                                                    @RequestHeader("x-username") String username) throws ParseException {
        try {
            GenericResponseDto response = contactBl.updateAcquaintanceDate(patchRelationRequestDto, relationId, username);
            return new ResponseEntity<GenericResponseDto>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw e;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    }
}

