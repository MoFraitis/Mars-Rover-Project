package InputLayer;

import LogicLayer.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @DisplayName("returns a List of Instructions when passed a valid string input")
    @Test
    void parseInputTest_ValidInput() {
        String input1 = "LMLMMLLMMMR";
        String input2 = "L ML M M LLMMMR";

        List<Instruction> result1 = InstructionParser.parseInput(input1);
        List<Instruction> result2 = InstructionParser.parseInput(input2);

        assertEquals(Instruction.L, result1.getFirst());
        assertEquals(input1.length(), result1.size());

        assertEquals(Instruction.M, result2.get(1));
        assertEquals(input2.length() - 4, result2.size()); //4 whitespaces
    }

    @DisplayName("throws an InputMismatchException when passed an invalid input")
    @Test
    void parseInputTest_InvalidInput() {
        String input1 = "LMALMMLLMMMR";
        String input2 = "ABC";
        String input3 = "123";
        String input4 = "AMLRW12@!";
        String input5 = "";

//        try{
//            InstructionParser.parseInput(input1);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        assertThrows(InputMismatchException.class, () -> InstructionParser.parseInput(input1));
        assertThrows(InputMismatchException.class, () -> InstructionParser.parseInput(input2));
        assertThrows(InputMismatchException.class, () -> InstructionParser.parseInput(input3));
        assertThrows(InputMismatchException.class, () -> InstructionParser.parseInput(input4));
        assertThrows(InputMismatchException.class, () -> InstructionParser.parseInput(input5));
    }
}