package utils;

import exception.MyException;

public enum Passenger {
    TURIST("T"),
    WORKER("W"),
    STUDENT("S");

    private String passengerType;

    public static String getPassenger(String args) throws MyException {
        switch (args.toUpperCase()) {
            case "T":
                return String.valueOf(TURIST);
            case "W":
                return String.valueOf(WORKER);
            case "S":
                return String.valueOf(STUDENT);
        }
        throw new MyException(MyException.WRONG_INPUT);
    }

    Passenger(String passengerType) {
        this.passengerType = passengerType;
    }
}
