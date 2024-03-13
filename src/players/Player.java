package players;
//IMPORTS NECESARIOS PARA FUNCIONAMIENTO COMPLETO DE PLAYER Y SUS EXTENCIONES//
import java.util.Scanner;
import characters.BasicCharacter;
import enemies.Enemies;
import items.armors.Armors;
import items.weapons.Weapons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static util.Randomized.rng;
//INICIO DE PLAYER Y ATRIBUTOS//
public class Player extends BasicCharacter {
    protected int str;
    protected int gold;
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
    protected String job;
    protected int jobadd;

    //CONSTRUCTOR DE LAS CARACTERISTICAS DE PLAYER//
    public Player(String name) {
        super(name, 100,100);
        JOptionPane.showMessageDialog(null,"Nuevo Jugador Ingresando:");

            this.name = JOptionPane.showInputDialog("Ingresa tu nombre de usuario:");
        JOptionPane.showMessageDialog(null,"Creando Jugador");
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
        this.weapon = new Weapons();
        this.armor = new Armors();
        this.job="Sin Clase";
        displayData();
    }

    public void accion(@NotNull Enemies enemies){
        String [] opcion= {"Atacar", "Huir", "Stats"};
        int tipeAttack=JOptionPane.showOptionDialog(null,"Elige una accion","ACCION",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Huir");
        switch (opcion[tipeAttack]) {
            case "Atacar" -> {System.out.println();
            selectAttack(enemies);}
            case "Huir" -> {System.out.println();
                escape(enemies);}
            case "Stats"-> {System.out.println();
                displayData();
                accion(enemies);}
        }
    }
    //SOBREESCRIBIR DISPLAY DATA PARA PLAYER EN BASE DE BASIC PLAYER Adicionado con el aumento de atributos por elementos de Armas y Armaduras//
@Override
public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tAP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),ap,maxAp,weapon.getwMP());
    System.out.printf("\n\t\tCLASE:\t\t%s\n",job);
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\t\tEXP:\t\t\t%d/%d\n\n",level,exp,maxExp);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n\t\t\t\t\t\t\t%d G\n\n",dex,pCrit,weapon.getN(),armor.getN(),gold);
        }
    //not nulls para que estas acciones no sean posibles sin un enemigo//
    //seleccion de las formas de ataque disponibles//
    public void selectAttack(@NotNull Enemies enemies) {
        JOptionPane.showMessageDialog(null,name+" se esta preparando para atacar\n","Aviso",0);

        String [] opcion= {"Normal", "Artilleria","Regresar"};
        int sAttack=JOptionPane.showOptionDialog(null,"ATAQUE","Elige el tipo de ataque",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Artilleria");
        //switch con diferentes imputs por si acaso//
        switch (opcion[sAttack]) {
                case "Normal"->{attack(enemies);}
                case "Artilleria"->{artilleryA(enemies);}
                case "Regresar"->{accion(enemies);}
            }
    }
    //ataque normal//
    public void attack(@NotNull Enemies enemies){
        //llamada al calculo de daño fisico//
        fisicDm();
        if (rng(1, 100) <= pCrit) {
            //llamada al calculo para daños criticos//
            critical();
            System.out.printf("%s Ataca a %s con las manos vacias\n!!CRITICO¡¡\n\n",name,enemies.geteName());
            //llamada a la funcion de los enemigos recibe daño con el comodin critico//
            enemies.eRecibeDm(crit);
        }else{
            System.out.printf("%s Ataca a %s con las manos desnudas\n\n",name,enemies.geteName());
            enemies.eRecibeDm(dm);
        }
        if (enemies.eDie()){
            rewards(enemies);
            lvUpCheck();
        }
    }
    //Ataque de artilleria//
    public void artilleryA(@NotNull Enemies enemies) {
        String [] opcion= {"Pistola", "Rifle","Cañon","Regresar"};
        int artillery=JOptionPane.showOptionDialog(null,name+" Atacara con Artilleria","ARTILLERIA",0,JOptionPane.QUESTION_MESSAGE,null,opcion, "Rifle");

        System.out.println();
        switch (opcion[artillery]) {
            case "Pistola":
                if (ap>= 30) gun(enemies);
                else JOptionPane.showMessageDialog(null,"AP insuficiente");
                selectAttack(enemies);
            case "Rifle":
                if (ap>= 50) rifle(enemies);
                else JOptionPane.showMessageDialog(null,"AP insuficiente");
                selectAttack(enemies);
            case "Cañon":
                if (ap>= 100) canyon(enemies);
                else JOptionPane.showMessageDialog(null,"AP insuficiente");
                selectAttack(enemies);
            case "4":
            case "Regresar":
                selectAttack(enemies);
        }
    }
    public void escape(@NotNull Enemies enemies){
        enemies.seteHP(0);
        enemies.eDie();
        System.out.printf("%s Escapo de %s\n\n",name,enemies.geteName());
    }
    //voids para calculos especificos de daño en las funciones de ataque//
    private void fisicDm(){dm=str+weapon.getwA();}
    private void critical (){crit=dm*2;}
    /* Ataques de tipo artilleria*/
    private void gun(@NotNull Enemies enemies){
        ap-=30;
        dm=str+5;
        enemies.eRecibeDm(dm);
        if (enemies.eDie()){
            rewards(enemies);
            lvUpCheck();
        }
    }
    private void rifle(@NotNull Enemies enemies){
        ap-=50;
        dm=str*2;
        enemies.eRecibeDm(dm);
        if (enemies.eDie()){
            rewards(enemies);
            lvUpCheck();
        }
    }
    private void canyon(@NotNull Enemies enemies){
        ap-=100;
        dm=str*4;
        enemies.eRecibeDm(dm);
        if (enemies.eDie()){
            rewards(enemies);
            lvUpCheck();
        }
    }
    //Obtencion de recompensas//
    private void rewards(@NotNull Enemies enemies){
        System.out.printf("///EXP \t %d  +  %d///\n///Gold \t %d  +  %d///\n\n",exp,enemies.getGiveExp(),gold,enemies.getDropG());
        this.exp+= enemies.getGiveExp();
        this.gold+= enemies.getDropG();
    }
    //Funcion que comprueba el exp actual contra el exp maximo//
    private void lvUpCheck(){
        if (exp >= maxExp) {
            levelUp();
        }
    }
    /**Que ocurre cuando se suba de nivel**/
    public void levelUp() {
        exp -= maxExp ;
        level++;
        //exp maxima aumentara gradualmente segun cuantos niveles suba//
        maxExp += 20*(level-1);
        System.out.println("\nSUBISTE DE NIVEL\n");
        for (int i = 0; i < 4; i++) {
            int x = (rng(1, 6));
            switch (x) {
                case 1 -> {str++;                       System.out.printf("STR\t Ha aumentado a:\t%d\n", str);}
                case 2 -> {def++;                       System.out.printf("DEF\t Ha aumentado a:\t%d\n", def);}
                case 3 -> {dex++;                       System.out.printf("DEX\t Ha aumentado a:\t%d\n", dex);}
                case 4 -> {pCrit++;                     System.out.printf("P.CRIT Ha aumentado a:\t%d\n", pCrit);}
                case 5 -> {hp += 20;    maxHp += 20;    System.out.printf("HP\t maxima aumentada:\t%d\n", maxHp);}
                case 6 -> {ap += 10;    maxAp += 10;    System.out.printf("MP\t maxima aumentada:\t%d\n", maxAp);}
            }
        }
        System.out.println();
        /*if (cangetjob())
            System.out.printf("%s ha alcanzado el nivel 10");
            getjob();
         */
    }
    /*private boolean cangetjob(){return level==10;}

    private void getjob(){
    souf ("Elige tu clase")
        scan
        switch{
        monk
        swordman
        gunner
        }
    }
    private void monk(){
    System.out.println("El MONJE es un luchador cuerpo a cuerpo que no usa armas\nCada que acierte un critico  sin una arma equipada su cualidad:\nDESARMADO subira de nivel, la cual aumentara su fuerza de sus golpes");
    seleccion si o no adquirir trabajo
    if (si) getmonk;
    if (no) getjob();}
    private void getmonk(){
    job="Monje";
    jobadd=0
    str += 10;
    hp += 30;
    maxHp += 30;
    mag -= 5;
    maxAp -= 20;
    this.ap -=20;
    @Override
    public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tAP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),ap,maxAp,weapon.getwMP());
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t%d/%d\n\n",level,exp,maxExp);
    System.out.printf("\n\t\tJob:\t\t\t%s\n",job);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\tUNARMED:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n\t\t\t\t\t\t\t%d G\n\n",dex,pCrit,jobadd,weapon.getN(),armor.getN(),gold);
    }
     private void gunner(){
   System.out.println("El ARTILLERO es un atacante a distancia con la capacidad de  usar artilleria mas seguido\nSu cualidad AIM le permitira acertar criticos con artilleria");
    seleccion si o no adquirir trabajo
    if (si) getgunner();
    if (no) getjob();}
    }
    private void getgunner(){
    job= "Artilllero";
    jobadd=1;
    ap+=20
    maxAp+=20
    str-=3;
    dex +=5;
    def+=5;
     @Override
    public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tAP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),ap,maxAp,weapon.getwMP());
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t%d/%d\n\n",level,exp,maxExp);
    System.out.printf("\n\t\tJob:\t\t\t%s\n",job);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\tAIM:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n\t\t\t\t\t\t\t%d G\n\n",dex,pCrit,jobadd,weapon.getN(),armor.getN(),gold);
    }
    private void swordman(){
      System.out.println("El ESPADACHIN es un Guerrero cuerpo a cuerpo\nPierde capacidades magicas y MP pero gana Fuerza y Defensa\nEl espadachin tiene la caracteristica SANGRADO que se activa despues de un critico\nCada turno que pase el enemigo afectado por SANGRADO perdera vida de manera creciente");
        seleccion si o no adquirir trabajo
    if (si) getgunner();
    if (no) getjob();}
    }

    private void getswordman(){
    job = "Espadachin";
    jobadd= 1;
    def+=7;
    str+=7;
    ap-=50;
    maxAp=-50
    @Override
    public void displayData() {
    System.out.printf("\n///////\t\t%s\t\t///////\n",name);
    System.out.printf("\t\tHP:\t\t\t%d/%d+(%d)\n\t\tAP:\t\t\t%d/%d+(%d)\t\t\t\n",hp+ armor.getaHp(),maxHp,armor.getaHp(),ap,maxAp,weapon.getwMP());
    System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t%d/%d\n\n",level,exp,maxExp);
    System.out.printf("\n\t\tJob:\t\t\t%s\n",job);
    System.out.printf("\t\tSTR:\t\t\t%d   +\t(%d)\n\t\tDEF:\t\t\t%d   +\t(%d)\n",str,weapon.getwA(),def,armor.getaD());
    System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t%d\n\tBLEEDING:\t\t\t%d\n\n\tWEAPON:\t\t%s\n\tARMOR:\t\t%s\n\n\t\t\t\t\t\t\t%d G\n\n",dex,pCrit,jobadd,weapon.getN(),armor.getN(),gold);
    }
     */

    //como recibe daño un player segun su defensa//
    @Override
    public void recibeDm(int eDm) {
        int edmreduction;
        edmreduction=eDm-def;
        if (edmreduction <= 0) edmreduction=0;
        hp -= edmreduction;
        System.out.printf("%s recibio %d puntos de daño\n",name,edmreduction);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tAP:\t\t\t%d/%d\n\n",hp,maxHp,ap,maxAp);
    }
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
