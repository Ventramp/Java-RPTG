import characters.BasicCharacter;
import characters.Jobs.Monk;
import characters.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n//////////BIENVENIDO//////////");
     Player player= new Player();
     BasicCharacter character=new BasicCharacter();
     character.newName();
     character.displayData();
     player.displayData();
     player.attack();
     Monk monk =new Monk();
     monk.aboutJob();

    }
}