import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
public class MyBinaryTree<E> implements AbstractBinaryTree<E>{
    private List<E> listForPrint = new ArrayList<E>();
    private MyBinaryTree<E> left=null;
    private MyBinaryTree<E> right=null;

    private E key;
    public void add(E key){
        if(this.key.hashCode()>key.hashCode()){
            if(this.left==null){
                this.left = new MyBinaryTree<>(key);
            }
            else if(this.left != null)
                this.left.add(key);
        }
        else{
            if(this.right==null){
                this.right = new MyBinaryTree<>(key);
            }
            else if(this.right != null)
                this.right.add(key);
        }
    }
    public List<MyBinaryTree<E>> bfs() {
        List<MyBinaryTree<E>> listForOrder = new ArrayList<>();
        Queue<MyBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            MyBinaryTree<E> current = queue.poll();
            listForOrder.add(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return listForOrder;
    }

    public MyBinaryTree() {
    }

    public MyBinaryTree(E key) {
        this.key = key;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.right;
    }

    @Override
    public void setKey(E key) {
        this.key=key;
    }

    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();

        // Добавляем отступы для текущего узла
        for (int i = 0; i < indent; i++) {
            result.append("  "); // Используйте двойные пробелы для отступов
        }

        // Добавляем значение текущего узла
        result.append(key.toString());
        result.append("\n");

        // Рекурсивно вызываем для левого поддерева с увеличением уровня отступов
        if (left != null || right != null) {
            if (left != null) {
                result.append(left.asIndentedPreOrder(indent + 1));
            }
            if (right != null) {
                result.append(right.asIndentedPreOrder(indent + 1));
            }
        }
        return result.toString();
    }

/*    public void printLeaves(){
        if (node == null) {
            return;
        }
        if (element.compareTo(node.value) < 0) {
            return searchNode(node.leftChild, element);
        } else {
            return searchNode(node.rightChild, element);
        }
    }*/

    @Override
    public void forEachInOrder(Consumer<E> consumer) {

    }
    private void _print(MyBinaryTree<E> node){
        if(node == null) return;
        _print(node.left);
        //listForPrint.add(node.key);
        System.out.print(node + " ");
        if(node.right!=null)
            _print(node.right);
    }
    public void print(){
        listForPrint.clear();
        _print(this);
        System.out.println();
    }
    private void _printLeaves(MyBinaryTree<E> node){
        if(node == null) return;
        if(node.left==null && node.right==null){
            System.out.print(node + " ");
        }
        _printLeaves(node.left);

        if(node.right!=null)
            _printLeaves(node.right);
    }
    public void printLeaves(){
        _printLeaves(this);
        System.out.println();
    }
    public void printTree(MyBinaryTree<E> node){
        if (node==null) return;

    }
   private List<MyBinaryTree<E>> _printpreorder(){
       List<MyBinaryTree<E>> listForOrder = new ArrayList<>();
       if (this == null) return listForOrder;
       listForOrder.add(this);
       if (this.left != null) {
           listForOrder.addAll(this.left._printpreorder());
       }
       if (this.right != null) {
           listForOrder.addAll(this.right._printpreorder());
       }
       return listForOrder;
   }
    @Override
    public List<MyBinaryTree<E>> preOrder(){

        return _printpreorder();
    }
    private List<MyBinaryTree<E>> _printinorder(){
        List<MyBinaryTree<E>> listForOrder = new ArrayList<>();

        if (this == null) return listForOrder;

        if (this.left != null) {
            listForOrder.addAll(this.left._printinorder());
        }

        listForOrder.add(this);

        if (this.right != null) {
            listForOrder.addAll(this.right._printinorder());
        }

        return listForOrder;
    }
    @Override
    public List<MyBinaryTree<E>> inOrder(){
        return _printinorder();
    }

    private List<MyBinaryTree<E>> _printpostorder(){
        List<MyBinaryTree<E>> listForOrder = new ArrayList<>();

        if (this == null) return listForOrder;

        if (this.left != null) {
            listForOrder.addAll(this.left._printpostorder());
        }

        if (this.right != null) {
            listForOrder.addAll(this.right._printpostorder());
        }

        listForOrder.add(this);

        return listForOrder;
    }
    @Override
    public List<MyBinaryTree<E>> postOrder(){
        return _printpostorder();
    }


    @Override
    public String toString() {
        return "" + key +" ";
    }
    public void printTree(){

    }
    public void printLevelOrder() {
        int h = height(this);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(this, i, "");
            System.out.println();
        }
    }


    private int height(MyBinaryTree<E> node) {
        if (node == null) {
            return 0;
        } else {
            int lheight = height(node.left);
            int rheight = height(node.right);

            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    private void printGivenLevel(MyBinaryTree<E> node, int level, String indent) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(indent + node.key);
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1, indent + "  ");
            //System.out.println();
            printGivenLevel(node.right, level - 1, indent + "  ");
        }
    }
}
