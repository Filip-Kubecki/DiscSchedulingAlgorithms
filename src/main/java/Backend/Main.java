package Backend;

import java.util.ArrayList;
import java.util.Collections;

import static Backend.Generator.*;

public class Main {
    static int discSize = 200;
    static int zgloszeniaSize = 200;
    static ArrayList<Zgloszenie> zgloszenia = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ArrayList<Zgloszenie> zgloszenia = Generator.generatorZDeadlinami(zgloszeniaSize,discSize);
            System.out.println("FCFS");
            System.out.println(Algorytmy.FCFS(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
            System.out.println("SSTF");
            System.out.println(Algorytmy.SSTF(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
            System.out.println("SCAN");
            System.out.println(Algorytmy.SCAN(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
            System.out.println("CSCAN");
            System.out.println(Algorytmy.CSCAN(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
            System.out.println("EDF");
            System.out.println(Algorytmy.EDF(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
            System.out.println("FD_SCAN");
            System.out.println(Algorytmy.FD_SCAN(zgloszenia,zgloszeniaSize,discSize).allHeadMovements);
        }
        System.out.println("Koniec");
    }
//    Methods for easy debugging
    public static void displayDeadlines(ArrayList<Zgloszenie> zgloszenia){
        for (Zgloszenie zgloszenie : zgloszenia) {
            System.out.print(zgloszenie.getDeadline()+" ");
        }
        System.out.println();
    }
}
