import characters.BasicCharacter;
import Players.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n////////// BIENVENIDO //////////");
        //creacion de Basic character o npc
     BasicCharacter character=new BasicCharacter();
     character.displayData();
     //creacion de jugador//
        Player player= new Player();
     player.displayData();
     player.aboutJob();
     player.attack();
     player.magicA();
     player.levelUp();
     player.displayData();

    }
}