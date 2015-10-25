package utilities;
/**
 @author Christopher Pink
 @project Kiyomi
 */
public class TanH {
    public TanH() {
    }
    public double getTanH(double tanh) {
        if (tanh > 20) {
            return 1.0;
        } else if (tanh < -20) {
            return -1.0;
        } else {
            double a = Math.exp(tanh);
            double b = Math.exp(-tanh);
            return (a - b) / (a + b);
        }
    }
}
