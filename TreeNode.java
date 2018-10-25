
public class TreeNode{
  Data data;
  TreeNode left;//point to the left child
  TreeNode right;//point to the right child
  public TreeNode(Data a)//constructor
  {
    data = new Data(a.letter,a.count);
    left=null;
    right=null;
  }
}