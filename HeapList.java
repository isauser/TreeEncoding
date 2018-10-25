
public class HeapList{
  Node top; 
  public HeapList()
  {
    top=null;
  }
  public void insert(TreeNode a)
  {
      Node temp=top;
      Node prev=null;
      while(temp!=null&&a.data.count>temp.aTreeNode.data.count)
      {
          prev=temp;
          temp=temp.next;
      }
      if(prev==null)
      {
        Node newNode=new Node(a,top);
        top=newNode;
      }
      else
      {
        prev.next=new Node(a,temp);
      }
      
  }
  public TreeNode remove()// remove and return the first element in the 
  {
     Node curr=top;
     top=top.next;
        return curr.aTreeNode;
    }

  public TreeNode join(TreeNode a,TreeNode b)// combine two TreeNode and return the combined one
  {
    TreeNode temp=new TreeNode(new Data(null, 0));
    temp.data.count=a.data.count+b.data.count;
    temp.data.letter=a.data.letter+b.data.letter;
    temp.left=a;
    temp.right=b;
    return temp;
  }
  public String pathRecord(String a)//track the path of the parameter String
  {
    String temp="";
    TreeNode curr=top.aTreeNode;
    while(curr.data.letter.indexOf(a)!=-1)//if the String appears in this node
    {
      
        if(curr.right!=null&&(curr.right.data.letter.indexOf(a)!=-1))//the right child contains the symbol 
        {
          temp+="1";
          curr=curr.right;
        }
        else if(curr.left!=null&&(curr.left.data.letter.indexOf(a)!=-1))//the left child contains the symbol 
        {
          temp+="0";
          curr=curr.left;
        }
        else break;
      
    }
    return temp;
  }
public void decode(String a)//decode the String passed into the function 
{
  TreeNode temp=top.aTreeNode;
  for(int i=0;i<a.length();i++)
  {
    if(a.charAt(i)=='0')//If the char  is '0', go to the left child
    {
      temp=temp.left;
    }
    else//If the char  is not '0', go to the right child
      temp=temp.right;
    if(temp.right==null&&temp.left==null)//reach the leaf child
    {
      System.out.print(temp.data.letter);
      temp=top.aTreeNode;//back to the root
    }
  }
}  
}