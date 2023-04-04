package Backend;

import java.util.ArrayList;
import java.util.Collections;

import static Backend.Generator.*;

public class Main {
    static int discSize = 2000;
    static int zgloszeniaSize = 200;
    static ArrayList<Zgloszenie> zgloszenia = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Zgloszenie> zgloszenia = Generator.generatorZDeadlinami(zgloszeniaSize,discSize);
//        displayDeadlines(zgloszenia);
//        Collections.sort(zgloszenia);
//        displayDeadlines(zgloszenia);
        System.out.println("FCFS");
        Algorytmy.FCFS(zgloszenia,zgloszeniaSize,discSize);
        System.out.println("EDF");
        Algorytmy.EDF(zgloszenia,zgloszeniaSize,discSize);
//        System.out.println("SSTF");
//        System.out.println("Suma przesunięć głowicy: "+Algorytmy.SSTF(zgloszenia,zgloszeniaSize,discSize));
//        System.out.println("SCAN");
//        System.out.println("Suma przesunięć głowicy: "+Algorytmy.SCAN(zgloszenia,zgloszeniaSize,discSize));
//        System.out.println("CSCAN");
//        System.out.println("Suma przesunięć głowicy: "+Algorytmy.CSCAN(zgloszenia,zgloszeniaSize,discSize));
    }
//    Methods for easy debugging
    public static void displayDeadlines(ArrayList<Zgloszenie> zgloszenia){
        for (Zgloszenie zgloszenie : zgloszenia) {
            System.out.print(zgloszenie.getDeadline()+" ");
        }
        System.out.println();
    }
}
