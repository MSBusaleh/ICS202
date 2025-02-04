public class BSTtester {
    public static void main(String[] args) {
        BST<Integer> myBST = new BST<>();

        for(int i = 0; i < 10; i++)
            myBST.insert((int)(1+Math.random()*100));

        System.out.println("The number of nodes is: " + myBST.count() +
                            "\n'4' is leaf? " + myBST.isLeaf(4) +
                            "\n'7' is leaf? " + myBST.isLeaf(7) +
                            "\nNumber of leaves is: " + myBST.countLeaves() +
                            "\n\nThe various traversals are: ");
        System.out.print("Preorder: ");
        myBST.preorder();
        System.out.print("\nInorder: ");
        myBST.inorder();
        System.out.print("\nPostorder: ");
        myBST.postorder();
        System.out.print("\nBreadth-First: ");
        myBST.breadthFirst();

        System.out.println("\n\n\n");
    }
}