
import javax.swing.JFileChooser;
import java.io.*;

public class TreeEncoding {
 public static void main(String args[]) {
       System.out.println("Please choose the file to encode !");
       JFileChooser Chooser=new JFileChooser(".");// use JFileChooser to choose a file as dictionary
       Chooser.showOpenDialog(null);// use JFileChooser to choose a file as dictionary
       File chosenFile = Chooser.getSelectedFile();// use JFileChooser to choose a file as dictionary
        System.out.println("**********Content of Input File**************");
        List aList=new List();
        try {
             
            BufferedReader inFile2=new BufferedReader(new FileReader(chosenFile));
            String aLine=inFile2.readLine();
            String symbol;
            while (aLine!=null) {  //read in line
             
             System.out.println(aLine);
             for (int i = 0;i < aLine.length(); i++) {
              symbol = ""+aLine.charAt(i);
              aList.insert(symbol);  //
             }
             symbol = "\n";    //manually capture this symbol
             aList.insert(symbol); 
             aLine = inFile2.readLine();
            }
            //here the frequency list has stored in aList
            System.out.println("**********End of Input File*************");
            inFile2.close();
            
            /* The following part used to construct HuffmanEncodingTree */
            //store the node in the aList into Heaplist anotherList
            HeapList anotherList=new HeapList();
            Node curr=aList.head;
            while(curr!=null)
            {
              TreeNode temp1=new TreeNode(curr.content);
              anotherList.insert(temp1);
              curr=curr.next;
            }
           
            // the following part construct the Huffman coding tree
            TreeNode theFirst,theSecond,newNode;
            while(anotherList.top.next!=null)//join the first and the second TreeNodes to a newNode,inserting the newNode back to the list
            {
              theFirst=anotherList.remove();
              theSecond=anotherList.remove();
              newNode=anotherList.join(theFirst,theSecond);
              anotherList.insert(newNode);
            }
            /*list the path of each char*/
            Node aNode=aList.head;
            String path;
            System.out.println("The path of each symbol in the Huffman Tree :");
           for(int t=0;t<aList.count;t++)
           {
             path=anotherList.pathRecord(aNode.content.letter);
             if((int)(aNode.content.letter.charAt(0))==10)//If the symbol stands for newline
               System.out.println("New Line Symbol: "+path);
             else if((int)(aNode.content.letter.charAt(0))==32)//If the symbol stands for blank space
               System.out.println("Blank Space: "+path);
             else if((int)(aNode.content.letter.charAt(0))==9)//If the symbol stands for a tab
               System.out.println("Tab: "+path);
             else
               System.out.println(aNode.content.letter+": "+path);
             
             aNode=aNode.next;
           }
           /*executing the encoding step */
           
           BufferedReader inFile=new BufferedReader(new FileReader(chosenFile));
           String theLine=inFile.readLine();
           String encodingPath;//used to store a path of a char
           String finalCode="";//hold the path of the whole content in the file
           while(theLine!=null)
           {
             for(int k=0;k<theLine.length();k++)
             {
               encodingPath=anotherList.pathRecord(""+theLine.charAt(k));
               finalCode+=encodingPath;
               
             }
             finalCode+=anotherList.pathRecord("\n");//"\n" can't be catched , so add it manually
             theLine=inFile.readLine();
           }
           System.out.println("The code for the content of the file is as follows :");
           System.out.println(finalCode);
           /*The following part executing decoding*/
           
           System.out.println("\nDecoded Output :");
           inFile.close();
           System.out.println("Now following to the code above,find the leaf Node of each path and decode the code back to the content of the file :");
           anotherList.decode(finalCode);

        }
        catch (Exception e) {
              System.out.println("Error: " + e.getMessage()); 
              e.printStackTrace();
        }
 }
}



