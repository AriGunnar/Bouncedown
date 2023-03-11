package vidmots.bouncedown;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.HashMap;

public class BouncingController {

    @FXML
    Label  Stig; //stig
    @FXML
    private Leikbord LeikbordPane;    // leiksvæðið

    private Timeline t; // Tímalína fyrir Animation á leiknum

    public static final int INTERVAL = 100;



    public void initialize(){
        hefjaLeik();
        System.out.println("hafið");
    }
    public static final String VILTU_HALDA_AFRAM = ": Viltu halda áfram?";
    private static final int MAXPLATFORM= 5;// Hvað geta generatast mörg platform
    private static HashMap<KeyCode,Stefna> keyCodes = new HashMap<>();
    public void orvatakkar(){
        keyCodes.put(KeyCode.DOWN,Stefna.NIDUR);
        keyCodes.put(KeyCode.LEFT,Stefna.VINSTRI);
        keyCodes.put(KeyCode.RIGHT,Stefna.HEAGRI);
        Stig.getScene().addEventFilter(KeyEvent.KEY_PRESSED,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    try {
                        LeikbordPane.getFxBolti().breytaStyle();
                        this.setStefna(keyCodes.get(event.getCode()));
                        // flettum upp horninu fyrir KeyCode í map
                    } catch (NullPointerException e) {
                        event.consume();        // Ef rangur lykill er sleginn inn þá höldum við áfram
                    }
                });
        Stig.getScene().addEventFilter(KeyEvent.KEY_RELEASED,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    try {
                        LeikbordPane.getFxBolti().clearStefna(keyCodes.get(event.getCode()));
                        // flettum upp horninu fyrir KeyCode í map
                    } catch (NullPointerException e) {
                        event.consume();        // Ef rangur lykill er sleginn inn þá höldum við áfram
                    }
                });
    }
    public void setStefna(Stefna stefna) {
        LeikbordPane.getFxBolti().setStefna(stefna);
    }

    public void hefjaLeik() {
        //Timeline til að stjórna uppfærslum á leik

        // uppfærslur í milli sek
        KeyFrame frame = new KeyFrame(Duration.millis(INTERVAL),
                event -> {
                    LeikbordPane.getFxBolti().breytaStyle();
                   LeikbordPane.aframPallar();
                   LeikbordPane.nidurBolti();
                   Bolti.afram();
                   // LeikbordPane.heakkaStigin();

            // uppfærsla leikjar hér
        });
        t = new Timeline(frame);
        t.setCycleCount(Timeline.INDEFINITE);
        // game loop
        t.play();
    }
}




