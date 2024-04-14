package players;
//IMPORTS NECESARIOS PARA FUNCIONAMIENTO COMPLETO DE PLAYER Y SUS EXTENCIONES//
import java.io.Serializable;

import characters.BasicCharacter;
import enemies.Enemies;
import gui.panels.ConsolePanel;
import items.armors.Armors;
import items.armors.EmpyArmor;
import items.armors.boots.EmpyBoots;
import items.armors.chest.EmpyChest;
import items.armors.helmets.EmpyHelmet;
import items.armors.knuckles.EmpyKnuckles;
import items.weapons.Empy;
import items.weapons.Weapons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static util.Randomized.rng;

//INICIO DE PLAYER Y ATRIBUTOS//
public class Player extends BasicCharacter implements Serializable {
    protected int str;
    protected int gold;
    protected int def;
    protected int dex;
    protected int dm;
    protected int crit;
    protected int pCrit;
    protected int level;
    protected int maxExp;
    protected int exp;
    //VINCULACION DE LOS OBJETOS WEAPON Y ARMOR//
    protected Weapons weapon;
    protected Armors chest;
    protected Armors helmet;
    protected Armors knuckles;
    protected Armors boots;
    protected String job;
    protected int jobadd;
    protected final Inventory inventory;
    protected int revives;




    //CONSTRUCTOR DE LAS CARACTERISTICAS DE PLAYER//
    public Player(String name) {

        super(name, 100,100);
        inventory = new Inventory();
        //INCLUSION DE UN MINIMO DE 5 PARA LAS CARACTERISTICAS PARA EVITAR DESBALANCES//
        this.def=5;
        this.dex=5;
        this.str=5;
        //genera un rng entre 1 y 3 donde cada numero esta asignado a una estadistica de caer uno de los numeros se sumara +1 a la
        //estadistica correspondiente, este ciclo se repetira hasta que la suma total de atributos sea 30//
        do {
            int x= (rng(1,3));
            if (x==1) {str++;}
            if (x==2) {def++;}
            if (x==3) {dex++;}
        }
        while ((str+def+dex) !=30);

        this.pCrit=5;
        this.gold=100;
        this.level = 1;
        this.exp = 0;
        this.maxExp = 100;
        this.weapon = new Empy();
        this.chest = new EmpyChest();
        this.helmet = new EmpyHelmet();
        this.knuckles = new EmpyKnuckles();
        this.boots = new EmpyBoots();
        this.job="Sin Clase";
        this.revives=0;
    }
    //SOBREESCRIBIR DISPLAY DATA PARA PLAYER EN BASE DE BASIC PLAYER Adicionado con el aumento de atributos por elementos de Armas y Armaduras//
@Override
public void displayData() {
        }

    //ataque normal//
    public void attack(@NotNull Enemies enemies){
        //llamada al calculo de daño fisico//
        fisicDm();
        if (rng(1, 100) <= pCrit) {
            //llamada al calculo para daños criticos//
            critical();
            ConsolePanel.getInstance().getConsole().append(name+" Ataca a "+enemies.getName()+" con las manos vacias\n!!CRITICO¡¡\n");
            //llamada a la funcion de los enemigos recibe daño con el comodin critico//
            enemies.eRecibeDm(crit);
        }
        else{
            ConsolePanel.getInstance().getConsole().append(name+" Ataca a "+enemies.getName()+" con las manos desnudas\n");
            enemies.eRecibeDm(dm);
        }
        if (enemies.eDie()){
            rewards(enemies);
        }
    }

    public void gun(@NotNull Enemies enemies){
        ap-=30;
        dm=str+5;
        ConsolePanel.getInstance().getConsole().append("Pistola -30Ap\nAP:   "+ap+"/"+maxAp);
        enemies.eRecibeDm(dm);
        if (enemies.eDie()){
            rewards(enemies);
        }

    }
    public void canyon(@NotNull Enemies enemies){
        ap-=50;
        dm=str*2;
        ConsolePanel.getInstance().getConsole().append("Cañon -50Ap\nAP:   "+ap+"/"+maxAp);
        enemies.eRecibeDm(dm);
        if (enemies.eDie()){
            rewards(enemies);
        }
    }

    //preguntar como desaparecer objetos//
    public void escape(@NotNull Enemies enemies){
        enemies.setHp(0);
        ConsolePanel.getInstance().getConsole().append(name+" Escapo de "+enemies.getName());
    }
    //voids para calculos especificos de daño en las funciones de ataque//
    private void fisicDm(){dm=str+weapon.getwAttk();}
    private void critical (){crit=dm*2;}
    /* Ataques de tipo artilleria*/

