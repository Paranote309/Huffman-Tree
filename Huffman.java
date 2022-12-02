import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman {
    ListReferenceBased freq = new ListReferenceBased();
    TreeNode root = null;
    

    public void genTree() 
    {
        while(freq.size() > 1 )
        {
            int sumFreq = ((TreeNode) freq.get(1)).getItem().getFreq() +
            ((TreeNode) freq.get(2)).getItem().getFreq();

            TreeNode left_Right = new TreeNode(
                    new LetterFreq('#', sumFreq),
                    ((TreeNode) freq.get(1)),
                    ((TreeNode) freq.get(2))

            );
            freq.remove(1);
            freq.remove(1);
            freq.add(freq.size()+1, left_Right);
            freq.bubbleSort();
        }
        root = ((TreeNode)freq.get(1));

    }

    String finalBinary = "";
    public void  getBits(char letter,String tempBinary, TreeNode node)
    {
        if(node == null){
            return;
        }
        char currLetter =((LetterFreq)node.getItem()).getLetter(); 
        if(currLetter == letter)
        {
            finalBinary = tempBinary;
            return; 
        }
        

        getBits(letter, tempBinary+'0', node.getLeft());
        getBits(letter, tempBinary+'1', node.getRight()); 


    
    }

    public String encode(String decodeBits)
    {
        decodeBits = decodeBits.toUpperCase();
        String encodeBits = "";

        for(int i = 0; i < decodeBits.length(); i++)
        {
            getBits(decodeBits.charAt(i), "", root); 
            encodeBits += finalBinary;
        }

        return encodeBits;
    }

    public String decode(String encodeBits)
    {
        String decodeBits = "";
        TreeNode curr = root;

        for(int i = 0; i < encodeBits.length(); i++)
        {
            char bit = encodeBits.charAt(i);
            if(((LetterFreq)curr.getItem()).getLetter() != '#' )
            {
                decodeBits += ((LetterFreq)curr.getItem()).getLetter();
                curr = root;
            }
            if(bit == '0' ) 
            {
                curr = curr.getLeft();
            }else if(bit == '1')
            {
                curr = curr.getRight();
            }

        }
        decodeBits += ((LetterFreq)curr.getItem()).getLetter();

        return decodeBits;
    }

    public void readFile() 
    {

        try {
            File letterCountFile = new File("LetterCountAscending.txt");
            Scanner myReader = new Scanner(letterCountFile);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("\t");
                freq.add(
                        freq.size() + 1,
                        new TreeNode(
                                new LetterFreq(data[0].charAt(0), Integer.parseInt(data[1]))));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    void printPostorder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.println(node.getItem());
        // first recur on left subtree
        printPostorder(node.getLeft());
 
        // then recur on right subtree
        printPostorder(node.getRight());
 
        // now deal with the node
        
    }
    public Huffman() 
    {
        readFile();
        freq.bubbleSort();
        freq.displayList();
        genTree();
      
        System.out.println(encode("BENJAMIN"));
        System.out.println(decode(encode("BENJAMIN")));
       

        // printPostorder(root);

        // System.out.println(finalBinary);
        
    }

    public static void main(String[] args) 
    {
        new Huffman();
    }

}
