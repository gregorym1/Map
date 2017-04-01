import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01.04.2017.
 */
public class LongMapImpl<V> implements LongMap<V> {

    private  List<Node<V>> nodeList = new ArrayList<>();

    public class Node<V>{
        private long key;
        V value;
        public Node(long key,V value){
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public V put(long key, V value) {
        if (!containsKey(key)) {
            nodeList.add(new Node(key, value));
            return value;
        }
        else
            //System.out.println(value + " didn't add with key " + key + ". This key is used.");
            return null;
    }

    public V get(long key) {
        for (Node<V> node: nodeList
             ) {
            if (node.getKey() == key)
                return node.getValue();
        }
        //System.out.println("Key doesn't exist.");
        return null;
    }

    public V remove(long key) {
        int count = 0;
        for (Node<V> node: nodeList
                ) {
            if (node.getKey() == key) {
                nodeList.remove(count);
                return null;
            }
            count++;
        }
        //System.out.println("Node doesn't exist.");
        return null;
    }

    public boolean isEmpty() {
        return nodeList.isEmpty();
    }

    public boolean containsKey(long key) {
        for (Node<V> node: nodeList
                ) {
            if (node.getKey() == key)
                return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node<V> node: nodeList
                ) {
            if (node.getValue() == value)
                return true;
        }
        return false;
    }

    public long[] keys() {
        long[] keys = new long[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            keys[i] = nodeList.get(i).getKey();
        }
        return keys;
    }

    public V[] values() {
        V[] values = (V[]) Array.newInstance(nodeList.get(0).getValue().getClass(), nodeList.size());        // Cannot create a generic array of Type;
        for (int i = 0; i < nodeList.size(); i++) {
            values[i] = nodeList.get(i).getValue();
        }
        return values;
    }

    public long size() {
        return nodeList.size();
    }

    public void clear() {
        nodeList.clear();
    }
}
