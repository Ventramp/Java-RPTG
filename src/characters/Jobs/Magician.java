package characters.Jobs;
import characters.Player;
import weapons.MagicStaff;

public class Magician extends Player {
    private String jobDesc;
    private int masterStaff;
    private int jobBuff;

    public Magician(String jobDesc, int masterStaff, int jobBuff) {
        this.jobDesc = jobDesc;
        this.masterStaff = masterStaff;
        this.jobBuff = jobBuff;
    }
}
