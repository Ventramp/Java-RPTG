package game.exeptions;

public class InvalidOptionException extends Exception {

    public InvalidOptionException() {

        super("La opción ingresada no es válida");
    }
}