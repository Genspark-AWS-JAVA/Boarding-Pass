package Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User user = new User();
//        Creates new user and populates data using methods in user class
        user.populateUserDataFromConsole(in);
        BoardingPass boardingPass = new BoardingPass();
//        Creates new boarding pass and populates data using methods in said class
        boardingPass.populateDataFromConsole(in);
//      Generates price based on data from user created above
        Price price = new Price(user);
//      Code to call the methods to save and write the ticket
        SaveData saveData = new SaveData(price, user, boardingPass);
        saveData.saveFile();
        saveData.writeTicket();
    }
}
