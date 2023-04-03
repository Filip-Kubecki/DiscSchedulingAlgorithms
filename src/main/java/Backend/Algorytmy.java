package Backend;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Algorytmy {
    public static ArrayList<GraphData> FCFS(ArrayList<Zgloszenie> zgloszenia, int size,int discSize){
        ArrayList<Zgloszenie> zgloszeniaCopy = (ArrayList<Zgloszenie>) zgloszenia.clone();
        ArrayList<Zgloszenie> queue = new ArrayList<>();
        int sizeQueueEnd = 0;           //Ilość zgłoszeń
        int timer = 0;          //Czas zegara
        int headPosition = 0;   //Pozycja głowicy
        int headMovements = 0;  //Suma przesunięć głowicy
        ArrayList<GraphData> output = new ArrayList<>();

        do {
//            Dodawanie procesów do kolejki
//            dodawanie na podstawie ich momentu zgłoszenia przyrównanego do czasu zegara
            for (int i = zgloszeniaCopy.size()-1; i > -1; i--) {
//                Jeśli czas zgłoszenia pokrywa się z czasem zegara, dodaj proces do kolejki (queue) i usuń z ArrayListy(zgłoszenia)
                if (zgloszeniaCopy.get(i).getMomentZgloszenia() <= timer){
                    queue.add(zgloszeniaCopy.get(i));
                    zgloszeniaCopy.remove(zgloszeniaCopy.get(i));
                }
            }

//          Obsługa zgłoszeń
            if (queue.size() != 0){
                Zgloszenie report = queue.get(0);
                headMovements += abs(report.getSektorDysku() - headPosition);
                headPosition = report.getSektorDysku();
                output.add(new GraphData(timer,headPosition));

//                Zwiększenie czasu oczekiwania procesów w kolejce
                for (int i = 1; i < queue.size(); i++) {
                    queue.get(i).setCzasOczekiwania(queue.get(i).getCzasOczekiwania() + report.getCzasWykonania());
                }
                timer += report.getCzasWykonania();
                queue.remove(0);
                sizeQueueEnd++;
            }else{
                timer++;
            }
        }while(size > sizeQueueEnd);

        return output;
    }

    public static ArrayList<GraphData> SSTF(ArrayList<Zgloszenie> zgloszenia, int size,int discSize){
        ArrayList<Zgloszenie> zgloszeniaCopy = (ArrayList<Zgloszenie>) zgloszenia.clone();
        ArrayList<Zgloszenie> queue = new ArrayList<>();
        int sizeQueueEnd = 0;          //Ilość zgłoszeń wykonanych
        int timer = 0;                 //Czas zegara
        int headPosition = 0;          //Pozycja głowicy
        int headMovements = 0;         //Suma przesunięć głowicy
        ArrayList<GraphData> output = new ArrayList<>();

        do {
//            Dodawanie procesów do kolejki
//            dodawanie na podstawie ich momentu zgłoszenia przyrównanego do czasu zegara
            for (int i = zgloszeniaCopy.size()-1; i > -1; i--) {
//                Jeśli czas zgłoszenia pokrywa się z czasem zegara, dodaj proces do kolejki (queue) i usuń z ArrayListy(zgłoszenia)
                if (zgloszeniaCopy.get(i).getMomentZgloszenia() <= timer){
                    queue.add(zgloszeniaCopy.get(i));
                    zgloszeniaCopy.remove(zgloszeniaCopy.get(i));
                }
            }
//          Obsługa zgłoszeń
            if (queue.size() != 0){
//                Znajdywanie najbliższego zgłoszenia
                int indexOf = 0;//Index najbliższego sektora w kolejce
                for (Zgloszenie zgloszenie : queue) {
                    if (abs(zgloszenie.getSektorDysku()-headPosition)<abs(queue.get(indexOf).getSektorDysku()-headPosition)){
                        indexOf = queue.indexOf(zgloszenie);
                    }
                }

                Zgloszenie report = queue.get(indexOf);
                headMovements += abs(report.getSektorDysku() - headPosition);
                headPosition = report.getSektorDysku();

                output.add(new GraphData(timer,headPosition));

//                Zwiększenie czasu oczekiwania procesów w kolejce
                for (int i = 1; i < queue.size(); i++) {
                    queue.get(i).setCzasOczekiwania(queue.get(i).getCzasOczekiwania() + report.getCzasWykonania());
                }
                timer += report.getCzasWykonania();
                queue.remove(indexOf);
                sizeQueueEnd++;
            }else{
                timer++;
            }
        }while(size > sizeQueueEnd);

        return output;
    }

    public static ArrayList<GraphData> SCAN(ArrayList<Zgloszenie> zgloszenia, int size, int discSize){
        ArrayList<Zgloszenie> zgloszeniaCopy = (ArrayList<Zgloszenie>) zgloszenia.clone();
        ArrayList<Zgloszenie> queue = new ArrayList<>();
        int sizeQueueEnd = 0;          //Ilość zgłoszeń wykonanych
        int timer = 0;                 //Czas zegara
        int headPosition = 0;          //Pozycja głowicy
        int headMovements = 0;         //Suma przesunięć głowicy
        boolean headDirection = true;  //true = right, false = left
        ArrayList<GraphData> output = new ArrayList<>();

        do {
//            Dodawanie procesów do kolejki
//            dodawanie na podstawie ich momentu zgłoszenia przyrównanego do czasu zegara
            for (int i = zgloszeniaCopy.size()-1; i > -1; i--) {
//                Jeśli czas zgłoszenia pokrywa się z czasem zegara, dodaj proces do kolejki (queue) i usuń z ArrayListy(zgłoszenia)
                if (zgloszeniaCopy.get(i).getMomentZgloszenia() <= timer){
                    queue.add(zgloszeniaCopy.get(i));
                    zgloszeniaCopy.remove(zgloszeniaCopy.get(i));
                }
            }
//            Wyszukiwanie zgłoszeń w miejscu głowicy
            int indexOf = -1;
            for (Zgloszenie zgloszenie : queue) {
                if (zgloszenie.getSektorDysku() == headPosition){
                    indexOf = queue.indexOf(zgloszenie);
                }
            }
//            Wykonanie zgłoszeń w przypadku wykrycia
            if (indexOf != -1){
                Zgloszenie zgloszenie = queue.get(indexOf);

                output.add(new GraphData(timer,headPosition));

                timer += zgloszenie.getCzasWykonania();
                queue.remove(zgloszenie);
                sizeQueueEnd++;
//                System.out.println("Kierunek "+headDirection+" Size:"+size+" Queue Size:"+sizeQueueEnd);
            }else{
                if (headPosition == discSize){
                    headDirection = false;
                } else if (headPosition == 0) {
                    headDirection = true;
                }
                if (headDirection)
                    headPosition++;
                else
                    headPosition--;

                timer++;
                headMovements++;
            }
        }while(size > sizeQueueEnd);

        return output;
    }

    public static ArrayList<GraphData> CSCAN(ArrayList<Zgloszenie> zgloszenia, int size,int discSize){
        ArrayList<Zgloszenie> zgloszeniaCopy = (ArrayList<Zgloszenie>) zgloszenia.clone();
        ArrayList<Zgloszenie> queue = new ArrayList<>();
        int sizeQueueEnd = 0;          //Ilość zgłoszeń wykonanych
        int timer = 0;                 //Czas zegara
        int headPosition = 0;          //Pozycja głowicy
        int headMovements = 0;         //Suma przesunięć głowicy
        boolean headDirection = true;  //true = right, false = left
        ArrayList<GraphData> output = new ArrayList<>();

        do {
//            Dodawanie procesów do kolejki
//            dodawanie na podstawie ich momentu zgłoszenia przyrównanego do czasu zegara
            for (int i = zgloszeniaCopy.size()-1; i > -1; i--) {
//                Jeśli czas zgłoszenia pokrywa się z czasem zegara, dodaj proces do kolejki (queue) i usuń z ArrayListy(zgłoszenia)
                if (zgloszeniaCopy.get(i).getMomentZgloszenia() <= timer){
                    queue.add(zgloszeniaCopy.get(i));
                    zgloszeniaCopy.remove(zgloszeniaCopy.get(i));
                }
            }
//            Wyszukiwanie zgłoszeń w miejscu głowicy
            int indexOf = -1;
            for (Zgloszenie zgloszenie : queue) {
                if (zgloszenie.getSektorDysku() == headPosition){
                    indexOf = queue.indexOf(zgloszenie);
                }
            }
//            Wykonanie zgłoszeń w przypadku wykrycia
            if (indexOf != -1){
                Zgloszenie zgloszenie = queue.get(indexOf);
                output.add(new GraphData(timer,headPosition));
                timer += zgloszenie.getCzasWykonania();
                queue.remove(zgloszenie);
                sizeQueueEnd++;
//                System.out.println("Kierunek "+headDirection+" Size:"+size+" Queue Size:"+sizeQueueEnd);
            }else{
                if (headPosition == discSize){
                    headPosition = 0;
                    headMovements += discSize;
                }else{
                    headPosition++;
                    timer++;
                    headMovements++;
                }
            }
        }while(size > sizeQueueEnd);

        return output;
    }
}
