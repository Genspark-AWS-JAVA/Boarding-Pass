package Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        User user = new User();
        user.populateUserDataFromConsole(in);
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.populateDataFromConsole(in);

        SaveData saveData = new SaveData(user, boardingPass);
        saveData.saveFile();
        saveData.writeTicket();
    }
}
