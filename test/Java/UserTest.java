package Java;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @Test
    void populateUserDataFromConsole() {
        User user = new User();

        String input = String.format("Michael%nl@g.com%n(555) 555 0123%nmale%n33%n");
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        Scanner in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        assertEquals("Michael", user.name);

        input = String.format("M%nl@g.com%n(555) 555 0123%nmale%n33%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        assertEquals("M", user.name);

        try {
            inStream.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}