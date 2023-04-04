package Backend;

import java.util.ArrayList;

public class Generator {
    public static int random(int min, int max){
        return  (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static ArrayList<Zgloszenie> generatorNormalny(int zgloszenieSize, int discSize){
        ArrayList<Zgloszenie> zgloszenia = new ArrayList<>(zgloszenieSize);
        int timer = 0;
        for (int i = 0; i < zgloszenieSize; i++) {
            int rand = random(3,15);
            timer += rand;
            zgloszenia.add(new Zgloszenie(i+1,random(0,discSize),timer,random(0,3)));
        }
        return zgloszenia;
    }
    public static ArrayList<Zgloszenie> generatorZDeadlinami(int zgloszenieSize, int discSize){
        ArrayList<Zgloszenie> zgloszenia = new ArrayList<>(zgloszenieSize);
        int timer = 0;
        for (int i = 0; i < zgloszenieSize; i++) {
            int rand = random(0,5);
            timer += rand;
            zgloszenia.add(new Zgloszenie(i+1,random(0,discSize),timer,random(0,3),random(1,1)));
        }
        return zgloszenia;
    }
}
