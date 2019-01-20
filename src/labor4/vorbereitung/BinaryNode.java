package labor4.vorbereitung;

import labor4.aufgabe.SearchNode;

import java.security.SecureRandom;

/**
 * @author: Lars Lehmann
 * <h1>BinaryNode</h1>
 * This class implement one node in a Binary Tree. The node has a left and a right node.
 * if there is no right or left knot. they are null.
 */
public class BinaryNode implements IBinaryNode {

    // Integer value of the nodes
    private int value;
    //0 is the left node and 1 is the right node
    private IBinaryNode[] nodes;

    /**
     * The Constructor create a new node in the tree
     * @param value: Interger Value for this node
     */
    public BinaryNode(int value) {
        this.value = value;
        this.nodes = new IBinaryNode[2];
    }

    @Override
    public void insert(int x) {
        SecureRandom rand = new SecureRandom();
        int index = rand.nextInt(2);
        if (nodes[index] == null) {
            nodes[index] = new BinaryNode(x);
        } else {
            nodes[index].insert(x);
        }
    }

    @Override
    public void print() {
        System.out.print(this.value+"(left: ");
        if(nodes[0]!=null){
            nodes[0].print();
        }
        System.out.print(" , right: ");
        if(nodes[1]!=null){
            nodes[1].print();
        }
        System.out.print(" )");
    }

    public int getValue() {
        return value;
    }
    @Override
    public IBinaryNode[] getNodes() {
        return nodes;
    }

    public void addNode(int i, IBinaryNode node){
        this.nodes[i]=node;
    }
    @Override
    public IBinaryNode search(int i){
        return null;
    }
    @Override
    public void delete(int i){

    }
    public void myDelet(){
        this.nodes=null;
        this.value=0;
    }

    @Override
    public void setNode(IBinaryNode node, int i) {
        this.nodes[i]=node;

    }

    @Override
    public void insert(IBinaryNode node) {

    }


}
