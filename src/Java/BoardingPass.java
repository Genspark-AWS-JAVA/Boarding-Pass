package Java;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class BoardingPass {
    UUID boardingPassNumber;
    String date;
    String origin;
    String destination;
    String ETA;
    String departureTime;

    public void populateDataFromConsole(Scanner in) {
        String minute = "0";
        String newMinute = "0";
        System.out.println("Enter your current location");
        this.origin = in.nextLine();
        System.out.println("What is your destination");
        this.destination = in.nextLine();
        System.out.println("What date are you leaving (mm/dd/yyyy");
        this.date = in.nextLine();
        this.boardingPassNumber = UUID.randomUUID();
        Random rand = new Random();
        int hour = rand.nextInt(12) + 1;
        int preMinute = rand.nextInt(60);
        if (preMinute < 10) {
            minute += preMinute;
        } else {
            minute = preMinute + "";
        }
        this.departureTime = hour + ":" + minute;
        System.out.println(this.departureTime);
        int newHour = rand.nextInt(12) + 1;
        int preNewMinute = rand.nextInt(60);
        if (preNewMinute < 10) {
            newMinute += preNewMinute;
        } else {
            newMinute = preNewMinute + "";
        }
        this.ETA = newHour + ":" + newMinute;
        System.out.println(this.ETA);
    }
}
