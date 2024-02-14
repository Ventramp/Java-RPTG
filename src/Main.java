import characters.BasicCharacter;
import characters.Jobs.Monk;
import characters.Player;
import characters.Jobs.Ranger;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n//////////BIENVENIDO//////////");
     Ranger ranger = new Ranger();
     ranger.newName();
     ranger.displayData();
     ranger.attack();

    }
}