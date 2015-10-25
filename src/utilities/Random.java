package utilities;
/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Random {
    public Random() {
    }
    public Double getRandomDouble(int min, int max) {
        return min + (Math.random() * (max - min));
    }
    public int getRandomInteger(int min, int max) {
        Double doubleNumber = min + (Math.random() * (max - min));
        return doubleNumber.intValue();
    }
}
