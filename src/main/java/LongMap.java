/**
 * Created by Admin on 01.04.2017.
 */
public interface LongMap<V> {
    V put(long key, V value);
    V get(long key);
    V remove(long key);

    boolean isEmpty();
    boolean containsKey(long key);
    boolean containsValue(V value);

    long[] keys();
    V[] values();

    long size();
    void clear();
}
