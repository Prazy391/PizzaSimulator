
/**
 * Write a description of class List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class List
{
    public class Node{
         Bill data;
         Node next; 
         /**
          * Constructors
          */
         public Node(Bill newData){
             this.data = newData;
             next = null;
         }
         
         public Node(){
             this.data = null;
             next = null;
         }
         
         public Node(Node newData){
             this.data = newData.data;
             this.next = newData.next;
         }
    }
    Node head;
    /**
     * Constructors
     */
    public List(){
        head = new Node();
    }
    
    public List(List list){
        this.head = list.head;
        if(head.next != null){
            Node ptr = new Node(head.data);
            Node ptrList = new Node(list.head.data);
            for(int i = 0; i < list.size(); i ++){
                if(ptr.next != null && ptrList.next != null){
                    ptr = ptr.next;
                    ptrList = ptrList.next;
                }
            }
        }
    }
    /**
     * Pre: Object exists
     * Parameter: Object newData, int index
     * Post: Inserts object to the index
     */
    public void insert(Bill newData, int index){
        if(size() == 0){
            head.data = newData;
        }
        else if(size() == 1){
            Node newNode = new Node(newData);
            head.next = newNode;
        }
        else if(index > size()){
            Node newNode = new Node(newData);
            Node ptr = new Node(head);
            while (ptr.next!=null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
            System.out.println("Index input larger than size so material added at end");
        }
        else{
            if(index == 0){
                Node newNode = new Node(newData);
                newNode.next = head; 
                head = newNode;
            }
            else{
                Node newNode = new Node(newData);
                Node prev = new Node(head);
                Node next = new Node(head.next);
                int count = 0;
                while(count == index){
                    prev = prev.next;
                    next = next.next;
                }
                newNode.next = next;
                prev.next = newNode;
            }
        }
    }
    /**
     * Pre: Object exists
     * Parameter: int index
     * Post: removes object from the index
     */
    public Object remove(int index){
        if(size() == 0){
            System.out.println("Nothing to remove");
            return null;
        }
        else if(size() == 1){
            Object removed = head.data;
            head.data = null;
            return removed;
        }
        else if(index > size()){
            Node ptr = new Node(head);
            while (ptr.next.next!=null) {
                ptr = ptr.next;
            }
            Object removed = ptr.next.data;
            ptr.next = ptr.next.next;
            return removed;
        }
        else{
            Node prev = new Node(head);
            Node next = new Node(head.next.next);
            int count = 0;
            while(count != index-1){
                count ++;
                prev = prev.next;
                next = next.next;
            }
            Object removed = prev.next.data;
            prev.next = next;
            return removed;
        }
    }
    /**
     * Pre: Object exists
     * Parameter: Object newData
     * Post: Inserts object to the end
     */
    public void append(Bill newData){
        Node newNode = new Node(newData);
        Node ptr = new Node(head);
        while (ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }
    /**
     * Pre: Object exists
     * Parameter: Object newData, int index
     * Post: deletes object from the index
     */
    public void delete(int index){
        if(size() == 0){ 
            System.out.println("Nothing to remove");
        }
        else if(size() == 1){
            head.data = null;
        }
        else if(index > size()){
            Node ptr = new Node(head);
            while (ptr.next.next!=null) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        else{
            Node prev = new Node(head);
            Node next = new Node(head.next.next);
            int count = 0;
            while(count != index-1){
                count ++;
                prev = prev.next;
                next = next.next;
            }
            prev.next = next;
        }
    }
    /**
     * Pre: Object exists
     * Post: returns the size 
     */
    public int size(){
        int count = 1;
        Node ptr = new Node(head);
        while(ptr.next != null){
            ptr = ptr.next;
            count++;
        }
        return count;
    }
    /**
     * Pre: Object exists
     * Post: returns all value in the list
     */
    public String toString(){
        Node ptr = new Node(head);
        String result = "";
        while(ptr.next != null){
            result = result+" "+ptr.data;
            ptr = ptr.next;
        }
        return result;
    }
    /**
     * Pre: Object exists
     * Post: returns true if list empty
     * false if it's not
     */
    public boolean isEmpty(){
        int count = 0;
        Node ptr = new Node(head);
        while(ptr.data != null){
            ptr = ptr.next;
            count++;
        }
        
        if(count ==0)
            return true;
        return  false;
    }
    /**
     * Pre: Object exists
     * Parameter: Object target
     * Post: returns index of the target or -1 
     * if it's not in the list
     */
    public int indexOf(Object target){
        int count = 0;
        Node ptr = new Node(head);
        while (ptr.data!=null) {
            if(ptr.data == target)
                return count;
            else{
                count++;
                ptr = ptr.next;
            }
        }
        return -1;
    }
    /**
     * Pre: Object exists
     * Parameter: Object other
     * Post: returns if 2 objects are similar
     */
    public boolean equals(Object other){
        if(!(other instanceof List) || other == null){
            return false;
        }
        List o = (List) other;
        if(size() != o.size())
            return false;
        Node ptrOther = new Node(o.head);
        Node ptr = new Node(head);
        while(ptr.data != null){
            if(ptr.data != ptrOther.data)
                return false;
        }
        return true; 
    }
}


