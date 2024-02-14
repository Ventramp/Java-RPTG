package characters.Jobs;

import characters.Player;

public class Ranger extends Player {
}
protected int aim;
protected int addArrow
protected String aboutJob;
protected String jobname;

 public Ranger() {
        this.jobName = "Arquero";
        this.aim = 0;
        this.dex = (dex+5);
        this.def=(def+5);
}
 @Override
    public void displayData(){
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp,maxHp,mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d\n",str,mag,def);
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tLUCK:\t\t\t%d\n\tUNARMED:\t\t\t%d\n\n\tARMOR:\t\t%d\n\n",dex,luck,unarmed,armor);
   
 @Override
        public void attack(){
   int addArrow=rng(0,2);
     for (int i = 0; i < addArrow; i++) { 
       System.out.println("Combo"+i)
            if (rng(1, 100) <= (luck+aim) {
                this.crit =(this.dm= str* 2;
                this.aim +=1;
                System.out.printf("!CRITICO¡\n%s Ataca con flecha \nHace: %d de daño\nPunteria ha subido a:\n\tAim: %d\n\n",name, crit,unarmed);
            }else{
                this.dm=str;
                System.out.printf("%s Ataca Con flecha\nHace: %d de Daño \n\n",name, dm);
            }
     }
        }
