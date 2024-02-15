package Players.Jobs;
import Players.Player;

public class Magician extends Player {
    private String jobName;
    private int masterStaff;

    public Magician() {
        this.jobName = "Mago";
        this.mp = mp +50;
        this.maxMp =maxMp+50;
        this.mag = mag+5;
        this.masterStaff = 0;
        this.str=str-5;
        System.out.println("Adquiriendo trabajo:");
        System.out.println(".\n...\n.....\n");
        System.out.println("Ahora eres un MAGO\n");
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp,weapon.getwMP());
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tMAG. M:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,masterStaff,weapon.getN(),armor.getN());
    }

    @Override
    public void magicA(){
        this.dm=mag+ weapon.getwMag()+masterStaff;
        //switch segun el elemento//
        //switch
        System.out.printf("El MAGO %s Canaliza un Hechizo\n",name);
        if (rng(1, 100) <= pCrit) {
            this.crit =dm*2;
            this.masterStaff=masterStaff+1;
            System.out.printf("!CRITICO¡\n%s Lanza un hechizo magico\nHace: %d de daño\nMaestria de Magia Aumento a:\t%d\n\n",name, crit,masterStaff);

        }else{
            System.out.printf("%s Lanza un hechizo magico\nHace: %d de Daño \n\n",name, dm);
        }
    }
    @Override
    public void aboutJob(){
        System.out.println("El MAGO es un atacante a distancia con altas cualidades magicas\nTiene un aumento de estadisticas en su MP y Magia pero reduce su fuerza\nmientras mas magia use Maestria de Magia aumentara de nivel haciendo mas daño con magia\n");

    }

}
