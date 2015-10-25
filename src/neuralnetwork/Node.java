package neuralnetwork;
import java.io.Serializable;
import java.util.ArrayList;
import utilities.Sigmoid;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Node implements Serializable {
    private final ArrayList<ArrayList> nodeLayer = new ArrayList<>();
    private final String nodeName;
    ////////////////////////////////////////////////////////////////////////////
    // Variable Depth Node Constructor
    ////////////////////////////////////////////////////////////////////////////
    public Node(String nodeName, int[] layers) {
        this.nodeName = nodeName;
        for (int layer = 0; layer < 1; layer++) {
            ArrayList<Neuron> input = new ArrayList<>();
            for (int layerSize = 0; layerSize < layers[layer]; layerSize++) {
                input.add(new Neuron());
            }
            nodeLayer.add(input);
        }
        for (int layer = 1; layer < layers.length; layer++) {
            ArrayList<Neuron> input = new ArrayList<>();
            for (int layerSize = 0; layerSize < layers[layer]; layerSize++) {
                input.add(new Neuron(nodeLayer.get(layer - 1)));
            }
            nodeLayer.add(input);
        }
    }
    public String getName() {
        return this.nodeName;
    }
    public ArrayList<Double> getNode(ArrayList<Double> nodeInput) {
        ArrayList<Double> output = new ArrayList<>();
        ArrayList<Neuron> input;
        for (int i = 0; i < nodeInput.size() / nodeLayer.get(0).size(); i++) {
            // INPUT LAYER
            input = nodeLayer.get(0);
            for (int j = 0; j < nodeLayer.get(0).size(); j++) {
                input.get(j).setOutput(nodeInput.get(i * nodeLayer.get(0).size() + j));
            }
            // HIDDEN LAYER(S)
            for (int layer = 1; layer < (nodeLayer.size() - 1); layer++) {
                input = nodeLayer.get(layer);
                for (Neuron neuron : input) {
                    neuron.getResult();
                }
            }
            // OUTPUT LAYER
            input = nodeLayer.get(nodeLayer.size() - 1);
            for (Neuron neuron : input) {
                output.add(neuron.getResult());
            }
        }
        return output;
    }
    public ArrayList<Double> trainNode(ArrayList<Double> nodeInput, ArrayList<Double> nodeTrain, int epochs) {
        // Using Sigmoid Spike for learn Rate to minimize the chances of Local 
        // Minima by starting with a small Learn Rate and increasing the size to
        // a maximum at the epoch half way point then reducing the learn rate 
        // to a minimum which will prevent oscillation at convergence.
        Sigmoid sig = new Sigmoid();
        double[] learnRate = sig.getSigmoidSpike(epochs);
        ArrayList<Neuron> layer;
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < nodeInput.size() / nodeLayer.get(0).size(); i++) {
                layer = nodeLayer.get(0);
                int k = 0;
                for (Neuron neuron : layer) {
                    neuron.setOutput(nodeInput.get(i * layer.size() + k));
                    k++;
                }
                for (int index = 1; index < nodeLayer.size(); index++) {
                    layer = nodeLayer.get(index);
                    for (Neuron neuron : layer) {
                        neuron.getResult();
                    }
                }
                layer = nodeLayer.get(nodeLayer.size() - 1);
                k = 0;
                for (Neuron neuron : layer) {
                    neuron.setError(neuron.getOutput() - nodeTrain.get(i * layer.size() + k));
                    k++;
                }
                for (int index = (nodeLayer.size() - 1); index > 0; index--) {
                    layer = nodeLayer.get(index);
                    for (Neuron neuron : layer) {
                        neuron.adjustNeuron(learnRate[epoch]);
                    }
                }
            }
        }
        return getNode(nodeInput);
    }
}
