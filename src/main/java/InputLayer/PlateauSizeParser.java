package InputLayer;

import LogicLayer.PlateauSize;

import java.util.InputMismatchException;

public class PlateauSizeParser {

    public static PlateauSize parseInput(String input) {
        String inputWhiteSpacesRemoved = input.replaceAll(" ", "");

        if (inputWhiteSpacesRemoved.matches("\\d+") && inputWhiteSpacesRemoved.length() == 2) {
            String[] plateauSizeArray = inputWhiteSpacesRemoved.split("");
            int x = Integer.parseInt(plateauSizeArray[0]);
            int y = Integer.parseInt(plateauSizeArray[1]);

            return new PlateauSize(x, y);
        } else {
            throw new InputMismatchException("Plateau Size Can Only Contain 2 Positive Numbers");
        }

    }
}
