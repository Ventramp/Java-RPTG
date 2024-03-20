package items.weapons;

import items.Items;
//CREACION DE OBJETOS TIPO ARMA//
public abstract class Weapons extends Items {
//ATRIBUTOS ESPECIALES DE WEAPON
    protected int wAttk;
    protected int wAP;

    public Weapons(String name, String description, int price, int lv, int wAttk,int wAP) {
        super(name, description, price, lv);
        this.wAttk = wAttk;
        this.wAP= wAP;
    }

    public int getwAttk() {return wAttk;}

    public void setwAttk(int wAttk) {this.wAttk = wAttk;}

    public int getwAP() {return wAP;}

    public void setwAP(int wAP) {this.wAP = wAP;}
}

