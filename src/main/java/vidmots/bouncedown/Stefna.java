package vidmots.bouncedown;

public enum Stefna {
    VINSTRI(180),
    HEAGRI(0),
    NIDUR(270);
    private final int gradur;
    Stefna(int s) {
        gradur = s;
    }
    public int getGradur() {
        return gradur;
    }

}
