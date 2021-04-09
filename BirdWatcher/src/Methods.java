
/*
    Klasa Methods kja će sadržavati metode, odnosno funkcionalnosti za dodavanje ptica, ispit jedne ili svih ptica,
    naredbu za prekid programa te brojač koliko puta je ptica promatrana
 */




import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    //polja klase
    private Scanner scanner;
    //lista koja će pohranjivati dodane ptice
    private ArrayList<Bird> birds;

    public Methods(Scanner scanner) {
        this.scanner = scanner;
        this.birds = new ArrayList<Bird>();
    }

    public void pocetakPrograma() {
        System.out.print("? ");
        String naredba = this.scanner.nextLine();
        while (true) {
            if (naredba.equals("Add")) {
                addBird();
                break;
            } else if (naredba.equals("Observation")) {
                addObservation();
                break;
            } else if (naredba.equals("All")) {
                allBirdsPrint();
                break;
            } else if (naredba.equals("One")) {
                oneBirdPrint();
                break;
            } else if (naredba.equals("Quit")) {
                break;
            } else {
                System.out.print("? ");
                naredba = this.scanner.nextLine();
            }
        }
    }

    //metoda za dodavanje ptica u listu
    public void addBird() {
        System.out.print("Name: ");
        String birdName = this.scanner.nextLine();

        //ukoliko unesemo prazno ime, upit se ponavlja
        while (true) {
            if (birdName.isEmpty()) {
                System.out.print("Name: ");
                birdName = this.scanner.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Name in Latin: ");
        String birdLatinName = this.scanner.nextLine();
        while (true) {
            if (birdLatinName.isEmpty()) {
                System.out.print("Name in Latin: ");
                birdLatinName = this.scanner.nextLine();
            } else {
                break;
            }
        }
        //nakon unosa imena i latinskog imena ptice, objekt nove ptice je kreiran i spremljen u listu
        this.birds.add(new Bird(birdName, birdLatinName));
        pocetakPrograma();
    }

    //metoda za promatranje/observation
    public void addObservation() {
        String ispis = "";
        System.out.print("Bird? ");
        String observed = this.scanner.nextLine();

        while (true) {
            if (observed.isEmpty()) {
                System.out.print("Bird? ");
                observed = this.scanner.nextLine();
            } else {
                break;
            }
        }

        for (Bird bird : this.birds) {
            if (bird.getBirdName().equals(observed)) {
                bird.increaseObserved();
                ispis = "";
                break;
            } else {
                ispis = "Not a bird!";
            }
        }

        if (!ispis.isEmpty()) {
            System.out.println(ispis);
        }

        pocetakPrograma();
    }
    //metoda za ispis cijele liste ptica 
    public void allBirdsPrint() {
        for (Bird bird : this.birds) {
            System.out.println(bird.toString());
        }
        pocetakPrograma();
    }
    //metoda za ispis jedne ptice
    public void oneBirdPrint() {
        String ispis = "";
        System.out.print("Bird? ");
        String zahtjev = this.scanner.nextLine();

        while (true) {
            if (zahtjev.isEmpty()) {
                System.out.print("Bird? ");
                zahtjev = this.scanner.nextLine();
            } else {
                break;
            }
        }

        for (Bird bird : this.birds) {
            if (bird.getBirdName().equals(zahtjev)) {
                ispis = bird.toString();
                break;
            } else {
                ispis = "Not a bird!";
            }
        }

        System.out.println(ispis);
        pocetakPrograma();
    }
}
