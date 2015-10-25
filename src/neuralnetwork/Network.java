
package neuralnetwork;
import java.util.ArrayList;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Network {
    private final String networkName;
    private final ArrayList<Node> network = new ArrayList<>();
    public Network() {
        this("default");
    }
    public Network(String networkName) {
        this.networkName = networkName;
    }
    public void addNode(String nodeName, int[] layers) {
        this.network.add(new Node(nodeName, layers));
    }
    
    public void trainNode(String nodeName, ArrayList<Double> data, ArrayList<Double> train) {
        trainNode(nodeName, data, train, 200);
    }
    public ArrayList<Double> trainNode(String nodeName, ArrayList<Double> data, ArrayList<Double> train, int epochs) {
        for (Node node : network) {
            if (node.getName().equalsIgnoreCase(nodeName)) {
                return node.trainNode(data, train, epochs);
            }
        }
        return null;
    }
    public ArrayList<Double> getNode(String nodeName, ArrayList<Double> data) {
        for (Node node : network) {
            if (node.getName().equalsIgnoreCase(nodeName)) {
                return node.getNode(data);
            }
        }
        return null;
    }
    public String getNetworkName() {
        return networkName;
    }
}
