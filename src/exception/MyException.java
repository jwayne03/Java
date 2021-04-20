package exception;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int FILE_NOT_FOUND = 0;
    public static final int NO_P = 1;
    public static final int WRONG_NUM_PARAMS = 2;
    public static final int WRONG_INPUT = 3;
    public static final int P_OK = 4;

    private int value;

    public MyException(int value) {
        this.value = value;
    }

    private List<String> messege = Arrays.asList(
            " FILE NOT FOUND ",
            " < No hay suficientes pasajeros > ",
            " < Parametros insuficientes > ",
            " < Error en la linea > ",
            " < Parada correcta > "
    );

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}