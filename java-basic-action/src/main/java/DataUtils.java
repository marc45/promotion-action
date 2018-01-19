import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>();


    public static void main(String[] args) {

        System.out.println(df.get().format(new Date()));


    }


}
