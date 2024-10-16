import java.util.Random;
import java.util.Scanner;

public class Map {
    StringBuilder map = new StringBuilder();
    public Hero hero;
    //rozmiar linii po x
    private final int X = 280;
    //rozmiar linii po y
    private final int Y = 32;
    //random dla tego , zeby generowac losowo
    Random random = new Random();

    //ilosc podziemia
    private final int PODZIEMIA_COUNT;
    public Map(Hero hero){
        this.hero = hero;
        map = new StringBuilder(initializeMap());
        PODZIEMIA_COUNT = random.nextInt(4, 9);
    }

    public void initializePodziemia(){
        //do liczby podziemia generujemy podziemia
        for(int i = 0;i < PODZIEMIA_COUNT;i++){
            int generatedPosForPodziemie = random.nextInt(0,8400);
            //pomijamy symbol nowej linii
            while (map.charAt(generatedPosForPodziemie) == '\n'    &&
                   map.charAt(generatedPosForPodziemie + 1) != '\n'&&
                   map.charAt(generatedPosForPodziemie + 2) != '\n'&&
                   map.charAt(generatedPosForPodziemie + 3) != '\n'&&
                   map.charAt(generatedPosForPodziemie + 4) != '\n'&&
                   map.charAt(generatedPosForPodziemie + 5) != '\n'&&
                   map.charAt(generatedPosForPodziemie + 6) != '\n'&&
                   map.charAt(generatedPosForPodziemie -1) != '\n' &&
                   map.charAt(generatedPosForPodziemie - 2) != '\n'&&
                   map.charAt(generatedPosForPodziemie - 3) != '\n'&&
                   map.charAt(generatedPosForPodziemie - 4) != '\n'&&
                   map.charAt(generatedPosForPodziemie - 5) != '\n'&&
                   map.charAt(generatedPosForPodziemie - 6) != '\n' ) {
                generatedPosForPodziemie = random.nextInt(0,8400);
            }
            //kiedy wszystko okej wstawjamy dotąd podiemie
            map.setCharAt(generatedPosForPodziemie,'[');
            for(int j = 1;j <= 4;j++){
                map.setCharAt(generatedPosForPodziemie + j,'/');
            }
            map.setCharAt(generatedPosForPodziemie+5,']');
        }
    }
    //ta metoda inicjalizuje mapę i zwraca ją
    public String initializeMap(){
        StringBuilder main = new StringBuilder();
        for (int j = 0; j < Y; j++) {
            StringBuilder sb = new StringBuilder("_");
            for (int i = 0; i < X; i++) {
                sb.append("_");
                if(j == 13 && i==3){
                    sb.append(hero.symbol);
                    i+=2;
                }
            }
            sb.append("\n");
            main.append(sb);
        }
        return main.append("\n Health: " + hero.HEALTH + "     ").append("Damage: " + hero.DAMAGE + "     ").toString();
    }

    public void printMap(){
        System.out.println(map);
    }
    public void processMove(String move){
        switch (move){
            case "W":
                processAnyMove(-282);
                break;
            case "A":
                processAnyMove(-5);
                break;
            case "S":
                processAnyMove(282);
                break;
            case "D":
                processAnyMove(5);
                break;
            default: printMap();
        }
    }
    public void processAnyMove(int change){
        int pastPos = map.indexOf("&");
        int futurePos = pastPos + change;
        Character character = map.charAt(futurePos);
        if(character.equals('/') || character.equals('[') || character.equals(']')){
            Podziemie podziemie = new Podziemie(hero);

            podziemie.start();
        }

        hero.input = new Scanner(System.in);
        map.deleteCharAt(pastPos);
        map.insert(pastPos,"_");
        map.deleteCharAt(futurePos);
        map.insert(futurePos,hero.symbol);

        printMap();
    }


}
