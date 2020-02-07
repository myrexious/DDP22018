import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AvengedSimulator {
    public static void main(String[] args) {
        SuperHero hero1 = new ManRay("Gyoubu Masataka Oniwa", 553);
        SuperHero hero2 = new FlyingDutchMan("Shirai", 225);
        SuperHero hero3 = new DirtyBubble("Arnastria", 666);
        SuperHero hero4 = new FlyingDutchMan("Tatenari", 36556);
        SuperHero hero5 = new ManRay("Gennichiro", 0);
        List<SuperHero> heroList = new ArrayList<>();
        heroList.add(hero1);
        heroList.add(hero2);
        heroList.add(hero3);
        heroList.add(hero4);
        heroList.add(hero5);  
        
        Collections.sort(heroList);
        for (SuperHero superHero : heroList) {
            showOff(superHero);
        }
        
    }

    public static void showOff(SuperHero superHero) {
        System.out.println("===============================");
        superHero.identity();
        System.out.println();
        superHero.showPowers();
        System.out.println("===============================");
        System.out.println();
    }
}