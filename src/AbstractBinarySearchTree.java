public interface AbstractBinarySearchTree<E extends Comparable<E>> {
        public static class Node<E> {
        public E value;
        public Node<E>leftChild;
        public Node<E>rightChild;

        public Node(E value) {
        this.value= value;
        }

        @Override
        public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", leftChild=" + leftChild +
                        ", rightChild=" + rightChild +
                        '}';
        }
        public Node(E value, Node<E>leftChild, Node<E>rightChild) {
        this.value= value;
        this.leftChild= leftChild;
        this.rightChild= rightChild;
        }
        }

        void insert(E element);
        boolean contains(E element);
        AbstractBinarySearchTree<E>search(E element);
        Node<E> getNode();
        Node<E>getLeft();
        Node<E>getRight();
        E getValue();
}

