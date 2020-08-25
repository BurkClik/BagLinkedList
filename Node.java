/**
 * Node
 */

public class Node<E> {

    private Node<E> next;
    private E data;

    public Node(E data) {
        this.data = data;
        next = null;
    }

    public void setNext(Node<E> newNext) {
        next = newNext;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getData() {
        return data;
    }

}