import java.util.Random;

public class Podziemie {
    public Hero hero;
    public Random random = new Random();
    public StringBuilder podziemie = new StringBuilder();
    int MAX_SIZE_X ,MIN_SIZE_X;
    public Podziemie(Hero hero){
        this.hero = hero;

    }
    public void initializePodziemie(){
        System.out.println(podziemie);
    }
    public void start(){
        processPodziemie();
        initializePodziemie();
    }

    public void processPodziemie(){
        int randomPosY = random.nextInt(0,32);
        int randomPosX = random.nextInt(0,280);
        for(int i = 0;i <= 32;i++){
            MIN_SIZE_X = random.nextInt(10,30);
            MAX_SIZE_X = random.nextInt(100,200);
            for(int j = 0;j <= 280;j++){
                if (j == randomPosX && i == randomPosY) {
                    podziemie.append(hero.symbol);
                }
                if(j <= MIN_SIZE_X){
                    podziemie.append(" ");
                    if(j == MIN_SIZE_X)podziemie.append("|");
                }
                if(j <= MAX_SIZE_X){
                    podziemie.append("_");
                    if(j == MAX_SIZE_X)podziemie.append("|");
                }
                if(j != 279){
                    podziemie.append(" ");
                }
                podziemie.append('\n');
            }
        }
    }
}
