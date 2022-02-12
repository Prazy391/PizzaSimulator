public class Node{
     Object data;
     Node next; 
     /**
     * Constructors
     */
     public Node(Object newData){
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