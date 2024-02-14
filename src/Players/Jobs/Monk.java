package Players.Jobs;
import Players.Player;

public class Monk extends Player {
    private String jobName;
    private int unarmed;


    public Monk() {
        this.jobName = "Monje";
        this.unarmed = 0;
        this.str = (str+5);
        this.maxHp=(hp+30);
        System.out.println("Adquiriendo trabajo:");
        System.out.println(".\n...\n.....\n");
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp,maxHp,mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d\n",str,mag,def);
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tUNARMED:\t\t\t%d\n\n\tARMOR:\t\t%d\n\n",dex,pCrit,unarmed,armor);
    }
    @Override
    public void displayData(){
        System.out.printf("\n///////\t\t%s\t\t///////\n",name);
        System.out.printf("\t\tHP:\t\t\t%d/%d\n\t\tMP:\t\t\t%d/%d\t\t\t\n",hp,maxHp,mp,maxMp);
        System.out.printf("\n\t\tJob:\t\t\t%s\n",jobName);
        System.out.printf("\t//\t\t\tLV:%d\t\t//\n\tEXP:\t\t\t\t\t%d\n\n",level,exp);
        System.out.printf("\t\tSTR:\t\t\t%d\n\t\tMAG:\t\t\t%d\n\t\tDEF:\t\t\t%d\n",str,mag,def);
        System.out.printf("\t\tDEX:\t\t\t%d\n\t\tPROB.CRIT:\t\t\t%d\n\tUNARMED:\t\t\t%d\n\n\tARMOR:\t\t%d\n\n",dex,pCrit,unarmed,armor);
    }

    @Override
        public void attack(){
            if (rng(1, 100) <= pCrit) {
                this.crit =this.dm= (unarmed*2 + str* 2);
                this.unarmed +=1;
                System.out.printf("!CRITICO¡\n%s Ataca desarmado\nHace: %d de daño\nDesarmado ha subido a:\n\tUnarmed:%d\n\n",name, crit,unarmed);
            }else{
                this.dm=(unarmed*2+str);
                System.out.printf("%s Ataca desarmado\nHace: %d de Daño \n\n",name, dm);
            }
        }
        public void aboutJob(){
            System.out.println("El monje es un luchador cuerpo a cuerpo que no usa armas\nCada que acierte un critico  sin una arma equipada su cualidad:\nDESARMADO subira de nivel, la cual aumentara su fuerza de sus golpes");
        }

}
