    package vidmots.bouncedown;

    import javafx.scene.image.ImageView;

    public class Bolti extends ImageView implements Leikhlutur {

        private static final double Hratt = 10;
        private static final double Hradi = Hratt;

        private boolean vinstri;
        private boolean heagri;

        private Stefna stefna;
        private Pallur pallur;
        public Bolti(){
            FXML_Lestur.lesa(this, "bolti-view.fxml");
            //setLayoutX(getImage().getWidth()/2);
            //System.out.println(" center " + getBoundsInParent().getCenterX());
           //System.out.println(" breidd " + getImage().getWidth());

        }


        public void setStefna(Stefna stefna) {;
            switch (stefna){
                case VINSTRI:
                    vinstri = true;
                    breytaStyle();
                    break;
                case HEAGRI:
                    heagri = true;
                    breytaStyle();
                    break;
            }

        }

        public void clearStefna(Stefna stefna) {
            switch (stefna){
                case VINSTRI:
                    vinstri = false;
                    breytaStyle();
                    break;
                case HEAGRI:
                    heagri = false;
                    breytaStyle();
                    break;
            }
        }

        public void breytaStyle(){
            getStyleClass().removeAll();
            setTranslateY(getTranslateY()+5);
            if(heagri != vinstri){
                getStyleClass().add("RullaStyle");
                if (heagri==true) {
                    setTranslateX(getTranslateX()+Hradi);
                }
                else
                    setTranslateX(getTranslateX()-Hradi);

            } else {
                getStyleClass().removeAll("RullaStyle");
                getStyleClass().add("StandaStyle");

            }
        }

        public void afram() {
            System.out.println("afram");
            if(heagri != vinstri){
                if(heagri)
                {
                    setTranslateX(getTranslateX()+Hradi);
                } else{
                    setTranslateX(getTranslateX()-Hradi);
                }
            }
        }
    }
