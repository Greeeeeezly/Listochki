public class Main {
    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree(5);
        myBinaryTree.add(8);
        myBinaryTree.add(3);
        myBinaryTree.add(6);
        myBinaryTree.add(2);
        myBinaryTree.add(1);
        myBinaryTree.add(4);
        myBinaryTree.add(9);
        //myBinaryTree.print();
        myBinaryTree.preOrder().forEach(System.out::print);
        System.out.println();
        myBinaryTree.inOrder().forEach(System.out::print);
        System.out.println();
        myBinaryTree.postOrder().forEach(System.out::print);
        System.out.println();
        myBinaryTree.printLevelOrder();
        //System.out.println(myBinaryTree.asIndentedPreOrder(2));
        myBinaryTree.printLeaves();
        System.out.println(myBinaryTree.bfs());


   /*     MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        myBinarySearchTree.insert(6);
        myBinarySearchTree.insert(11);
        myBinarySearchTree.insert(3);
        myBinarySearchTree.insert(7);
        myBinarySearchTree.insert(9);
        myBinarySearchTree.insert(18);
        myBinarySearchTree.insert(4);
        System.out.println(myBinarySearchTree.search(6));
        System.out.println(myBinarySearchTree.contains(7));
    }
    public static void compare(Integer a, Integer b){
        if (a>b){
            System.out.println(">");
        } else if (a<b) {
            System.out.println("<");
        }
        else System.out.println("=");
    }*/
    }
}
