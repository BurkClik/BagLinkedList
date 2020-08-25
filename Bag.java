import org.jetbrains.annotations.NotNull;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * BAG
*/

public class Bag<E> {

    private Node head = null;
	private int Lsize = 0 ;

    /**
     * 
     * @return
     */
    public boolean isEmpty() {
        return head == null ? true : false;
    }


    /**
     * 
     * @param data
     */
    public void add(E data) {
        if (isEmpty()) {
            Node<E> newNode = new Node<E>(data);
            head = newNode;
			Lsize++;
			
        } else {
            Node<E> current = head;
            Node<E> newNode = new Node<E>(data);
            newNode.setNext(current);
             head = newNode;
		     Lsize++;
            
        }
    }


    /**
     * 
     * @param data
     * @return
     */
    public boolean remove(E data) {
        Node<E> current = head;
		
        if (contains(data)) {
            if (data == current.getData()) {
                // Head
                if (current.getNext() != null) {
                    current.setData(null);
                    head = current.getNext();
					Lsize--;
                    return true;
                } else {
                    head = null;
					Lsize--;
                    return true;
                }
            } else {
                while (current.getNext().getData() != data) {
                    current = current.getNext();
                }
                current.setNext(current.getNext().getNext());
				Lsize--;
                return true;
            }
        }
        return false;
    }


    /**
     * 
     */
    public void clear() {
        Node<E> current = head;
		Lsize = 0;
        while(current != null) {
            System.out.println("Current -> " + current.getData());
            remove(current.getData());
            if (current.getNext() == null) {
                remove(current.getData());
                break;
            }
            current = current.getNext();
        }
    }


    /**
     * 
     * @return
     */
    public int distictSize() {
        Node<E> current = head;
        int counter=0;
        ArrayList<E> distinct = new ArrayList<E>();

        while (current != null) {
            if(!distinct.contains(current.getData())) {
                distinct.add(current.getData());
                counter++;
            }
            current = current.getNext();
        }
        return counter;
    }


    /**
     * 
     * @param data
     * @return
     */
    public boolean contains(E data) {
        return elementSize(data) != 0 ? true : false;
    }


    /**
     * 
     * @param data
     * @return
     */
    public int elementSize(E data) {
        int counter = 0;
        Node<E> current = head;

        while (current != null) {
            if (current.getData() == data) {
                counter++;
            }
            current = current.getNext();
        }
        return counter;
    }


    /**
     * 
     * @return
     */
    public int size() {
        return Lsize;
    }


    /**
     * @return
     */
    public String toString() {
        if (isEmpty()) {
            return "Bag is empty";
        }

        Node<E> current = head;
        String string = "*************BAG*************\n\n";

        while (current != null) {
            string += "\t   " + current.getData() + "\n";
            current = current.getNext();
        }
        return string;
    }

    public boolean equals(@NotNull Bag obj) {

        Node<E> current = head;
        while(current.getNext()!=null){
            if(this.elementSize(current.getData())!= obj.elementSize(current.getData())){
                System.out.println("It's not equal");
                return false;
            }
            current = current.getNext();
        }
        System.out.println("It's equal");
        return true;
    }
}