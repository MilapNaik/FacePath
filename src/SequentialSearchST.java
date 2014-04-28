import java.util.ArrayList;

/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS. Milap Naik & Sushmitha Radhakrishnan
*/

@SuppressWarnings("hiding")
public class SequentialSearchST<String,userProfie> {
     
  private int N;           // number of key-value pairs
     private Node first;      // the linked list of key-value pairs //Node

     // a helper linked list data type
     private class Node {
         private String key;
         private userProfile val;
         private Node next;

         public Node(String key, userProfile val, Node next)  {
             this.key  = key;
             this.val  = val;
             this.next = next;
         }
     }

     // return number of key-value pairs
     public int size() { return N; }

     // is the symbol table empty?
     public boolean isEmpty() { return size() == 0; }

     // does this symbol table contain the given key?
     public boolean contains(String key) {
         return get(key) != null;
     }

     // return the value associated with the key, or null if the key is not present
     public userProfile get(String key) {
         for (Node x = first; x != null; x = x.next) {
             if (key.equals(x.key)) {
              return x.val;
             } 
         }
         return null;
     }

     // add a key-value pair, replacing old key-value pair if key is already present
     public void put(String key, userProfile val) {
         for (Node x = first; x != null; x = x.next)
             if (key.equals(x.key)) { x.val = val; return; }
         first = new Node(key, val, first);
         N++;
     }

     // remove key-value pair with given key (if it's in the table)
     public void delete(String key) {
         first = delete(first, key);
     }

     // delete key in linked list beginning at Node x
     private Node delete(Node x, String key) {
         if (x == null) return null;
         if (key.equals(x.key)) { N--; return x.next; }
         x.next = delete(x.next, key);
         return x;
     }
     
     // return all keys as an ArrayList 
     public ArrayList<String> keys()  {
         ArrayList<String> q = new ArrayList<String>();
         for (Node x = first; x != null; x = x.next)
             q.add(x.key);
         return q;
     }
}
