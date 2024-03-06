package Players;
//IMPORTS NECESARIOS PARA FUNCIONAMIENTO COMPLETO DE PLAYER Y SUS EXTENCIONES//
import java.util.Scanner;
import characters.BasicCharacter;
import items.armors.Armors;
import items.weapons.Weapons;
import static util.Randomized.rng;
//INICIO DE PLAYER Y ATRIBUTOS//
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
    //VINCULACION DE LOS OBJETOS WEAPON Y ARMOR//
    protected Weapons weapon;
    protected Armors armor;

    //CONSTRUCTOR DE LAS CARACTERISTICAS DE PLAYER//
    public Player() {
        System.out.println("Nuevo Jugador Ingresando:");
        System.out.println("\n.\n...\n.....");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngresa tu nombre de usuario:");
            this.name = scanner.nextLine();
        //INCLUSION DE UN MINIMO DE 5 PARA LAS CARACTERISTICAS PARA EVITAR DESVALANCES//
        this.def=5;
        this.dex=5;
        //genera un rng entre 1 y 3 donde cada numero esta asignado a una estadistica de caer uno de los numeros se sumara +1 a la
        //estadistica correspondiente, este ciclo se repetira hasta que la suma total de atributos sea 30//
        do {
            int x= (rng(1,3));
            if (x==1) {this.str=(this.str+1);}
            if (x==2) {this.def=(this.def+1);}
            if (x==3) {this.dex=(this.dex+1);}
        }
        while ((this.str+this.def+this.dex) !=30);
        //CREACION DE BALANCE ENTRE FUERZA Y MAGIA//
        this.mag = (-this.str+15);
        this.pCrit=5;
        this.level = 1;
        this.exp = 0;
        this.weapon = new Weapons();
        this.armor = new Armors();

    }
//SOBREESCRIBIR DISPLAY DATA PARA PLAYER EN BASE DE BASIC PLAYER Adicionado con el aumento de atributos por elementos de Armas y Armaduras//
@Override
public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp,weapon.getwMP());
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,pCrit,weapon.getN(),armor.getN());
    }
    public void aboutJob(){
        System.out.println("CLASE:\nActualmente no tienes adquirida ninguna CLASE\n");
    }
    public void attack(){
        this.dm=str+weapon.getwA();
        //switch segun el Job//
        //switch//
        if (rng(1, 100) <= pCrit) {
            this.crit =dm * 2;
            System.out.printf("!CRITICO¡\n%s Ataca con las manos vacias\nHace: %d de daño\n\n",name, crit);
        }else{
            System.out.printf("%s Ataca con las manos desnudas\nHace: %d de Daño \n\n",name, dm);
        }
    }
    public void magicA(){
        this.dm=mag+ weapon.getwMag();
        //switch segun el elemento//
        //switch
        System.out.printf("%s Canaliza un Hechizo\n\n",name);
        if (rng(1, 100) <= pCrit) {
            this.crit =dm*2;
            System.out.printf("!CRITICO¡\n%s Lanza un hechizo magico\nHace: %d de daño\n\n",name, crit);
        }else{
            System.out.printf("%s Lanza un hechizo magico\nHace: %d de Daño \n\n",name, dm);
        }
    }
    //implementacion temprana a sistema de nivel, sujeto a cambios//
    public void levelUp(){
        this.level=level+1;
        this.exp=0;
        System.out.println("\nSUBISTE DE NIVEL\n");
        this.hp=hp+20;
        this.maxHp=maxHp+20;
        System.out.printf("HP\t maxima aumentada:\t%d\n",maxHp);
        this.mp=mp+10;
        this.maxMp=maxMp+10;
        System.out.printf("MP\t maxima aumentada:\t%d\n",maxMp);
        for (int i = 0; i < 4; i++){
            int x=(rng(1,5));
            if (x==1) {this.str=(str+1);
                System.out.printf("STR\t Ha aumentado a:\t%d\n",str);}
            if (x==2) {this.def=(def+1);
                System.out.printf("DEF\t Ha aumentado a:\t%d\n",def);}
            if (x==3) {this.dex=(dex+1);
                System.out.printf("DEX\t Ha aumentado a:\t%d\n",dex);}
            if (x==4) {this.mag=(mag+1);
                System.out.printf("MAG\t Ha aumentado a:\t%d\n",mag);}
            if (x==5) {this.pCrit=(pCrit+1);
                System.out.printf("P.CRIT Ha aumentado a:\t%d\n",pCrit);}
        }
    }
}
