package Ex11.hashMap;

import java.util.Iterator;

/**
 * Created by Dreamer on 19.03.2017.
 */
public interface MyMapInOutable {
    boolean add(Object key, Object value);
    boolean remove(Object key);
    Object get(Object key);

    Iterator<MyMapElement> iteratorMapElements();

}
