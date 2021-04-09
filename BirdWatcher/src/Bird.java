public class Bird {
    //polja klase Bird
    private String name;
    private String latinName;
    private int observed;

    //konstruktor, budući da polje observed (zapravo brojač) broji uocene ptice, ono kreće od nule
    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observed = 0;
    }

    //getter za dohvat vrijednosti polja name
    public String getBirdName() {
        return this.name;
    }
    //metoda za uvećanje brojača
    public void increaseObserved() {
        this.observed++;
    }

    public String toString() {
        return this.name + " (" + this.latinName + "): " + this.observed + " observations";
    }
}