import characters.BasicCharacter;
import characters.Jobs.Monk;
import characters.Player;

public class Main {
    public static void main(String[] args) {
        Player player= new Player();
        BasicCharacter character=new BasicCharacter();
        character.newName();
        character.displayData();
        player.newName();
        player.displayData();
        player.attack();

    }
}