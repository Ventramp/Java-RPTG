package Players;

import characters.BasicCharacter;
import items.armors.Armors;
import items.weapons.Weapons;

public class Player extends BasicCharacter {
    protected int str;
    protected int mag;
    protected int def;
    protected int dex;
    protected int attk;
    protected int dm;
    protected int crit;
    protected int pCrit;
    protected int level;
    protected int exp;
    protected Weapons weapon;
    protected Armors armor;
    protected int rng(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public Player() {
        //estos los puse solo para que el rng no sea tan injusto
        this.def=5;
        this.dex=5;
        //genera un rng entre 1 y 3 donde cada numero esta asignado a una estadistica de caer uno de los numeros se sumara +1 a la
        // estadistica correspondiente, este ciclo se repetira hasta que la suma total de atributos sea 30
        do {
            int x=rng(1,3);
            if (x==1) {this.str=(this.str+1);}
            if (x==2) {this.def=(this.def+1);}
            if (x==3) {this.dex=(this.dex+1);}
        }
        while ((this.str+this.def+this.dex) !=30);

        //o eres bueno con la magia o eres fuerte creando un equilibrio artificial de los stads
        this.mag = (-this.str+15);
        this.pCrit=5;
        this.level = 1;
        this.exp = 0;
        this.weapon=null;
        this.armor=null;

    }
@Override
public void displayData(){
    System.out.println("Nuevo Jugador Ingresando:");
    System.out.println(".\n...\n.....\n");
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp,maxHp,mp,maxMp);
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
    System.out.printf("\t\tSTR:\t\t\t%d\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d\n",str,mag,def);
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\n\tWEAPON:\t\t%d\n\tARMOR:\t\t%d\n\n",dex,pCrit,weapon,armor);
    }
    public void attack(){
        if (rng(1, 100) <= pCrit) {
            this.crit =(this.str * 2);
            System.out.printf("!CRITICO¡\n%s Ataca con las manos vacias\nHace: %d de daño\n\n",name, crit);
        }else{
            System.out.printf("%s Ataca con las manos desnudas\nHace: %d de Daño \n\n",name, str);
        }
    }
}
