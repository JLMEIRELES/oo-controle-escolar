package helper;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class FormatHelper {

    public static DefaultFormatterFactory generateFomatter(MaskFormatter formatter){
        return new DefaultFormatterFactory(formatter);
    }

    public static String generateMatriculaStudent(){
        return String.valueOf((int) (Math.random() * 100000));
    }

    public static String generateMatriculaTeacher(){
        return String.valueOf((int) (Math.random() * 10000));
    }


}
