import characters.BasicCharacter;
import Players.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n//////////BIENVENIDO//////////");
     Player player= new Player();
     BasicCharacter character=new BasicCharacter();
     character.displayData();
     player.displayData();
     player.attack();

    }
}