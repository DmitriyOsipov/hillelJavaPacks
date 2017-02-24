package Ex8;

/**
 * Created by mtzadmin on 24.02.2017.
 */
public class SimpleLinkedList{
    private LinkedListElement first = null;
    private LinkedListElement last = null;
    private int size = 0;
    boolean sizeChanged = false;

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
    public boolean add(Object object){
        boolean result = false;
        try {
            LinkedListElement newElement = new LinkedListElement(object, null);
            if (last == null) {
                this.first = newElement;
                this.last = newElement;
            } else {
                last.setNext(newElement);
                last = newElement;
            }
            result = true;
            sizeChanged = true;
        }
        catch (Exception ex){
            result = false;
        }
        return result;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public boolean contains(Object object){
        LinkedListElement element = first;
        while(element!=null){
            if (element.getValue().equals(object)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    public boolean containsAll(SimpleLinkedList list){
        LinkedListElement inputElement = list.first;
        while (inputElement!=null){
            if (!this.contains(inputElement)){
                return false;
            }
        }
        return true;
    }

    public boolean remove(Object object){
        LinkedListElement element = first;
        boolean result = false;
        while (element.getNext()!=null){
            if (element.getNext().getValue().equals(object)){
                if (last==element.getNext()){
                    last = element;
                    last.setNext(null);
                    return true;
                }
                element.setNext(element.getNext().getNext());
                result = true;
            }
            element = element.getNext();
        }
        return result;
    }

    public boolean removeAll(SimpleLinkedList list){
        boolean result = false;
        LinkedListElement inputElement = list.first;

        while (inputElement!=null){
            //this.remove(inputElement.getValue());
            result = result | this.remove(inputElement.getValue());
            inputElement = inputElement.getNext();
        }
        return result;
    }

    public boolean retainAll(SimpleLinkedList list){
        boolean result = false;
        LinkedListElement element = this.first;
        while (element!=null){
            if(!list.contains(element.getValue())){
                this.remove(element.getValue());
                result = true;
            }
            element = element.getNext();
        }
        return result;
    }

    public boolean addAll(SimpleLinkedList list){
        LinkedListElement element = list.first;
        while (element!=null){
            if (!this.add(element.getValue())){
                return false;
            }
        }
        return true;
    }

    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
        sizeChanged = true;
    }

    public int getSize() {
        if (sizeChanged){
            this.size = 0;
            LinkedListElement element = first;
            while (element !=null){
                size++;
                element = element.getNext();
            }
        }
        return size;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        LinkedListElement element = first;
        builder.append("[");
        while (element!=null){
            builder.append(" " + element.getValue().toString() + " ");
            element = element.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

}
