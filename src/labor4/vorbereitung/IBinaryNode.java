package labor4.vorbereitung;

/**
 * @author: Lars Lehmann
 * <h1>Interface IBinaryNode</h1>
 * <p>
 * This interface implements the basic methods for a node in the binary tree.
 * It should be noted that the tree object is actually a node with only one
 * reference and has no numeric value itself.
 */

public interface IBinaryNode {


    /**
     * inserts a single element into the tree at a random location.
     * if there is already a node then it will be passed to the insert method of that object.
     *
     * @param x : integer to be inserted in the tree
     */
    void insert(int x);

    /**
     * This method prints all nodes in the tree. The nodes are executed recursively like a depth search
     */
    void print();

    IBinaryNode[] getNodes();

    public IBinaryNode search(int i);
    public void delete(int i);
    public int getValue();
    public void myDelet();
    public void setNode(IBinaryNode node,int i);
    public void insert(IBinaryNode node);


}
