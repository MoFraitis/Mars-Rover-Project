package InputLayer;

import LogicLayer.CompassDirection;
import LogicLayer.Position;

import java.util.InputMismatchException;

public class PositionParser {

    public static Position parseInput(String input) {
        String inputWhiteSpacesRemoved = input.replaceAll(" ", "").toUpperCase();

        if(inputWhiteSpacesRemoved.matches("^\\d{2}[NESW]$") && inputWhiteSpacesRemoved.length() == 3){
            String[] positionArray = inputWhiteSpacesRemoved.split("");
            int x = Integer.parseInt(positionArray[0]);
            int y = Integer.parseInt(positionArray[1]);
            CompassDirection facing = CompassDirection.valueOf(positionArray[2]);

            return new Position(x, y, facing);
        } else {
            throw new InputMismatchException("Position must only contain an x and y co-ordinate and a compass direction (N,E,S or W)");
        }
    }
}
