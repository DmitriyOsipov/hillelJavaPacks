package Ex8;

/**
 * Created by mtzadmin on 24.02.2017.
 */
public class SimpleLinkedList {
    private LinkedListElement first = null;
    private LinkedListElement last = null;
    private int size = 0;

    public SimpleLinkedList(){

    }
    public SimpleLinkedList(Object object){
        this.add(object);
    }

    /**
     * add an object into linked list
     * @param object
     * some object to add
     */
    public void add(Object object){
        LinkedListElement newElement = new LinkedListElement(object, null);
        if (last==null){
            this.first = newElement;
            this.last = newElement;
        }
        else {
            last.setNext(newElement);
            last = newElement;
        }
    }

}
