package labor4.aufgabe;

import labor4.vorbereitung.BinaryNode;
import labor4.vorbereitung.IBinaryNode;

/**
 * @author: Lars Lehmann and Alessio Torzi
 */
public class SearchNode extends BinaryNode {
    /**
     * The Constructor create a new node in the tree
     *
     * @param value : Interger Value for this node
     */
    public SearchNode(int value) {
        super(value);
    }

    /**
     * Diese Methode entscheidet ob der gesucht wert auf der recht oder linkenseite ligen müsste oder ob der aktuelle
     * Wert der gesuchte ist wenn ja wird der aktuelle knoten returnt
     * @param i: Integer der gesuchte Wert
     * @return: IBinaryNode das Gefundene Ergebniss
     */
    @Override
    public IBinaryNode search(int i) {
        if(super.getValue()==i){
            return this;
        } else if(super.getValue()<i){
            return reSearch(i,0);
        } else{
            return reSearch(i,1);
        }
    }

    /**
     * Diese Methode gehört zu einer literativen folgen von Methodenaufrufen die methode bestimmt nur
     * Ob das zu löschende Value auf der rechten oder linken seite liegen müsste und callt das die isEqals
     * die überprüft ob das Value gleichsind wenn nicht wird es literative an das nächste objekt übergeben.
     * @param i: Integer der Value der gelöscht werden soll
     */
    @Override
    public void delete(int i) {
        if(i>super.getValue()){
            this.isEqals(1,i);
        }else {
            this.isEqals(0,i);
        }

    }

    /**
     * Gleiche funktion wie das gleichnamige Methode nur das es kein BinaryNode Objekt als parameter hat sonder ein
     * Integer wert. Sobalt es an der Richtigen stelle ist wird daraus ein IBinaryNoder Objekt erstellt
     * @param x : Integer der einzufügende Wert
     */
    @Override
    public void insert(int x) {
        if (super.getValue()> x){
            this.addinsert(x,0);
        } else {
           this.addinsert(x,1);
        }
    }

    /**
     * Methode macht das gleiche wie die gleichnamige nur mit andern Parameter, Überprüft ob an der übergebende stelle
     * == null wenn ja erstellt es ein SearchNode und fügt es ein. wenn nicht wird der Wert literative an das das objekt
     * übergeben
     * @param x :Integer der Wert der eingefüght soll werden
     * @param index: Integer Stelle an die soll eingefüght werden
     */
    private void addinsert(int x,int index){
        if(super.getNodes()[index]==null){
            super.addNode(index,new SearchNode(x));
        } else {
            super.getNodes()[index].insert(x);
        }
    }

    /**
     * Methoder überprüft ob das objekt an der übergebene stelle == null ist wenn ja kein ergbniss return null
     * wenn nicht wird das objekt literative weiter aufgeruften
     * @param i: Integer der Gesuchte Wert
     * @param index: Integer Stelle and die der nächste suchbefehl literative weitergegeben wird
     * @return IBinaryNode ist das such ergebniss. Erfolglose suche ist null
     */
    private IBinaryNode reSearch(int i, int index){
        if(super.getNodes()[index]==null){
            return null;
        } else {
            return super.getNodes()[index].search(i);
        }
    }

    /**
     * Methode macht das eigentliche algo für das löschen.
     * Die methode vergleicht ob der knoten darunter der zu löschende value ist wenn ja
     * speicher er von diesem die recht und linke seite jeweils in eine Variablen. Danach setzt er ihn null
     * und entfernt alle referenzen das ihn der Garbrisch collegter löschen kann.Als nächstes wird dieser knoten
     * ersetzt. Wenn beide seite null sind bleibt er null, wenn nur eine Seite null ist wird der Knoten durch den
     * der nicht null ist ersetzt. wenn beide nicht null sind wird er immer durch die rechteseite ersetzt und die linke
     * seite wird literative an die rechteSeite übergeben. die dann durch die Kinder elemente von rechts läuft bis sie
     * an der richtigen Position ist
     * @param i :Integer jenach dem welche seite verglichen wird
     * @param x :Integer der Value der Verglichen wird
     */
    private void isEqals(int i,int x){
        if(super.getNodes()[i]!=null&&super.getNodes()[i].getValue()==x){
            IBinaryNode l=super.getNodes()[i].getNodes()[0];
            IBinaryNode r=super.getNodes()[i].getNodes()[1];
            super.getNodes()[i].myDelet();
            if(l==null && r==null){
                super.setNode(null,i);
            }else if (l!=null && r==null){
                super.setNode(l,i);
            } else if(l==null && r!=null){
                super.setNode(r,i);
            } else{
                super.setNode(r,i);
                super.getNodes()[i].insert(l);

            }

        } else {
            if(super.getNodes()[i]!=null){
                super.getNodes()[i].delete(i);
            }
        }
    }

    /**
     * Diese Methode endscheidet ob der Knoten recht oder links hinzugefüght wird. Rechts wenn der param node Value größer
     * ist. Links wenn der value kleiner oder gleich ist. Dabei macht diese methode noch nicht das entscheidene Einfügen
     * Sondern bestimmt nur den möglichen platz und callt dann die addinsert methode
     * @param node: ein IBinarynode Objekt kann auch Kinderknoten haben
     */
    public void insert(IBinaryNode node) {
        if (super.getValue()<node.getValue()){
            this.addinsert((BinaryNode) node,1);
        }else {
            this.addinsert((BinaryNode) node,0);
        }

    }

    /**
     * Überprüft ob das objekt an der stelle i== null wenn ja wird der knoten an dieser stelle eingefüght in dem addNode
     * gecall wird. wenn nicht übergibt diese methode das Objekt an die insert des objektes das nicht null ist
     * @param node: IBinarynode das Objekt das eingfügt soll werden
     * @param index :Integer  stelle wo das objekt eingefügt werden soll
     */
    private void addinsert(BinaryNode node,int index){
        if(super.getNodes()[index]==null){
            super.addNode(index,node);
        } else {
            super.getNodes()[index].insert(node);
        }
    }
}
