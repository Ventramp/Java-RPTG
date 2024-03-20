package items.weapons;

import items.Items;
//CREACION DE OBJETOS TIPO ARMA//
public class Weapons extends Items {
//ATRIBUTOS ESPECIALES DE WEAPON
    protected int wAttk;
    protected int wAP;
    public Weapons() {
        this.name = "Sin Arma";
        this.description = "N/A";
        this.price = 0;
        this.wAttk = 0;
        this.wAP = 0;
        this.lv = 0;
    }
    //Actualizacion
    public abstract class Weapon extends Items {
        protected int atk;
        public Weapon(String name, String description, int price, int atk) {
            super(name, description, price);
            this.atk = atk;
        }
    public void displayWInfo(){
        //aparecer informacion de item tipo Arma//
    }
    public int getwA() {return wAttk;}

    public int getwAttk() {
        return wAttk;
    }

    public int getwAP() {
        return wAP;
    }
}

