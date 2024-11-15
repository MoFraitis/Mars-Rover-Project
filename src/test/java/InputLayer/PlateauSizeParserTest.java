package InputLayer;

import LogicLayer.PlateauSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {

    @DisplayName("returns a PlateauSize object with max X and max Y co-ordinates when passed a valid string input")
    @Test
    void parseInputTest_ValidInput() {
        String input = "55";
        PlateauSize result = PlateauSizeParser.parseInput(input);

        int expectedX = 5;
        int expectedY = 5;
        PlateauSize plateauSize = new PlateauSize(5, 5);

        assertEquals(expectedX, result.getX());
        assertEquals(expectedY, result.getY());
        assertInstanceOf(plateauSize.getClass(), result);
    }

    @DisplayName("returns a PlateauSize object with max X and max Y co-ordinates when passed a valid string input with white spaces")
    @Test
    void parseInputTest_ValidInputWithWhiteSpaces() {
        String input1 = "5 5";
        String input2 = "6 5 ";
        String input3 = " 3 3 ";
        String input4 = "  4 3";
        PlateauSize result1 = PlateauSizeParser.parseInput(input1);
        PlateauSize result2 = PlateauSizeParser.parseInput(input2);
        PlateauSize result3 = PlateauSizeParser.parseInput(input3);
        PlateauSize result4 = PlateauSizeParser.parseInput(input4);

        PlateauSize plateauSize1 = new PlateauSize(5, 5);

        assertEquals(5, result1.getX());
        assertEquals(5, result1.getY());
        assertInstanceOf(plateauSize1.getClass(), result1);

        assertEquals(6, result2.getX());
        assertEquals(5, result2.getY());
        assertEquals(3, result3.getX());
        assertEquals(3, result3.getY());
        assertEquals(4, result4.getX());
        assertEquals(3, result4.getY());
    }

    @DisplayName("throws an InputMismatchException when passed an invalid input")
    @Test
    void parseInputTest_InvalidInput() {
        String input1 = "-56";
        String input2 = "ABc123";
        String input3 = "-4-31";

        assertThrows(InputMismatchException.class, ()-> PlateauSizeParser.parseInput(input1));
        assertThrows(InputMismatchException.class, ()-> PlateauSizeParser.parseInput(input2));
        assertThrows(InputMismatchException.class, ()-> PlateauSizeParser.parseInput(input3));
    }
}