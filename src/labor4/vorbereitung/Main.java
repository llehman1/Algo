package labor4.vorbereitung;

public class Main {


    public static void main(String[] args){
        //Erstelle ein BinaryBaum
        BinaryTree tree = new BinaryTree();
        //füge 101 werte in den Baum
        for (int i=0;i<=100;i++){
            tree.insert(i);
        }
        //printe alle nodes aus wenn man mehrfach printet kann man erkennen das die Werte an einer komplet zufälligen stelle eingefügt werden
        tree.print();

    }
}
