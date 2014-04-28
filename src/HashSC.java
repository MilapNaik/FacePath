import java.util.ArrayList;

/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS. Milap Naik & Sushmitha Radhakrishnan
*/

//CLASS TO CREAT SEPERATE CHAINING HASH TABLE 
public class HashSC {
    private static final int INIT_CAPACITY = 4;

    private int N;                                // number of key-value pairs
    private int M;                                // hash table size
    private SequentialSearchST<String, userProfile>[] st;  // array of linked-list symbol tables


    // create separate chaining hash table
    public HashSC() {
        this(INIT_CAPACITY);
    } 

    // create separate chaining hash table with M lists
 @SuppressWarnings("unchecked")
 public HashSC(int M) {
        this.M = M;
        st = (SequentialSearchST<String, userProfile>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<String, userProfile>();
    } 
 
    // hash value between 0 and M-1
    public int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % M;
    } 
    
    // return number of key-value pairs in symbol table
    public int size() {
        return N;
    } 

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(String key) {
        return get(key) != null;
    } 

    // return value associated with key, null if no such key
 public userProfile get(String key) {
        int i = hash(key);
        return (userProfile) st[i].get(key);
    } 

    // insert key-value pair into the table
    public void put(String key, userProfile value) {
        if (value == null) { 
         delete(key); 
         return; 
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
         N++;
         st[i].put(key,value);
        } 
    } 

    // delete key (and associated value) if key is in the table
    public void delete(String key) {
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);
    }
    
 // return keys in symbol table as an ArrayList 

    public ArrayList<String> keys() {
        ArrayList <String> q = new ArrayList<String>();
        for (int i = 0; i < M; i++) {
            for (String key : st[i].keys()) 
                q.add(key);
        }
        return q;
    } 
    
}
