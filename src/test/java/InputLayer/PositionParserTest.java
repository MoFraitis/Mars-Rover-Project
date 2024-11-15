package InputLayer;

import LogicLayer.CompassDirection;
import LogicLayer.PlateauSize;
import LogicLayer.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {

    @DisplayName("returns a Position object when passed a valid string input")
    @Test
    void parseInputTest_ValidInput() {
        String input = "12N";
        Position result = PositionParser.parseInput(input);

        Position position = new Position(1, 2, CompassDirection.N);

        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(CompassDirection.N, result.getFacing());
        assertInstanceOf(position.getClass(), result);
    }

    @DisplayName("returns a Position object when passed a valid string input with white spaces")
    @Test
    void parseInputTest_ValidInputWithWhiteSpaces() {
        String input1 = "1 2 N";
        String input2 = " 3 6 E ";
        String input3 = " 0 3  W";

        Position result1 = PositionParser.parseInput(input1);
        Position result2 = PositionParser.parseInput(input2);
        Position result3 = PositionParser.parseInput(input3);

        Position position = new Position(1, 2, CompassDirection.N);

        assertEquals(1, result1.getX());
        assertEquals(2, result1.getY());
        assertEquals(CompassDirection.N, result1.getFacing());
        assertInstanceOf(position.getClass(), result1);

        assertEquals(3, result2.getX());
        assertEquals(6, result2.getY());
        assertEquals(CompassDirection.E, result2.getFacing());
        assertEquals(0, result3.getX());
        assertEquals(3, result3.getY());
        assertEquals(CompassDirection.W, result3.getFacing());
    }

    @DisplayName("throws an InputMismatchException when passed an invalid input")
    @Test
    void parseInputTest_InvalidInput() {
        String input1 = "-56N";
        String input2 = "ABc123";
        String input3 = "-4-31";
        String input4 = "55";
        String input5 = "LMRMMLM";
        String input6 = "12M";

        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input1));
        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input2));
        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input3));
        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input4));
        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input5));
        assertThrows(InputMismatchException.class, ()-> PositionParser.parseInput(input6));
    }

}