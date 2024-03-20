package characters;

import java.io.Serializable;

//DEFINICION ATRIBUTOS DE NUEVO PERSONAJE//
public abstract class BasicCharacter implements Serializable {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int ap;
    protected int maxAp;
//CONSTRUCTOR DE PERSONAJE NUEVO//
    public BasicCharacter(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.ap = ap;
        this.maxAp = ap;
    }
//DISPLAY DATA DE PERSONAJE NUEVO//
    public abstract void displayData();
    public void recibeDm(int eDm){
        hp-=eDm;
    }
    public boolean muerte() {
        return hp <= 0;
    }

    //GETTERS Y SETTERS DE PERSONAJE NUEVO//
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getMaxAp() {
        return maxAp;
    }

    public void setMaxAp(int maxAp) {
        this.maxAp = maxAp;
    }
}

