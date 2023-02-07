package helper;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class FormatHelper {

    public static DefaultFormatterFactory generateFomatter(MaskFormatter formatter){
        return new DefaultFormatterFactory(formatter);
    }

    public static String generateMatricula(){
        return String.valueOf((int) (Math.random() * 100000));
    }

}
