package characters;

//DEFINICION ATRIBUTOS DE NUEVO PERSONAJE//
public abstract class BasicCharacter {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int maxMp;
//CONSTRUCTOR DE PERSONAJE NUEVO//
    public BasicCharacter(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
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
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getMaxMp() {
        return maxMp;
    }
    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }
}
