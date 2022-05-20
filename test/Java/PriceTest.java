package Java;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void getPrice() {
        User user = new User();
        String input = String.format("M%nl@g.com%n(555) 555 0123%nmale%n33%n");
        InputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        Scanner in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);

        Price price = new Price(user);
        price.basePrice = 100f;
        assertEquals(100f, price.getPrice());

        input = String.format("M%nl@g.com%n(555) 555 0123%nfemale%n33%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        price = new Price(user);
        price.basePrice = 100f;
        assertEquals(75f, price.getPrice());

        input = String.format("M%nl@g.com%n(555) 555 0123%nmale%n5%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        price = new Price(user);
        price.basePrice = 100f;
        assertEquals(50f, price.getPrice());

        input = String.format("M%nl@g.com%n(555) 555 0123%nmale%n80%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        price = new Price(user);
        price.basePrice = 100f;
        assertEquals(40f, price.getPrice());

        input = String.format("M%nl@g.com%n(555) 555 0123%nfemale%n80%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        price = new Price(user);
        price.basePrice = 100f;
        assertEquals(30f, price.getPrice());

        input = String.format("M%nl@g.com%n(555) 555 0123%nfemale%n8%n");
        inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        in = new Scanner(System.in);
        user.populateUserDataFromConsole(in);
        price = new Price(user);
        price.basePrice = 100f;
        assertEquals(37.5f, price.getPrice());
    }
}