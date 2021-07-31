package diegodemo.backendapi.util;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateUtil {

    public Date parseStringToDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }
}
