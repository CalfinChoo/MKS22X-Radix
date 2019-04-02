public class MyLinkedList<E> {
  private int length;
  private Node start,end;
  public MyLinkedList() {
   length = 0;
  }
  public void clear() {
    length = 0;
    start = null;
    end = null;
  }
  public boolean add(E value) {
   Node newNode = new Node(value, null, end);
   if (length == 0) {
     start = newNode;
     length++;
     return true;
   }
   if (length == 1) {
     start.setNext(newNode);
     end = start.Next();
     length++;
     return true;
   }
   end.setNext(newNode);
   end = newNode;
   length++;
   return true;
 }
 public void add(int index, E value) {
   if (index < 0 || index > length) throw new IndexOutOfBoundsException();
   if (index == 0) {
     Node nsNode = new Node(value, start, null);
     start.setPrev(nsNode);
     start = start.Prev();
     length++;
   }
   else {
     if (index == length) {
       add(value);
     }
     else {
       Node at = getNode(index);
       Node newNode = new Node(value, at, at.Prev());
       at.setPrev(newNode);
       at.Prev().Prev().setNext(newNode);
       length++;
     }
   }
 }
 public void extend(MyLinkedList other){
      //in O(1) runtime, move the elements from other onto the end of this
      //The size of other is reduced to 0
      //The size of this is now the combined sizes of both original lists
      if (length > 0 && other.size() > 0) {
        end.setNext(other.start);
        end.Next().setPrev(end);
        end = other.end;
        length += other.size();
        other.length = 0;
      }
      else if (length == 0 && other.size() > 0) {
        start = other.start;
        end = other.end;
        length = other.size();
      }
 }
 public E removeFront() {
   E temp = start.getData();
   start.Next().setPrev(null);
   start = start.Next();
   length--;
   return temp;
 }
 private Node getNode(int index) {
   Node temp = start;
   for (int count = 0; count != index; count++) {
     temp = temp.Next();
   }
   return temp;
 }
 public int size() {
   return length;
 }
  public String toString(){
   String s = "[";
   Node temp = start;
   if (length == 0) {
     s += "]";
     return s;
   }
   if (length == 1) {
     s = s + temp.getData() + "]";
     return s;
   }
   while(temp != end) {
     s = s + temp.getData() + ", ";
     temp = temp.Next();
   }
   if (temp == end) s = s + temp.getData() + "]";
   return s;
 }

 class Node {
   private E data;
   private Node next,prev;
   public E getData() {
     return data;
   }
   public E setData(E value) {
     E temp = data;
     data = value;
     return temp;
   }
   public Node Next() {
     return next;
   }
   public void setNext(Node newNext) {
     next = newNext;
   }
   public Node Prev() {
     return prev;
   }
   public void setPrev(Node newPrev) {
     prev = newPrev;
   }
   public Node(E newData, Node newNext, Node newPrev){
     data = newData;
     next = newNext;
     prev = newPrev;
   }
   public String toString() {
     return "" + data;
   }
 }
}
