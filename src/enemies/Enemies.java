package enemies;
import Players.Player;
public abstract class Enemies {
    private final String eName;
    private int eHP;
    private final int eDm;
    private final int dropG;
    private final int giveExp;

    public Enemies(String eName, int eHP, int eDm, int dropG, int giveExp) {
        this.eName = eName;
        this.eHP = eHP;
        this.eDm = eDm;
        this.dropG = dropG;
        this.giveExp = giveExp;
    }
    public void recibeDm (int dm){
        System.out.printf("%s Recibio $d puntos de daño ",eDm,dm);
        eHP-=dm;
        if (muerte())
            System.out.printf("%s fue derrotado");
    }
    public boolean muerte(){
        return eHP <= 0;
    }
    public abstract void eAttack(Player player);

    public String geteName() {return eName;}
    public int geteHP() {return eHP;}
    public void seteHP(int eHP) {this.eHP = eHP;}
    public int geteDm() {return eDm;}
    public int getDropG() {return dropG;}
    public int getGiveExp() {return giveExp;}
}

