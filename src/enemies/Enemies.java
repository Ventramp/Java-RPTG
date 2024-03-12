package enemies;
//DEFINICION DE LOS ENEMIGOS ABSTRACTA//
import players.Player;
public abstract class Enemies {
    private final String eName;
    private int eHP;
    private final int eMaxHp;
    private final int eDm;
    private final int dropG;
    private final int giveExp;
/*Para evitar confuciones dentro del codigo diferenciamos la informacion de los enemigos de
* la del jugador colocando a sus atributos una e*/
    //UTILIZAMOS EL THIS PARA ACCEDER A LAS VARIABLES//
public Enemies(String eName, int eHP, int eMaxHp, int eDm, int dropG, int giveExp) {
        this.eName = eName;
    //agregamos max Hp solo para proveer informacion al jugador//
        this.eMaxHp = eHP;
        this.eHP = eHP;
        this.eDm = eDm;
        this.dropG = dropG;
        this.giveExp = giveExp;
    System.out.printf("%s ha aparecido delante tuyo\nHP:\t\t\t%d/%d\n\n",geteName(),geteHP(),geteMaxHp());
    }
    //ACCIONES QUE REALIZARA EL PERSONAJE//
    public void eRecibeDm (int dm){
        //comodin dm para recordar que es el daño que hace el player//
        eHP-=dm;
        System.out.printf("%s Recibio %d puntos de daño \n",eName,dm);
        System.out.printf("%s \t\t HP:%d/%d\n\n",eName,eHP,eMaxHp);
        //si se cumple el boleano de muerte hacer//
        if (eDie())
            System.out.printf("%s fue derrotado\n",eName);
    }
    public boolean eDie(){
        return eHP <= 0;
    }
    //funcion de ataque en general de todos los hijos de enemigo//
    public abstract void eAttack(Player player);

    public String geteName() {return eName;}
    public int geteHP() {return eHP;}
    public void seteHP(int eHP) {this.eHP = eHP;}
    public int geteDm() {return eDm;}
    public int getDropG() {return dropG;}
    public int getGiveExp() {return giveExp;}
    public int geteMaxHp() {return eMaxHp;}
}

