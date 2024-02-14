package Players;
//IMPORTS NECESARIOS PARA FUNCIONAMIENTO COMPLETO DE PLAYER Y SUS EXTENCIONES//
import java.util.Scanner;
import characters.BasicCharacter;
import items.armors.Armors;
import items.weapons.Weapons;
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
    //RNG PARA ELEMENTOS ALEATORIOS EN EL FUNCIONAMIENTO DEL PLAYER//
    protected int rng(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
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
            int x=rng(1,3);
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
    System.out.printf("\t\tHP:\t\t\t%d/%d   +\t(%d)\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp);
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d   +\t(%d)\n\t\tPROB.CRIT:\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n",dex,weapon.getwD(),pCrit,weapon.getN(),armor.getN());
    }
    public void attack(){
        //switch segun el Job//
        //switch//
        if (rng(1, 100) <= pCrit) {
            this.crit =((str+ weapon.getwA()) * 2);
            System.out.printf("!CRITICO¡\n%s Ataca con las manos vacias\nHace: %d de daño\n\n",name, crit);
        }else{
            System.out.printf("%s Ataca con las manos desnudas\nHace: %d de Daño \n\n",name, str+ weapon.getwA());
        }
    }
}
