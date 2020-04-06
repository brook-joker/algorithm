package interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JMain {

    private static final long DAY = 24 * 60 * 60 * 1000;

    private static void printX(String data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date next = format.parse(data);
            Date cur = format.parse("2019-10-1");
            long value = cur.getTime() - next.getTime();
            if (value <= 0) {
                System.out.println("国庆节快乐");
            } else {
                int n = (int) (value / DAY);
                if (n == 1) {
                    System.out.println("明天是国庆节");
                } else if (n == 2) {
                    System.out.println("后天是国庆节");
                } else {
                    System.out.println("距离国庆节还有" + n + "天");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String data = "";
        System.out.println(startWithBlankAndLF(data));
    }

    public static boolean startWithBlankAndLF(String source) {
        if (source.startsWith(" ")) {
            return source.replace(" ", "").startsWith("\n");
        }
        return source.startsWith("\n");
    }
}


