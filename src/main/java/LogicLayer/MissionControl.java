package LogicLayer;

import java.util.ArrayList;
import java.util.List;

public class MissionControl {
    private List<Rover> roverList;
    private final Plateau plateau;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
        this.roverList = new ArrayList<>();
    }

    public void addRover(Rover rover) {
        if(plateau.isWithinPlateauSize(rover.getPosition())) {
            roverList.add(rover);
        } else {
            throw new IllegalArgumentException("Position outside of Plateau");
        }
    }

    public void moveRover(Rover rover, List<Instruction> instructions) {
        Position newPosition = rover.calcNextPosition(instructions);

        // check new position is empty -- create method --

        if(plateau.isWithinPlateauSize(newPosition)) {
            rover.updatePosition(newPosition);
        }

    }


}
