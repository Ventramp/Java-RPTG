package game.exeptions;

public class ZeroException extends Exception {

    public ZeroException() {

        super("El Dato ingresado en 0");
    }
}