    //Obtencion de recompensas//
    private void rewards(@NotNull Enemies enemies){
        ConsolePanel.getInstance().getConsole().append("///EXP     "+exp+"  +  "+enemies.getGiveExp()+"///\n///Gold     "+gold+"  +  "+enemies.getDropG()+"///");
        this.exp+= enemies.getGiveExp();
        this.gold+= enemies.getDropG();
    }
    //Funcion que comprueba el exp actual contra el exp maximo//
    private void lvUpCheck(){
        if (exp >= maxExp) {levelUp();}
    }
    /**Que ocurre cuando se suba de nivel**/
    public void levelUp() {
        exp -= maxExp ;
        level++;
        //exp maxima aumentara gradualmente segun cuantos niveles suba//
        maxExp += 20*(level-1);
        String message = String.format("SUBISTE DE NIVEL\n");
        for (int i = 0; i < 4; i++) {
            int x = (rng(1, 6));
            switch (x) {
                case 1 -> {str++;                       message += String.format ("STR    Ha aumentado a:     %d\n",str);}
                case 2 -> {def++;                       message += String.format ("DEF    Ha aumentado a:     %d\n",def);}
                case 3 -> {dex++;                       message += String.format ("DEX    Ha aumentado a:     %d\n",dex);}
                case 4 -> {pCrit++;                     message += String.format ("P.CRIT Ha aumentado a:     %d\n",pCrit);}
                case 5 -> {hp += 20;    maxHp += 20;    message += String.format ("HP     maxima aumentada:   %d\n",maxHp);}
                case 6 -> {ap += 10;    maxAp += 10;    message += String.format ("AP     maxima aumentada:   %d\n",maxAp);}
            }
        }
        ConsolePanel.getInstance().getConsole().append(message);
    }

    public String getTotalStr() {
        int plusAttack = 0;
        String message = String.format("STR: %d", getStr());
        plusAttack += weapon.getwAttk();
        plusAttack += knuckles.getAttk();
        if (plusAttack > 0) {
            message += String.format(" (+%d)", plusAttack);
        }
        return message;
    }
    public String getTotalDeff() {
        int plusAttack = 0;
        String message = String.format("DEF: %d", getDef());
        plusAttack += chest.getaDef();
        if (plusAttack > 0) {
            message += String.format(" (+%d)", plusAttack);
        }
        return message;
    }
    public String getTotalDex() {
        int plusAttack = 0;
        String message = String.format("DEX: %d", getDex());
        plusAttack += boots.getaDex();
        if (plusAttack > 0) {
            message += String.format(" (+%d)", plusAttack);
        }
        return message;
    }
    public String getGoldStatus() {
        String message = String.format("G:"+getGold());
        return message;
    }
    public String getTotalPcrit() {
        String message = String.format("P.CRIT: %d",getpCrit());
        return message;
    }
    public void equipWeapon(Weapons weapon) {
        this.weapon = weapon;
    }
    public void equipWDialog(@NotNull Weapons weapons){
        ConsolePanel.getInstance().getConsole().append("Has equipado :"+weapon.getName());
    }
    public void equipArmor(Armors armor) {

        switch (armor.getType()) {
            case HEAD -> helmet = armor;
            case CHEST -> chest = armor;
            case LEGS -> boots = armor;
            case HANDS -> knuckles = armor;
        }
    }
    public void equipADialog(@NotNull Armors armor){
        ConsolePanel.getInstance().getConsole().append("Has equipado :"+armor.getName());
    }

    public void revive() {
            revives-=1;
            hp = maxHp;
            ap = maxAp;
        }
    @Override
    public void recibeDm(int eDm) {
        int edmreduction;
        edmreduction= eDm-def;
        if (edmreduction <= 0) edmreduction=0;
        hp -= edmreduction;
        ConsolePanel.getInstance().getConsole().append(name+" recibio "+edmreduction+" puntos de daño\n"
        +"      HP:         "+hp+"/"+maxHp+"\n      AP:          "+ap+"/"+maxHp);
        apRecover();
        if (muerte())
            ConsolePanel.getInstance().getConsole().append("**********  HAS MUERTO  **********");
    }
    //ganancia y limitacion de hp y ap usados al recibir daño y al acabar una pelea//
    private void apRecover(){ap+=10;     if (ap>maxHp) ap=maxAp;}
    private void hpRecover(){hp+=dex;    if (hp>maxHp) hp=maxHp;}
/**getters y setters**/
    public int getStr() {return str;}
    public void setStr(int str) {this.str = str;}
    public int getGold() {return gold;}
    //el minimo de oro que se puede setear es 0)
    public void setGold(int gold) {this.gold = Math.max (gold,0);}
    public int getDef() {return def;}
    public void setDef(int def) {this.def = def;}
    public int getDex() {return dex;}
    public void setDex(int dex) {this.dex = dex;}
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

    public Armors getChest() {
        return chest;
    }

    public void setChest(Armors chest) {
        this.chest = chest;
    }

    public Armors getHelmet() {
        return helmet;
    }

    public void setHelmet(Armors helmet) {
        this.helmet = helmet;
    }

    public Armors getKnuckles() {
        return knuckles;
    }

    public void setKnuckles(Armors knuckles) {
        this.knuckles = knuckles;
    }

    public Armors getBoots() {
        return boots;
    }

    public void setBoots(Armors boots) {
        this.boots = boots;
    }

    public String getJob() {return job;}

    public void setJob(String job) {this.job = job;}

    public int getJobadd() {return jobadd;}

    public void setJobadd(int jobadd) {this.jobadd = jobadd;}

    public Inventory getInventory() {return inventory;}

    public int getRevives() {return revives;}

    public void setRevives(int revives) {this.revives = revives;}

}
