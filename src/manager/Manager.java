package manager;

import exception.MyException;
import utils.Passenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Manager {

    private final String INPUT_FILE = "lectura.txt";
    private TreeSet<Passenger> passengerList;
    private Passenger passenger;
    private boolean exit;

    public Manager() {
        this.exit = false;
        this.passengerList = new TreeSet<>();
    }

    public void start() {
        try {
            File file = new File(INPUT_FILE);
            if (!file.exists()) throw new MyException(MyException.FILE_NOT_FOUND);
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;

            while ((line = read.readLine()) != null && (!exit)) {
                System.out.println(line);
                String[] data = line.split(" ");
                this.menuOptions(data);
            }
        } catch (MyException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void menuOptions(String[] data) throws MyException {
        switch (data[0].toUpperCase()) {
            case "PASSENGER":
                Passenger.getPassenger(data[1]);
                break;
            case "END":
                exit = true;
                break;
            case " ":
                if (data.length != 3) throw new MyException(MyException.WRONG_NUM_PARAMS);
                break;
            default:
                break;
        }
    }
}
