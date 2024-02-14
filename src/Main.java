import characters.BasicCharacter;
import Players.Jobs.Monk;
import Players.Player;
import Players.Jobs.Archer;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n//////////BIENVENIDO//////////");
        Player player= new Player();
        BasicCharacter character=new BasicCharacter();
        character.newName();
        character.displayData();
        player.displayData();
        player.attack();
    }
}