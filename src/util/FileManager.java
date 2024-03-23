package util;
import players.Player;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
public int gameslots;
    public static Player loadGame() throws FileNotFoundException {

        Player player = null;
        try {
            player = (Player) new ObjectInputStream(new FileInputStream("C:\\Users\\buenc\\Downloads\\game.dat")).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException("No se encontró el archivo");
        }
        return player;
    }

    public static void saveGame(Player player) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\buenc\\Downloads\\game.dat"));
            oos.writeObject(player);
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
