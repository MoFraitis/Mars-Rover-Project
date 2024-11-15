package InputLayer;

import LogicLayer.CompassDirection;
import LogicLayer.Position;

public class PositionParser {

    public static Position parseInput(String input) {
        String[] positionArray = input.split("");
        int x = Integer.parseInt(positionArray[0]);
        int y = Integer.parseInt(positionArray[1]);
        CompassDirection facing = CompassDirection.valueOf(positionArray[3]);

        return new Position(x, y, facing);
    }
}
