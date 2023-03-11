package vinnsla;

import javafx.beans.property.IntegerProperty;

public class Leikur {
    private int hradi;
    private String nofn;
    private IntegerProperty stig;
    public IntegerProperty stiginProperty(){
        return stig;
    }
    public void heakkaStigin(){
        stig.set(stig.get() + 1);
    }

}
