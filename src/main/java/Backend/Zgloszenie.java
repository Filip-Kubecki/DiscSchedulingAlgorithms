package Backend;

public class Zgloszenie implements Comparable<Zgloszenie> {
    int lp;
    int czasOczekiwania;
    int sektorDysku;
    int momentZgloszenia;
    int czasWykonania;
    int deadline;

    public Zgloszenie(int lp, int sektorDysku, int momentZgloszenia, int czasWykonania) {
        this.lp = lp;
        this.czasOczekiwania = 0;
        this.sektorDysku = sektorDysku;
        this.momentZgloszenia = momentZgloszenia;
        this.czasWykonania = czasWykonania;
    }
    public Zgloszenie(int lp,int sektorDysku, int momentZgloszenia, int czasWykonania, int deadline) {
        this.lp = lp;
        this.czasOczekiwania = 0;
        this.sektorDysku = sektorDysku;
        this.momentZgloszenia = momentZgloszenia;
        this.czasWykonania = czasWykonania;
        this.deadline = deadline;
    }
    public int getCzasOczekiwania() {
        return czasOczekiwania;
    }
    public void setCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania = czasOczekiwania;
    }
    public void IncreaseCzasOczekiwania(int waitingTime){
        czasOczekiwania += waitingTime;
    }
    public int getSektorDysku() {
        return sektorDysku;
    }
    public int getMomentZgloszenia() {
        return momentZgloszenia;
    }
    public int getCzasWykonania() {
        return czasWykonania;
    }
    public int getDeadline() {
        return deadline;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
    public boolean endOfDeadline(){
        return this.deadline <= 0;
    }
    public void decreaseDeadline(int waitingTime){
        this.deadline -= waitingTime;
    }
    @Override
    public int compareTo(Zgloszenie o) {
        return Integer.compare(this.deadline, o.getDeadline());
    }
}
