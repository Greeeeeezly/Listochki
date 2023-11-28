import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
        E getKey();
        AbstractBinaryTree<E>getLeft();
        AbstractBinaryTree<E>getRight();
        void setKey(E key);
        String asIndentedPreOrder(int indent);
        List<MyBinaryTree<E>> preOrder();
        List<MyBinaryTree<E>> inOrder();
        List<MyBinaryTree<E>> postOrder();
        void forEachInOrder(Consumer<E> consumer);
        }
/*•	E getKey() – возвращает ключ узла
•	AbstractBinaryTree<E>getLeft() – возвращает левое поддерево узла
•	AbstractBinaryTree<E>getRight() – возвращает правое поддерево узла
•	void setKey(E key) – устанавливает ключ узла
•	String asIndentedPreOrder(int indent) – возвращает дерево в виде строки, каждый внутренний уровень идентифицируется двумя пробелами в качестве отступа
•	List<AbstractBinaryTree<E>>preOrder() – возвращает дерево в preOrder порядке
•	List<AbstractBinaryTree<E>>inOrder() – возвращает дерево в in Order порядке
•	List<AbstractBinaryTree<E>>postOrder() – возвращает дерево в postOrder
•	void forEachInOrder(Consumer<E>consumer) – применяет Consumer<E> к каждому узлу, пройденному в порядке. Используется для выполнения операции над каждым элементом дерева в порядке возрастания (или убывания) значений элементов.
Например, печать элементов в отсортированном порядке:

publicvoidprintInOrder() {
forEachInOrder(element ->System.out.println(element));
}
*/