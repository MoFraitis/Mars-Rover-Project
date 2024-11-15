import InputLayer.InstructionParser;
import InputLayer.PlateauSizeParser;
import InputLayer.PositionParser;
import LogicLayer.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("type 'exit' to finish running the program");

        PlateauSize plateauSize = getPlateauSize(scanner);
        MissionControl missionControl = new MissionControl(new Plateau(plateauSize));

        Position roverPosition = getRoverPosition(scanner);
        Rover rover = new Rover(roverPosition);

        missionControl.addRover(rover); // need to handle exception of outside plateau (refactor?)

        while (true) {
            try {
                if (scanner.hasNext("exit")) break;
                List<Instruction> instructions = getInstructions(scanner);
                missionControl.moveRover(rover, instructions);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PlateauSize getPlateauSize(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter Plateau size: ");
                String plateauSizeInput = scanner.nextLine();
                if (plateauSizeInput.equalsIgnoreCase("exit")) break;

                return PlateauSizeParser.parseInput(plateauSizeInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static Position getRoverPosition(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter Rover position: ");
                String roverPositionInput = scanner.nextLine();
                if (roverPositionInput.equalsIgnoreCase("exit")) break;

                return PositionParser.parseInput(roverPositionInput);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static List<Instruction> getInstructions(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter instructions ");
                String instructionsInput = scanner.nextLine();
                if (instructionsInput.equalsIgnoreCase("exit")) break;

                return InstructionParser.parseInput(instructionsInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}

