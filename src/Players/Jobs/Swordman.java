package Players.Jobs;
import Players.Player;
import items.weapons.Sword;

public class Swordman extends Player {
    private String jobName;
    private int bleeding;
    public Swordman() {
        this.jobName = "Espadachin";
        this.bleeding = 1;
        this.weapon = new Sword();
        this.def+=7;
        this.str+=7;
        this.mag-=7;
        this.mp-=50;
        this.attk = (this.str+ weapon.getwA());
        System.out.println("Adquiriendo trabajo:");
        System.out.println(".\n...\n.....\n");
        System.out.println("Ahora eres un ESPADACHIN\n");
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tBLEEDING:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,bleeding,weapon.getN(),armor.getN());
    }

    @Override
    public void displayData(){
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d+(%d)\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d+(%d)\n",str,weapon.getwA(),mag,def,armor.getaD());
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tBLEEDING:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,bleeding,weapon.getN(),armor.getN());
    }
    @Override
    public void aboutJob(){
        System.out.println("El ESPADACHIN es un Guerrero cuerpo a cuerpo\nPierde capacidades magicas y MP pero gana Fuerza y Defensa\nEl espadachin tiene la caracteristica SANGRADO que se activa despues de un critico\nCada turno que pase el enemigo afectado por SANGRADO perdera vida de manera creciente");
    }
}
