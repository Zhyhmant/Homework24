package timeservice;

import org.springframework.stereotype.Controller;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class XmlTimeController {

    public String getMinskTime() {
        return getTime("Europe/Minsk");
    }

    public String getWashingtonTime() {
        return getTime("America/New_York");
    }

    public String getBeijingTime() {
        return getTime("Asia/Shanghai");
    }

    private String getTime(String zone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zone));
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
    }
}