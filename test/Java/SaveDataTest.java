package Java;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SaveDataTest {
    User user;
    BoardingPass boardingPass;
    SaveData saveData;

    @BeforeEach
    void setUp() {
        user = new User();
        user.name = "A Passenger";
        user.gender = "Male";
        user.phoneNumber = "(555) 555 0123";
        user.email = "passenger@example.com";
        user.age = 30;
//        boardingPass = new BoardingPass();
//        boardingPass.boardingPassNumber = 100;
//        boardingPass.origin = "12 High St. Indianapolis, Indiana, USA";
//        boardingPass.destination = "123 Main St. Columbus, Ohio, USA";
//        boardingPass.date = Date.valueOf("2022-01-01");
//        boardingPass.departureTime = Date.valueOf("2022-01-02");
//        boardingPass.ETA = Date.valueOf("2022-01-03");

        saveData = new SaveData(user, boardingPass);
        saveData.dataFilePath = "test/_test_data.csv";
        saveData.ticketFilePath = "test/_test_ticket.txt";
    }

    @Test
    void saveFile() {
        saveData.saveFile();
        saveData.saveFile();
        saveData.saveFile();
        FileReader fileReader;
        try {
            fileReader = new FileReader(saveData.dataFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fileReader);
        try {
            String[] headers = csvReader.readNext();
            assertEquals("Date", headers[1]);
            String[] line = csvReader.readNext();
            assertEquals("100", line[0]);

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try {
            csvReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void writeTicket() {
        saveData.saveFile();
        saveData.saveFile();
        saveData.saveFile();
        saveData.writeTicket();
        File ticketFile = new File(saveData.ticketFilePath);
        assertTrue(ticketFile.exists());
        assertTrue(ticketFile.length() > 5);
    }

    @AfterEach
    void tearDown() {
        File testDataFile = new File(saveData.dataFilePath);
        if (testDataFile.exists()) {
            if (!testDataFile.delete()) {
                System.out.println("Was not able to delete test CSV file.");
            }
        }
//        File testTicketFile = new File(saveData.ticketFilePath);
//        if (testTicketFile.exists()){
//            if(!testTicketFile.delete()){
//                System.out.println("Was not able to delete test Ticket file.");
//            }
//        }
    }
}