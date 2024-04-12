package enemies;
//DEFINICION DE LOS ENEMIGOS ABSTRACTA//
import characters.BasicCharacter;
import players.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Enemies extends BasicCharacter {

    protected Image image;
    protected final ImageManager imageManager = ImageManager.getInstance();
    private final int eMaxHp;
    private final int eDm;
    private final int dropG;
    private final int giveExp;
/*Para evitar confuciones dentro del codigo diferenciamos la informacion de los enemigos de
* la del jugador colocando a sus atributos una e*/
    //UTILIZAMOS EL THIS PARA ACCEDER A LAS VARIABLES//


    public Enemies(String name, int hp, int ap, int eMaxHp, int eDm, int dropG, int giveExp) {
        super(name, hp, ap);
        this.eMaxHp = hp;
        this.eDm = eDm;
        this.dropG = dropG;
        this.giveExp = giveExp;
    }

    //ACCIONES QUE REALIZARA EL PERSONAJE//
    public void eRecibeDm (int dm){
        //comodin dm para recordar que es el daño que hace el player//
        hp-=dm;
        JOptionPane.showMessageDialog(null,name+" recibio "+dm+" puntos de daño \n"
        +"               EHP:"+hp+"/"+eMaxHp);
        //si se cumple el boleano de muerte hacer//
        if (eDie())
            JOptionPane.showMessageDialog(null,name+" fue derrotado\n");
    }
    public boolean eDie(){
        return hp <= 0;
    }
    //funcion de ataque en general de todos los hijos de enemigo//
    public abstract void eAttack(Player player);
    public abstract void dropItem(Player player);

    public int geteMaxHp() {
        return eMaxHp;
    }

    public int geteDm() {
        return eDm;
    }

    public int getDropG() {
        return dropG;
    }

    public int getGiveExp() {
        return giveExp;
    }

    public Image getImage() {
        return image;
    }
    public ImageManager getImageManager() {

        return imageManager;
    }
}

