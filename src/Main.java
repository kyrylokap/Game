
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("&");
        Map mapa = new Map(hero);
        mapa.initializeMap();
        mapa.initializePodziemia();
        System.out.println(mapa.map);
        while(true){
            mapa.processMove(hero.move());
        }
    }
}