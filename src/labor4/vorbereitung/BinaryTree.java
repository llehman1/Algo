package labor4.vorbereitung;


import labor4.aufgabe.SearchNode;

/**
 * @author: Lars Lehmann
 * <h1>Class BinaryTree</h1>
 * This class implement a Binary Tree. This class has the reference to the first node in the tree.
 */
public class BinaryTree {


    //firstNode in the tree
    private IBinaryNode firstNode;


    public void insert(int x) {
        if (firstNode == null) {
            this.firstNode = this.createNode(x);
        } else {
            this.firstNode.insert(x);
        }


    }


    public void print() {
        if (this.firstNode != null) {
            System.out.println("Tree:");
            this.firstNode.print();
        } else {
            System.out.println("tree is Empty");
        }

    }

    public IBinaryNode search(int i){
        return null;
    }

    public void delete(int i){
        if(this.firstNode!=null&&this.firstNode.getValue()==i){
            IBinaryNode l=this.getFirstNode().getNodes()[0];
            IBinaryNode r=this.getFirstNode().getNodes()[1];
            this.firstNode.myDelet();
            if(l==null && r!=null){
                this.firstNode=r;
            }else if(l!=null && r==null){
                this.firstNode=l;
            }else if(l!=null && r!=null){
                this.firstNode=r;
                this.firstNode.insert(l);
            }else {
             this.firstNode=null;
            }
        }else if(this.firstNode!=null){
            this.firstNode.delete(i);
        }

    }


    public IBinaryNode getFirstNode() {
        return this.firstNode;
    }

    public IBinaryNode createNode(int i){
        return new BinaryNode(i);
    }
    public void setFirstNode(IBinaryNode node){
        this.firstNode=node;
    }



}
