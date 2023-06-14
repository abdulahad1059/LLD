import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OurMap<K, V> {
    List<MyMap<K, V>> bucketList;
    int size;
    int capacity;
    int INITIAL_CAPACITY = 10;

    public OurMap() {
        this.bucketList = new ArrayList<>();
        this.capacity = 10;
        for (int i = 0; i < this.capacity; i++) {
            bucketList.add(null);
        }
        this.size = 0;
    }
    int getIndex(K key)
    {
        return (key.hashCode())%this.capacity;
    }
    void put(K key,V value)
    {
        int index=getIndex(key);
        MyMap<K,V> head=this.bucketList.get(index);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                head.value=value;
                return;
            }
            head=head.next;
        }
        size++;
        MyMap<K,V> m=new MyMap<>(key,value);
        head=this.bucketList.get(index);
        m.next=head;
        this.bucketList.set(index,m);
    }
    V get(K key)
    {
        int index=getIndex(key);
        MyMap<K,V> head=this.bucketList.get(index);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
               return head.value;
            }
            head=head.next;
        }
        return null;
    }
    Boolean remove(K key)
    {
        int index=getIndex(key);
        MyMap<K,V> head=this.bucketList.get(index);
        MyMap<K,V> prev=null;
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                if(prev==null)
                {
                    this.bucketList.set(index,head.next);
//                    return true;
                }
                else {
                    prev.next=head.next;
                    head.next=null;
//                    return true;
                }
                this.size--;
                return true;
            }
            prev=head;
            head=head.next;
        }
        return false;
    }


}

class MyMap<K, V> {
    K key;
    V value;
    MyMap next;

    public MyMap(K key, V value) {
        this.key = key;
        this.value = value;
        this.next=null;
    }
}

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
          Map<String,Integer> m=new HashMap<>();
          m.put("Ahad",3);
          m.put("Samad",3);
          for(Map.Entry<String,Integer> temp:m.entrySet())
          {
              System.out.println(temp);
          }

    }
}