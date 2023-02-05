package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date stringToDate(String date) throws ParseException {
       return dateFormat.parse(date);
    }

}
