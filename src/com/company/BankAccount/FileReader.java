package com.company.BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    private final String fileName;
    private final String nric;

    public FileReader(String nric) {
        this.nric = nric;
        this.fileName = nric + ".txt";
    }

    public double readBalance() {

        // Get previous bank balance if it exists
        try {
            File dataFile = new File(this.fileName);
            Scanner reader = new Scanner(dataFile);
            String data = reader.nextLine();
            try {
                return Double.parseDouble(data);
            } catch (NumberFormatException e) {
                // If data has invalid value
                dataFile.delete();
                return 0;
            }
        } catch (IOException e) {
            System.out.println("No previous balance for " + this.nric + " exists.");
            return 0;
        }
    }
    public void saveBalance(double balance) {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            writer.write(String.valueOf(balance));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
