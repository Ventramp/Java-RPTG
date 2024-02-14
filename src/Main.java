import characters.BasicCharacter;
import characters.Jobs.Monk;
import characters.Player;
import characters.Jobs.Ranger;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n//////////BIENVENIDO//////////");
        BasicCharacter basic = new BasicCharacter();
        basic.newName();
        basic.displayData();
        Player player = new Player();
        player.displayData();
        player.attack();
    }
}