package Java;
//importing needed methods
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
//default values and methods
public class BoardingPass {
    UUID boardingPassNumber;
    String date;
    String origin;
    String destination;
    String ETA;
    String departureTime;
//taking user input to fill fields for data
    public void populateDataFromConsole(Scanner in) {
        String minute = "0";
        String newMinute = "0";
        System.out.println("Enter your current location");
        this.origin = in.nextLine();
        System.out.println("What is your destination");
        this.destination = in.nextLine();
        System.out.println("What date are you leaving (mm/dd/yyyy)");
        this.date = in.nextLine();
//        Generates a unique ID
        this.boardingPassNumber = UUID.randomUUID();
        Random rand = new Random();
//        Generating random times to be stored.
        int hour = rand.nextInt(12) + 1;
        int preMinute = rand.nextInt(60);
        if (preMinute < 10) {
            minute += preMinute;
        } else {
            minute = preMinute + "";
        }
        this.departureTime = hour + ":" + minute;
        int newHour = rand.nextInt(12) + 1;
        int preNewMinute = rand.nextInt(60);
        if (preNewMinute < 10) {
            newMinute += preNewMinute;
        } else {
            newMinute = preNewMinute + "";
        }
        this.ETA = newHour + ":" + newMinute;
    }
}
