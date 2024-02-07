package characters.Jobs;
import characters.Player;
import weapons.Sword;
public class Swordman extends Player {
    private String jobDesc;
    private int masterSword;
    private int jobBuff;

    public Swordman(String jobDesc, int masterSword, int jobBuff) {
        this.jobDesc = jobDesc;
        this.masterSword = masterSword;
        this.jobBuff = jobBuff;
        this.attk = (this.str+ weapon.getwAttk());
    }
}
