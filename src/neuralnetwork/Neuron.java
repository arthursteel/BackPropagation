package neuralnetwork;
import java.io.Serializable;
import utilities.TanH;
import java.util.ArrayList;
import utilities.Random;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Neuron implements Serializable {
    private ArrayList<Neuron> inputNeuron = new ArrayList<>();
    private ArrayList<Double> inputWeight = new ArrayList<>();
    private double error;
    private double output;
    private double bias = 1.0;
    private final double LEARNRATE = 0.25;
    private Random rand = new Random();
    public Neuron() {
        this.error = 0.0;
        this.output = rand.getRandomDouble(-1, 1);
        this.bias = rand.getRandomDouble(-1, 1);
    }
    public Neuron(ArrayList<Neuron> inputLayer) {
        this.error = 0.0;
        this.output = rand.getRandomDouble(-1, 1);
        inputLayer.stream().map((neuron) -> {
            this.inputNeuron.add(neuron);
            return neuron;
        }).forEach((_item) -> {
            this.inputWeight.add(rand.getRandomDouble(-1, +1));
        });
        this.bias = rand.getRandomDouble(-1, 1);
    }
    public void addLayer(ArrayList<Neuron> inputLayer) {
        inputLayer.stream().map((neuron) -> {
            this.inputNeuron.add(neuron);
            return neuron;
        }).forEach((_item) -> {
            this.inputWeight.add(1.0);
        });
    }
    public void linkNeuron(Neuron neuron) {
        this.inputNeuron.add(neuron);
        this.inputWeight.add(rand.getRandomDouble(-1, +1));
    }
    public double getResult() {
        double result = 0.0;
        Neuron neuron;
        TanH tanh = new TanH();
        for (int index = 0; index < inputNeuron.size(); index++) {
            neuron = inputNeuron.get(index);
            result += (neuron.getOutput() * inputWeight.get(index));
        }
        this.output = tanh.getTanH(result + bias);
        return this.output;
    }
    public void adjustNeuron() {
        adjustNeuron(LEARNRATE);
    }
    public void adjustNeuron(double learnRate) {
        for (int i = 0; i < inputNeuron.size(); i++) {
            Neuron neuron = inputNeuron.get(i);
            neuron.setError(inputWeight.get(i) * this.error);
            inputWeight.set(i, (inputWeight.get(i)) - (1 - (this.output * this.output)) * (this.error * learnRate) * (neuron.getOutput()));
            if (inputWeight.get(i) > 5.0) {
                inputWeight.set(i, 5.0);
            } else if (inputWeight.get(i) < -5.0) {
                inputWeight.set(i, -5.0);
            }
        }
        bias -= (1 - (this.output * this.output)) * (learnRate * this.error) * (1.0);
        if (bias > 5.0) {
            bias = 5.0;
        } else if (bias < -5.0) {
            bias = -5.0;
        }
        this.error = 0.0;
    }
    public void setOutput(double output) {
        this.output = output;
    }
    public double getOutput() {
        return this.output;
    }
    public void setError(double error) {
        this.error += error;
    }
    public double getError() {
        return this.error;
    }
}
