package Java;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {

    @Test
    void populateDataFromConsole() {
        BoardingPass boardingPass = new BoardingPass();

        String input = String.format("Location 1%nLocation 2%n01/02/2003%n");
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        Scanner in = new Scanner(System.in);
        boardingPass.populateDataFromConsole(in);
        assertEquals("Location 1", boardingPass.origin);
        assertEquals("Location 2", boardingPass.destination);
        assertEquals("01/02/2003", boardingPass.date);

        input = String.format("Location 1%nLocation 2%n02/2003%n01/02/2004%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        boardingPass.populateDataFromConsole(in);
        assertEquals("01/02/2004", boardingPass.date);

        try {
            inStream.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}