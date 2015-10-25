package datasource;
import java.util.ArrayList;

/**
 @author Christopher Pink
 @project Kiyomi
 */
public class Train {
    private final ArrayList<Double> AND = new ArrayList<>();
    private final ArrayList<Double> NAND = new ArrayList<>();
    private final ArrayList<Double> OR = new ArrayList<>();
    private final ArrayList<Double> NOR = new ArrayList<>();
    private final ArrayList<Double> XOR = new ArrayList<>();
    private final ArrayList<Double> XNOR = new ArrayList<>();
    private final ArrayList<Double> NOT = new ArrayList<>();
    private final ArrayList<Double> LONG = new ArrayList<>();
    public Train() {
        AND.add(-1.0);
        AND.add(-1.0);
        AND.add(-1.0);
        AND.add(1.0);
        NAND.add(1.0);
        NAND.add(1.0);
        NAND.add(1.0);
        NAND.add(-1.0);
        OR.add(-1.0);
        OR.add(1.0);
        OR.add(1.0);
        OR.add(1.0);
        NOR.add(1.0);
        NOR.add(-1.0);
        NOR.add(-1.0);
        NOR.add(-1.0);
        XOR.add(-1.0);
        XOR.add(+1.0);
        XOR.add(+1.0);
        XOR.add(-1.0);
        XNOR.add(1.0);
        XNOR.add(-1.0);
        XNOR.add(-1.0);
        XNOR.add(1.0);
        NOT.add(1.0);
        NOT.add(-1.0);
        NOT.add(1.0);
        NOT.add(-1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
        LONG.add(1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
        LONG.add(-1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
        LONG.add(-1.0);
        LONG.add(-1.0);
        LONG.add(-1.0);
        LONG.add(1.0);
    }
    public ArrayList<Double> getAND() {
        return AND;
    }
    public ArrayList<Double> getNAND() {
        return NAND;
    }
    public ArrayList<Double> getOR() {
        return OR;
    }
    public ArrayList<Double> getNOR() {
        return NOR;
    }
    public ArrayList<Double> getXOR() {
        return XOR;
    }
    public ArrayList<Double> getXNOR() {
        return XNOR;
    }
    public ArrayList<Double> getNOT() {
        return NOT;
    }
    public ArrayList<Double> getLONG() {
        return LONG;
    }
}
