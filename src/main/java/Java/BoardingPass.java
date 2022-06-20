package Java;
//importing needed methods

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 * Boarding pass information.
 */
public class BoardingPass {
    //default values and methods
    UUID boardingPassNumber;
    /**
     * departure time
     */
    String date;
    /**
     * location where customer is departing from
     */
    String origin;
    /**
     * destination where customer arrives
     */
    String destination;
    /**
     * estimated arrival time
     */
    String eta;
    /**
     * Time of departure in hours and minutes
     */
    String departureTime;

    /**
     * taking user input to fill fields for data
     * @param in scanner to get user answer to questions
     */
    public void populateDataFromConsole(Scanner in) {
        String minute = "0";
        String newMinute = "0";
        System.out.println("Enter your current location");
        this.origin = in.nextLine();

        System.out.println("What is your destination");
        this.destination = in.nextLine();

        System.out.println("What date are you leaving (mm/dd/yyyy)");
        this.date = in.nextLine().strip();
         while(!this.date.matches("^(1[0-2]|0[1-9])/(3[01]|[12]\\d|0[1-9])/\\d{4}$")){
             System.out.printf("Incorrect date format.%n" +
                     " please enter the date of your departure in the following format (mm/dd/yyyy)");
             this.date = in.nextLine().strip();
         }

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
        this.eta = newHour + ":" + newMinute;
    }
}
