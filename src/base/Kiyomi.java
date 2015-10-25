package base;
import datasource.Data;
import datasource.Train;
import neuralnetwork.Node;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Kiyomi {
    public static void main(String[] args) {
        /* Quick Training Test */
        int[] layers = {2, 4, 1};
        // Each Node may have a virtually limitless combinations of neurons and
        // hidden layers.
        // The data/training short set provided only utilizes 2 inputs and 1 output
        // int[] layers = {2, 20, 30, 5, 1};
        // int[] layers = {2, 50, 50, 20, 10, 1};
        Data dataSet = new Data();
        Train trainingSet = new Train();
        Node node = new Node("TestNode", layers);
        // Train Data from 2-Bit Binary Set with Expected Outputs
        // Training sets Available .getAND() .getNAND() .getOR() .getNOR()
        // .getXOR() .getXNOR()
        // Larger number of epochs may be necessary depending on the size of the 
        // layers in the node. 
        node.trainNode(dataSet.getShortData(), trainingSet.getXNOR(), 500);
        // Confirm Trained Node with 2-Bit Binary set with Actual Outputs
        int dataCounter = 0;
        int trainCounter = 0;
        System.out.println("Node: " + node.getName());
        for (Double out : node.getNode(dataSet.getShortData())) {
            System.out.print(String.format("A: %.0f  ", dataSet.getShortData().get(dataCounter++)));
            System.out.print(String.format("B: %.0f              ", dataSet.getShortData().get(dataCounter++)));
            System.out.print(String.format("Expected: %.0f  ", trainingSet.getXNOR().get(trainCounter++)));
            System.out.print(String.format("Actual: %.0f\n", out));
        }
        System.out.println("");
        // Confirm Trained Node with 2-Bit Binary set with Actual Outputs
        dataCounter = 0;
        trainCounter = 0;
        System.out.println("Node: " + node.getName());
        for (Double out : node.getNode(dataSet.getShortData())) {
            System.out.print(String.format("A: %.0f  ", dataSet.getShortData().get(dataCounter++)));
            System.out.print(String.format("B: %.0f              ", dataSet.getShortData().get(dataCounter++)));
            System.out.print(String.format("Expected: %.0f  ", trainingSet.getXNOR().get(trainCounter++)));
            System.out.print(String.format("Actual: %.0f\n", out));
        }
        System.out.println("");
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        int[] layersLong = {4, 8, 4, 1};
        Node nodeLong = new Node("LongTestNode", layersLong);
        // Train Data from 4-Bit Binary Set with Expected Outputs
        // Training sets Available .getLONG()
        // Larger number of epochs may be necessary depending on the size of the 
        // layers in the node. 
        nodeLong.trainNode(dataSet.getLongData(), trainingSet.getLONG(), 500);
        // Confirm Trained Node with 4-Bit Binary set with Actual Outputs
        dataCounter = 0;
        trainCounter = 0;
        System.out.println("Node: " + nodeLong.getName());
        for (Double out : nodeLong.getNode(dataSet.getLongData())) {
            System.out.print(String.format("A: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("B: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("C: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("D: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("Expected: %.0f   ", trainingSet.getLONG().get(trainCounter++)));
            System.out.print(String.format("Actual: %.0f\n", out));
        }
        System.out.println("");
        // Confirm Trained Node with 4-Bit Binary set with Actual Outputs
        dataCounter = 0;
        trainCounter = 0;
        System.out.println("Node: " + nodeLong.getName());
        for (Double out : nodeLong.getNode(dataSet.getLongData())) {
            System.out.print(String.format("A: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("B: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("C: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("D: %.0f  ", dataSet.getLongData().get(dataCounter++)));
            System.out.print(String.format("Expected: %.0f   ", trainingSet.getLONG().get(trainCounter++)));
            System.out.print(String.format("Actual: %.0f\n", out));
        }
    }
}
