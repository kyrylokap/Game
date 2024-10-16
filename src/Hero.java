import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hero {
    String symbol;
    public int DAMAGE ;
    public int HEALTH;
    public List<String>controls = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    public Hero(String symbol){
        this.symbol = symbol;
        this.intitializeControls();
        this.DAMAGE = 100;
        this.HEALTH = 100;
    }
    public void intitializeControls(){
        int counter = 0;
        for (String s : Arrays.asList("A", "W", "S", "D", " ","1", "2", "3")) {
            this.controls.add(counter,s);
            counter++;
        }
    }
    public String move(){
        boolean isMoveCorrect = false;
        String move = new String();
                while(!isMoveCorrect) {
                    move = input.nextLine();
                    for (int j = 0; j <= 3; j++) {
                        if (move.toUpperCase().equals(controls.get(j))) {
                            isMoveCorrect = true;
                            return move;
                        }
                    }
                }
        return move.toUpperCase();
    }
}
