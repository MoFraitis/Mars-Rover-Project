package LogicLayer;

public class Plateau {
    private final PlateauSize plateauSize;

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public boolean isWithinPlateauSize(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x <= plateauSize.getX() && y >= 0 && y <= plateauSize.getY();
    }
}
