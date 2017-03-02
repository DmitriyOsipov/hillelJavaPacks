package Ex8_2.Queues;

public class MyDeque extends MyQueue{

    public MyDeque(){}
    public MyDeque(Object o){
        list.add(o);
    }

    public void pushFront(Object o){
        list.addLeft(o);
    }
    public Object popBack(){
        if (!list.isEmpty()) {
           return list.remove(list.size()-1);
        }
        return null;
    }

}
