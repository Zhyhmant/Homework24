package timeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/")
public class TimeController {

    @GetMapping("minsk")
    public String getMinskTime() {
        return getTime("Europe/Minsk");
    }

    @GetMapping("washington")
    public String getWashingtonTime() {
        return getTime("America/New_York");
    }

    @GetMapping("beijing")
    public String getBeijingTime() {
        return getTime("Asia/Shanghai");
    }

    private String getTime(String zone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zone));
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
    }
}