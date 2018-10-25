
public class Node {
 Data content;
 Node next;
 TreeNode aTreeNode;
 public Node(String a) {
  content = new Data(a,1);
 }
 public Node(TreeNode a,Node b)
 {
   aTreeNode=a;
   next=b;
 }
}