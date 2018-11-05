package pl.fakturomat.tools.converters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class DateConverters {
  public static Date convertToDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDate convertToLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
}
