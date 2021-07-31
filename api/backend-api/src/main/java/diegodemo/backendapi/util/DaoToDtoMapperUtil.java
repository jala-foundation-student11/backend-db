package diegodemo.backendapi.util;

import diegodemo.backendapi.dao.dao.CnContact;
import diegodemo.backendapi.dto.ContactResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.stream.Stream;

@Service
public class DaoToDtoMapperUtil {
    private DateUtil dateUtil;

    @Autowired
    public DaoToDtoMapperUtil(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }


    public Stream<ContactResponseDto> mapCnContactToDto(Stream<CnContact> stream) {
        return stream.map(
                it -> {
                    try {
                        return new ContactResponseDto(
                                it.getContactId(),
                                it.getFirstName(),
                                it.getLastName(),
                                it.getUserName(),
                                it.getEmail(),
                                dateUtil.parseDateToString(it.getDateOfBirth()),
                                it.getSeed());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        );
    }
}
