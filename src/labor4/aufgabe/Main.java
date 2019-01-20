package labor4.aufgabe;

import java.security.SecureRandom;

/**
 * @author :Lars Lehmann and Alessio Torzi
 */

public class Main {


    public static void main(String[] args){
        //erstellt den Baum
        SearchTree tree= new SearchTree();
        //zufallsgenerator
        SecureRandom rand = new SecureRandom();
        //array für die 40 werte die eingefügt werden sollen
        int []array= new int[40];
        //schleife fügt random werte ein
        for (int i=0;i<array.length;i++){
            //Erzeught random wert
            array[i]=rand.nextInt(100);
            //gibt ihn aus
            System.out.print(" "+array[i]+" ");
        }
        System.out.println("Das Ergebnis ist:");
        //abjetzt werden die werte nacheinander eingefüght
        for (int i=0;i<array.length;i++){
            //ausgabe der Wert der eingfüght wird
            System.out.println("Es wurde eingefügt: "+array[i]);
            //füght den wert in den Baum ein
            tree.insert(array[i]);
            //gibt den baum aus
            tree.print();
        }
        System.out.print("Löschen");
        //Array für die 10 werte die gelöscht werden sollen
        int []delet= new int[10];
        //schleife befüllt das Array
        for (int i = 0; i <delet.length ; i++) {
            //Erstellt die zufallszahlen
            delet[i]=rand.nextInt(100);
        }
        //Schleife die das löschen macht
        for (int i:delet) {
            //gibt den zulöschende werde aus
            System.out.println("löschePunkt: "+i);
            //löscht den wert aus dem Baum
            tree.delete(i);
            //gibt den Baum aus
            tree.print();
        }
        //gibnt den Baum aus
        tree.print();

    }
}
