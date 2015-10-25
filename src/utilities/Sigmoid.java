package utilities;
/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Sigmoid {
    public static double[] sigmoid = new double[200];
    public Sigmoid() {
        double point;
        for (int i = 0; i < sigmoid.length; i++) {
            point = i - (sigmoid.length / 2);
            // A = Overall Range of the Sigmoid Curve
            // B = Shift Bias (Slides Curve Horizontally)
            // C = Steepness of the curve
            // D = Curve Bias (Slides Curve Vertically)
            // (A / (1 + Math.exp (-1* ( B ) / C )) -D)
            sigmoid[i] = (1 / (1 + Math.exp(-1 * (point) / 15)) - 0);
        }
    }
    public double[] getSigmoidEpoch(int epoch) {
        double[] sig = new double[epoch];
        double point;
        for (int i = 0; i < epoch; i++) {
            point = i - (epoch / 2);
            // A = Overall Range of the Sigmoid Curve
            // B = Shift Bias (Slides Curve Horizontally)
            // C = Steepness of the curve
            // D = Curve Bias (Slides Curve Vertically)
            // (A / (1 + Math.exp (-1* ( B ) / C )) -D)
            sig[i] = (1 / (1 + Math.exp(-1 * (point) / 5)) - 0);
        }
        return sig;
    }
    public double[] getSigmoidSpike(int epoch) {
        double[] sig = new double[epoch];
        double point;
        int max = epoch / 2;
        for (int i = 0; i < epoch; i++) {
            point = i - (epoch / 2);
            // A = Overall Range of the Sigmoid Curve
            // B = Shift Bias (Slides Curve Horizontally)
            // C = Steepness of the curve
            // D = Curve Bias (Slides Curve Vertically)
            // (A / (1 + Math.exp (-1* ( B ) / C )) -D)
            sig[i] = (1 / (1 + Math.exp(-1 * (point) / (epoch / 4))) - 0);
        }
        for (int i = 0; i < max; i++) {
            sig[max + i] = sig[max - i];
        }
        return sig;
    }
    public double getSigmoid(double x) {
        if (x < 0) {
            x = 0;
        } else if (x > 199) {
            x = 199;
        }
        return sigmoid[(int) x];
    }
}
