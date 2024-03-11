package players;
//IMPORTS NECESARIOS PARA FUNCIONAMIENTO COMPLETO DE PLAYER Y SUS EXTENCIONES//
import java.util.Scanner;
import characters.BasicCharacter;
import enemies.Enemies;
import items.armors.Armors;
import items.weapons.Weapons;
import org.jetbrains.annotations.NotNull;

import static util.Randomized.rng;
//INICIO DE PLAYER Y ATRIBUTOS//
public class Player extends BasicCharacter {
    protected int str;
    protected int gold;
    protected int mag;
    protected int def;
    protected int dex;
    protected int attk;
    protected int dm;
    protected int crit;
    protected int pCrit;
    protected int level;
    protected int maxExp;
    protected int exp;
    //VINCULACION DE LOS OBJETOS WEAPON Y ARMOR//
    protected Weapons weapon;
    protected Armors armor;

    //CONSTRUCTOR DE LAS CARACTERISTICAS DE PLAYER//
    public Player(String name) {
        super(name, 100,100);
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
            if (x==1) {str++;}
            if (x==2) {def++;}
            if (x==3) {dex++;}
        }
        while ((str+def+dex) !=30);
        //CREACION DE BALANCE ENTRE FUERZA Y MAGIA//
        this.mag = (-str+15);
        this.pCrit=5;
        this.gold=100;
        this.level = 1;
        this.exp = 0;
        this.maxExp = 100;
        this.weapon = new Weapons();
        this.armor = new Armors();

    }
//SOBREESCRIBIR DISPLAY DATA PARA PLAYER EN BASE DE BASIC PLAYER Adicionado con el aumento de atributos por elementos de Armas y Armaduras//
@Override
public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tMP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),mp,maxMp,weapon.getwMP());
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t%d/%d\n\n",level,exp,maxExp);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tMAG:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),mag,weapon.getwMag(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n\t\t\t\t\t\t\t%d G\n\n",dex,pCrit,weapon.getN(),armor.getN(),gold);
    }
    public void aboutJob(){
        System.out.println("CLASE:\nActualmente no tienes adquirida ninguna CLASE\n");
    }
    public void attack(@NotNull Enemies enemies){
        this.dm=str+weapon.getwA();
        //switch segun el Job//
        //switch//
        if (rng(1, 100) <= pCrit) {
            this.crit =dm * 2;
            System.out.printf("!CRITICO¡\n%s Ataca con las manos vacias\nHace: %d de daño\n\n",name, crit);
        }else{
            System.out.printf("%s Ataca con las manos desnudas\nHace: %d de Daño \n\n",name, dm);
        }
        enemies.eRecibeDm (dm);
    }
    public void magicA(@NotNull Enemies enemies){
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
        enemies.eRecibeDm (dm);
    }
    
    //implementacion temprana a sistema de nivel, sujeto a cambios//
    public void levelUp() {
        level++;
        exp = 0;
        System.out.println("\nSUBISTE DE NIVEL\n");
        for (int i = 0; i < 4; i++) {
            int x = (rng(1, 7));
            switch (x) {
                case 1 -> {str++;
                    System.out.printf("STR\t Ha aumentado a:\t%d\n", str);
                }
                case 2 -> {def++;
                    System.out.printf("DEF\t Ha aumentado a:\t%d\n", def);
                }
                case 3 -> {dex++;
                    System.out.printf("DEX\t Ha aumentado a:\t%d\n", dex);
                }
                case 4 -> {mag++;
                    System.out.printf("MAG\t Ha aumentado a:\t%d\n", mag);
                }
                case 5 -> {pCrit++;
                    System.out.printf("P.CRIT Ha aumentado a:\t%d\n", pCrit);
                }
                case 6 -> {hp += 20;    maxHp += 20;
                    System.out.printf("HP\t maxima aumentada:\t%d\n", maxHp);
                }
                case 7 -> {mp += 10;    maxMp += 10;
                    System.out.printf("MP\t maxima aumentada:\t%d\n", maxMp);
                }
            }
        }
    }
/**getters y setters**/
    public int getStr() {return str;}
    public void setStr(int str) {this.str = str;}
    public int getGold() {return gold;}
    public void setGold(int gold) {this.gold = gold;}
    public int getMag() {return mag;}
    public void setMag(int mag) {this.mag = mag;}
    public int getDef() {return def;}
    public void setDef(int def) {this.def = def;}
    public int getDex() {return dex;}
    public void setDex(int dex) {this.dex = dex;}
    public int getAttk() {return attk;}
    public void setAttk(int attk) {this.attk = attk;}
    public int getDm() {return dm;}
    public void setDm(int dm) {this.dm = dm;}
    public int getCrit() {return crit;}
    public void setCrit(int crit) {this.crit = crit;}
    public int getpCrit() {return pCrit;}
    public void setpCrit(int pCrit) {this.pCrit = pCrit;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public int getMaxExp() {return maxExp;}
    public void setMaxExp(int maxExp) {this.maxExp = maxExp;}
    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp = exp;}
    public Weapons getWeapon() {return weapon;}
    public void setWeapon(Weapons weapon) {this.weapon = weapon;}
    public Armors getArmor() {return armor;}
    public void setArmor(Armors armor) {this.armor = armor;}
}
