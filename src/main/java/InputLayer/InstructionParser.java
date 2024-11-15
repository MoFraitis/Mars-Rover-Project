package InputLayer;

import LogicLayer.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {

    public static List<Instruction> parseInput(String input) {
        List<Instruction> instructions = new ArrayList<>();

        for (char c : input.toCharArray()) {
            instructions.add(Instruction.valueOf(String.valueOf(c)));
        }

        return instructions;
    }
}
