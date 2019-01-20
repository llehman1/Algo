package labor4.aufgabe;

import labor4.vorbereitung.BinaryNode;
import labor4.vorbereitung.BinaryTree;
import labor4.vorbereitung.IBinaryNode;

/**
 * @author : Lars Lehmann and Alessio Torzi
 */

public class SearchTree extends BinaryTree {


    /**
     * Der erste aufruf einer literativen folgen gibt den suche befehl immer an das nächste Objekt weiter bis
     * es irrgentwann am ziel angekommen ist und return dann die das ergebniss oder bis das nächste objekt == null
     * dann return null
     * @param i: Integer Gesuchter value
     * @return IBinaryNode gesucht objekt wenn suche fehlgeschlagen return null
     */
    @Override
    public IBinaryNode search(int i) {
        return super.getFirstNode().search(i);
    }

    /**
     *  Methode ist der erste aufruf einer Interativenfolge
     *      Die methode vergleicht ob der first node den Value der gelöscht werden soll ist wenn ja
     *      speicher er von diesem die recht und linke seite jeweils in eine Variablen. Danach setzt er ihn null
     *      und entfernt alle referenzen das ihn der Garbrisch collegter löschen kann.Als nächstes wird dieser knoten
     *      ersetzt. Wenn beide seite null sind bleibt er null, wenn nur eine Seite null ist wird der Knoten durch den
     *      der nicht null ist ersetzt. wenn beide nicht null sind wird er immer durch die rechteseite ersetzt und die linke
     *      seite wird literative an die rechteSeite übergeben. die dann durch die Kinder elemente von rechts läuft bis sie
     *      an der richtigen Position ist
     * @param i: Integer der zu löschene Value
     */
    @Override
    public void delete(int i) {
        if(super.getFirstNode()!=null&&super.getFirstNode().getValue()==i){
            IBinaryNode l=this.getFirstNode().getNodes()[0];
            IBinaryNode r=this.getFirstNode().getNodes()[1];
            super.getFirstNode().myDelet();
            if(l==null && r!=null){
                super.setFirstNode(r);
            }else if(l!=null && r==null){
                super.setFirstNode(l);
            }else if(l!=null && r!=null){
                super.setFirstNode(r);
                super.getFirstNode().insert(l);
            }else {
                super.setFirstNode(null);
            }
        }else if(super.getFirstNode()!=null){
            super.getFirstNode().delete(i);
        }

    }

    /**
     * Methoder erstellte ein neues SearchNode
     * @param i: Integer der wert für das objekt.
     * @return SearchNode das den übergebenen wert hat
     */
    @Override
    public IBinaryNode createNode(int i){
        return new SearchNode(i);
    }

}
