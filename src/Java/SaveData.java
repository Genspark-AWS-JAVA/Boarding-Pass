package Java;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SaveData {
    User user;
    BoardingPass boardingPass;
    String dataFilePath;
    String ticketFilePath;
    float price;

    public SaveData(Price price, User user, BoardingPass boardingPass) {
        this.user = user;
        this.boardingPass = boardingPass;
        dataFilePath = "data.csv";
        ticketFilePath = "ticket.txt";
        this.price = price.getPrice();
    }

    public void saveFile() {
        File dataFile = new File(dataFilePath);
        if (!dataFile.exists()) {
            this.writeHeaders();
        }
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(dataFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        String[] fields = {boardingPass.boardingPassNumber.toString(), boardingPass.date,
                boardingPass.origin, boardingPass.destination, boardingPass.ETA,
                boardingPass.departureTime, user.name, user.email,
                user.phoneNumber, user.gender, user.age.toString(), Float.toString(this.price)};
        csvWriter.writeNext(fields);
        try {
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeTicket() {
        if (deleteFile(this.ticketFilePath)) {
            System.out.println("Deleted old ticket file.");
        }

        FileReader fileReader;
        FileWriter fileWriter;
        try {
            fileReader = new FileReader(this.dataFilePath);
            fileWriter = new FileWriter(this.ticketFilePath);
        } catch (FileNotFoundException e) {
            System.out.printf("Unable to find file %s", this.dataFilePath);
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fileReader);
        try {
            fileWriter.write("Ticket:\n");
            List<String[]> csvLines = csvReader.readAll();
            String[] headers = csvLines.get(0);
            String[] line = csvLines.get(csvLines.size() - 1);

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals("Price")) {
                    fileWriter.write(String.format("%s:\t%s%n", headers[i], NumberFormat.
                            getCurrencyInstance(new Locale("en", "US")).
                            format(Float.parseFloat(line[i]))));
                } else {
                    fileWriter.write(String.format("%s:\t%s%n", headers[i], line[i]));
                }
            }

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    void writeHeaders() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(this.dataFilePath, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        String[] fields = {"Boarding Pass Number", "Date", "Origin", "Destination", "ETA", "DepartureTime",
                "Name", "Email", "PhoneNumber", "Gender", "Age", "Price"};
        csvWriter.writeNext(fields);
        try {
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
