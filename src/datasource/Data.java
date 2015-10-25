package datasource;
import java.util.ArrayList;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Data {
    private final ArrayList<Double> shortData = new ArrayList<>();
    private final ArrayList<Double> longData = new ArrayList<>();
    private final ArrayList<Double> notData = new ArrayList<>();
    public Data() {
        setShortData();
        setLongData();
        setNotData();
    }
    private void setLongData() {
        for (double h = 0; h < 2; h++) {
            for (double i = 0; i < 2; i++) {
                for (double j = 0; j < 2; j++) {
                    for (double k = 0; k < 2; k++) {
                        longData.add(h);
                        longData.add(i);
                        longData.add(j);
                        longData.add(k);
                    }
                }
            }
        }
    }
    private void setShortData() {
        shortData.add(0.0);
        shortData.add(0.0);
        shortData.add(0.0);
        shortData.add(+1.0);
        shortData.add(+1.0);
        shortData.add(0.0);
        shortData.add(+1.0);
        shortData.add(+1.0);
    }
    private void setNotData() {
        notData.add(-1.0);
        notData.add(+1.0);
    }
    public ArrayList<Double> getLongData() {
        return this.longData;
    }
    public ArrayList<Double> getShortData() {
        return this.shortData;
    }
    public ArrayList<Double> getNotData() {
        return this.notData;
    }
}
