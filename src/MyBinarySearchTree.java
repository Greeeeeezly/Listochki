public class MyBinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E>{
    private Node<E> node;

    public MyBinarySearchTree(Node<E> node){
        this.node = node;
    }
    public MyBinarySearchTree(){
        this.node = null;
    }

    @Override
    public void insert(E element)
    {
        node = insertNode(node, element);
    }

    private Node<E> insertNode(Node<E> node, E element)
    {
        if (node == null)
        {
            return new Node<>(element);
        }
        if (element.compareTo(node.value) < 0)
        {
            node.leftChild = insertNode(node.leftChild, element);
        }
        else if (element.compareTo(node.value) > 0)
        {
            node.rightChild = insertNode(node.rightChild, element);
        }
        return node;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(node, element);
    }
    private boolean containsRec(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        if (element.equals(node.value)) {
            return true;
        } else if (element.compareTo(node.value) < 0) {
            return containsRec(node.leftChild, element);
        } else {
            return containsRec(node.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> result = searchNode(node, element);
        return result != null ? new MyBinarySearchTree<>(result) : null;
    }

    private Node<E> searchNode(Node<E> node, E element) {
        if (node == null || element.equals(node.value)) {
            return node;
        }
        if (element.compareTo(node.value) < 0) {
            return searchNode(node.leftChild, element);
        } else {
            return searchNode(node.rightChild, element);
        }
    }

    @Override
    public Node<E> getNode() {
        return node;
    }

    @Override
    public Node<E> getLeft() {
        return node.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return node.rightChild;
    }

    @Override
    public E getValue() {
        return node.value;
    }

    @Override
    public String toString() {
        return "MyBinarySearchTree{" +
                "node=" + node +
                '}';
    }
}
