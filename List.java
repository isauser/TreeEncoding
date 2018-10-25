public class List {
 Node head;
 int count;
 public List() {
  head = null;
  count = 0;
 }
 public Node search(String a) {
  Node temp=head;
  while (temp != null) {
   if (a.compareTo(temp.content.letter) == 0) {
    break;
   }
   temp = temp.next;
  } 
  return temp;
 }

 public void insert(String a) {
  Node temp;
  temp = search(a);
  if (temp == null) {  //key not in list, add it to front.
   temp = new Node(a); //insert new node at front of list
   temp.next = head;
   head = temp;
   count = count + 1;
  }
  else { 
   temp.content.count = temp.content.count + 1; 
  } 
 }
}