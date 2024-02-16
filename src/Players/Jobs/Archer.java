package Players.Jobs;

import Players.Player;
import items.weapons.Bow;

public class Archer extends Player {
    protected int aim;
    protected int addArrow;
    protected String jobName;

    public Archer() {
        this.weapon= new Bow();
        this.jobName = "Arquero";
        this.str-=3;
        this.aim = 0;
        this.dex +=5;
        this.def+=5;
        System.out.println("Adquiriendo trabajo:");
        System.out.println(".\n...\n.....\n");
        System.out.println("Ahora eres un ARQUERO\n");
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tAIM:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,aim,weapon.getN(),armor.getN());
    }
    @Override
    public void displayData() {
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tAIM:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,aim,weapon.getN(),armor.getN());
    }
    @Override
    public void aboutJob(){
        System.out.println("El ARQUERO es un atacante a distancia con la capacidad de lanzar hasta 3 ataques seguidos\nSu cualidad AIM se suma a su probabilidad critica");
    }
    @Override
    public void attack(){
        addArrow=rng(0,3);
        for (int i = 0; i < addArrow; i++)
        {
            System.out.println("Combo: "+(i+1));
            if (rng(1, 100) <= (pCrit+(aim/2)))
            {
                this.crit =(str* 2);
                this.aim +=1;
                System.out.printf("!CRITICO¡\nEl ARQUERO %s Ataca con flecha \nHace: %d de daño\nPunteria ha subido a:\n\tAim: %d\n\n",name, crit,aim);
            }
            else{
                this.dm=str;
                System.out.printf("El ARQUERO%s Ataca Con flecha\nHace: %d de Daño \n\n",name, dm);
            }
        }
    }

    public static void main(String[] args) {
        Archer archer =new Archer();
    }
}

