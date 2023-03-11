package vidmots.bouncedown;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class Leikbord extends Pane {

    @FXML
    Bolti fxBolti;

    private boolean vinstri;
    private boolean heagri;

    @FXML
    private Pallur P1,P2,P3,P4,P5;
    public Leikbord() {
        FXML_Lestur.lesa(this,"leikbord-view.fxml");
        pallar.addAll(P1,P2,P3,P4,P5);

    }

    private ObservableList <Pallur> pallar = FXCollections.observableArrayList();
    public Bolti getFxBolti() {
        return fxBolti;
    }

    public void  aframPallar(){
        for (Pallur p: pallar ) {
            p.afram();
        }
        }
    boolean erBoltiALifi(){

        return true;
    }
    public void nidurBolti(){
        getFxBolti().setTranslateY(getTranslateY()+5);
    }


    public void heakkaStigin() {

    }
}


