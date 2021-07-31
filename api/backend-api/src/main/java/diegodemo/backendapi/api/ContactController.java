package diegodemo.backendapi.api;

import diegodemo.backendapi.bl.ContactBl;
import diegodemo.backendapi.dto.ContactRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private ContactBl contactBl;
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
}

