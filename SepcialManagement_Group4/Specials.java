import java.io.*;
import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Specials {
    private static ArrayList<Special> specialList = new ArrayList<>();

    public static ArrayList<Special> getList() {
        return specialList;
    }

    public Specials(String inputFile) throws FileNotFoundException, IOException, Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            String[] info = line.split("\\|");
            Special newSpecial = new Special();
            newSpecial.setSpecialID(Integer.parseInt(info[0]));
            newSpecial.setDealerWebID(info[1]);
            newSpecial.setSpecialTitle(info[2]);
            if (info[3] == null || info[3].equals("")) {
                newSpecial.setDiscountPercentage(Double.parseDouble(info[4]));
            } else {
                newSpecial.setDiscountValue(Double.parseDouble(info[3]));
            }
            newSpecial.setSpecialStartDate(info[5]);
            newSpecial.setSpecialEndDate(info[6]);
            newSpecial.setCarYear(info[7]);
            newSpecial.setCarMake(info[8]);
            newSpecial.setCarModel(info[9]);
            newSpecial.setTrim(info[10]);
            newSpecial.setCarMinPrice(info[11]);
            newSpecial.setCarMaxPrice(info[12]);
            specialList.add(newSpecial);
        }
      reader.close();
    }

    public Specials() {

    }

    public static void addSpeical(Special special) {
        special.setSpecialID(specialList.size() + 1);
        specialList.add(special);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Special s: specialList) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

}
