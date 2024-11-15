package InputLayer;

import LogicLayer.Instruction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class InstructionParser {

    public static List<Instruction> parseInput(String input) {
        String inputWhiteSpacesRemoved = input.replaceAll(" ", "");

        if(inputWhiteSpacesRemoved.matches("^[LRM]+$")) {
            List<Instruction> instructions = new ArrayList<>();
            for (char c : inputWhiteSpacesRemoved.toCharArray()) {
                instructions.add(Instruction.valueOf(String.valueOf(c)));
            }
            return instructions;
        } else {
            throw new InputMismatchException("Instructions can only be L M or R");
        }

    }
}
