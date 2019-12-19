package Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UpdateFpqqlsh {

    public static String letters64() {
        String fpqqlsh = "";
        for (int i = 0; i < 64; i++) {
            fpqqlsh = fpqqlsh + randGenerated();
        }
        return fpqqlsh;
    }

    public static String numbers64() {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }

    public static String numbersLetters() {
        Random r = new Random();
        int n = (int) (1 + Math.random() * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        String rs = "";
        for (int i = 0; i < 2; i++) {
            rs = rs + randGenerated();
        }

        return rs + n + date;

    }

    public static char randGenerated() {
        char[] A_z = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random r = new Random();
        int sub = r.nextInt(A_z.length);
        return A_z[sub];
    }

    public static void main(String[] args) {
        System.out.println(numbersLetters());
        System.out.println(letters64());
        System.out.println(numbers64());
    }
}
