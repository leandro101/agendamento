package io.github.leandro101.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static LocalDateTime stringToLocaDateTime(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(data, formatter);
    }

    public static String localDateTimeToString(LocalDateTime data){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
