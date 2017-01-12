import javax.swing.text.MutableAttributeSet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by xiaozhang on 17-1-12.
 */
public class RandomPvUv {

    public static void main(String[] args) {
       while (true){
           createDate();
       }

    }


    public static  void  createDate(){


        String cookieId[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        String regionId[] = {"G01", "G05", "G04", "G03", "G02"};
        String osId[] = {"Android 5.0", "Mac OS", "Window 7"};
        String tempDate = null;
        String cookieIdTemp = "";
        String regionTemp = null;
        String cityTemp = null;
        String sidTemp = null;
        String osTemp = null;
        String pvTemp = null;


        // create dataTemp
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 31);
            if (x == 0) {
                tempDate = "2016-07-01";
            } else if (x < 10) {
                tempDate = "2016-07-0" + x;
            } else {
                tempDate = "2016-07-" + x;
            }

        }

        System.out.println(tempDate);
        //create cookieIdTemp
        for (int i = 0; i < 18; i++) {
            int j = (int) (Math.random() * 35);
            cookieIdTemp += cookieId[j];
        }
        System.out.println(cookieIdTemp);


        int k = (int) (Math.random() * 4);
        regionTemp = regionId[k];

        int l = (int) (Math.random() * 2) + 1;
        cityTemp = regionTemp + "0" + l;
        System.out.println(cityTemp);

        Random random = new Random();

        int m = (int) Math.floor(random.nextDouble() * 10000.0);

        sidTemp = "" + m;
        System.out.println(sidTemp);

        int n = (int) (Math.random() * 2);
        osTemp = osId[n];
        System.out.println(osTemp);

        int h = (int) (Math.random() * 9) + 1;

        pvTemp = "" + h;

        System.out.println(pvTemp);


        String data = cookieIdTemp + "|" + regionTemp + "|" + cityTemp + "|" + sidTemp + "|" + osTemp + "|" + pvTemp +"|"+tempDate + "\n";
        cookieIdTemp = "";

        File file = new File("fact_data.txt");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file.getName(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
