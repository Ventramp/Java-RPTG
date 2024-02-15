package Players.Jobs;
import Players.Player;

public class Swordman extends Player {
    private String jobDesc;
    private int masterSword;
    public Swordman(String jobDesc, int masterSword, int jobBuff) {
        this.jobDesc = jobDesc;
        this.masterSword = masterSword;
        this.attk = (this.str+ weapon.getwA());
    }
}
