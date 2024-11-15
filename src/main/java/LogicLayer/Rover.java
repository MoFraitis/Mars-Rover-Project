package LogicLayer;

import java.util.List;

public class Rover {
    private final int id;
    private Position position;
    static int count = 0;

    public Rover(Position position) {
        this.position = position;
        this.id = Rover.count + 1;
        System.out.println("Rover created with id: " + this.id);
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void updatePosition(Position newPosition) {
        this.position = newPosition;
        System.out.println("new rover position: " + newPosition.getX() + " " + newPosition.getY() + " " + newPosition.getFacing());
    }


    public Position calcNextPosition(List<Instruction> instructions) {
        int newX = this.position.getX();
        int newY = this.position.getY();
        CompassDirection newFacing = this.position.getFacing();
        for (Instruction instruction : instructions) {
            if (instruction.equals(Instruction.M)) {
                switch (newFacing) {
                    case N -> newY++;
                    case E -> newX++;
                    case S -> newY--;
                    case W -> newX--;
                }
            } else if (instruction.equals(Instruction.R)) {
                switch (newFacing) {
                    case N -> newFacing = CompassDirection.E;
                    case E -> newFacing = CompassDirection.S;
                    case S -> newFacing = CompassDirection.W;
                    case W -> newFacing = CompassDirection.N;
                }
            } else if (instruction.equals(Instruction.L)) {
                switch (newFacing) {
                    case N -> newFacing = CompassDirection.W;
                    case E -> newFacing = CompassDirection.N;
                    case S -> newFacing = CompassDirection.E;
                    case W -> newFacing = CompassDirection.S;
                }
            }
//            System.out.println("x: " + newX + " y: " + newY + " direction: " + newFacing);
        }
        return new Position(newX, newY, newFacing);
    }
}
