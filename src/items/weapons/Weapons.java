package items.weapons;

import items.Items;
//CREACION DE OBJETOS TIPO ARMA//
public class Weapons extends Items {
//ATRIBUTOS ESPECIALES DE WEAPON
    protected int wAttk;
    protected int wDex;
    public Weapons() {
        this.name = "Sin Arma";
        this.description = "N/A";
        this.price = 0;
        this.wDex = 0;
        this.wAttk = 0;
        this.lv = 0;
    }
    public void displayWInfo(){
        //aparecer informacion de item tipo Arma//
    }
    public int getwA() {return wAttk;}

    public int getwD() {return wDex;}
}

