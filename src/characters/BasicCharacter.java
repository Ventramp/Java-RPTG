package characters;

//DEFINICION ATRIBUTOS DE NUEVO PERSONAJE//
public class BasicCharacter {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int maxMp;
//CONSTRUCTOR DE PERSONAJE NUEVO//
    public BasicCharacter() {
        this.name = "DAVE";
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 100;
        this.maxMp = 100;
    }
//DISPLAY DATA DE PERSONAJE NUEVO//
    public void displayData() {
        System.out.println("\n\t\t\t** NPC **\t\t\t");
        System.out.printf("///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n\n",hp,maxHp,mp,maxMp);
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
