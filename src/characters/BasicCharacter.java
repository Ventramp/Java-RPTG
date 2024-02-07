package characters;


import java.util.Scanner;

public class BasicCharacter {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int maxMp;

    public BasicCharacter() {
        this.name = "Jugador";
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 100;
        this.maxMp = 100;
    }

    public void newName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa tu nombre de usuario:");
        this.name = scanner.nextLine();
    }
    public void displayData() {
        System.out.println("Creando personaje Nuevo\n");
        System.out.println(".\n...\n.....\n");
        System.out.println("Nuevo personaje:");
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n\n",hp,maxHp,mp,maxMp);
    }
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
