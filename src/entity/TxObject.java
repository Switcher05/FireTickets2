package entity;

/**
 * Created by Ryan on 11/23/2015.
 */
public class TxObject {
    private int bin;
    private double value;
    private int type;

    public TxObject(int bin, double value, int type) {
        this.bin = bin;
        this.value = value;
        this.type = type;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
