# Huffman

Huffman coding is a scheme that assigns variable-length bit-codes (binary strings) to characters, such that the lengths of the codes depend on the frequencies of the characters in a typical message. As a result, encoded messages take less space (as compared to fixed-length encoding such as ASCII or UNICODE) since the letters that appear more frequently are assigned shorter codes. This is performed by first building a Huffman coding Tree based on a given set of frequencies. From the tree, bit-codes for each character are determined and then used to encode a message. The tree is also used to decode an encoded message as it provides a way to determine which bit sequences translate back to a character. (See the text passage at the end of the assignment for more details).

You are to implement a Huffman coding system using the frequency table given below (this is also in a text file on moodle, LetterCount.txt). Your final solution should be able to encode any message that uses the characters of the english alphabet or decode any bit sequence to the corresponding characters. There are three main parts to the system, generating the huffman tree, encoding and decoding.

**A quick tutorial on generating a huffman tree – siggraph.org**

Let’s say you have a set of numbers and their frequency of use and want to create a huffman encoding for them:
 
	FREQUENCY	VALUES of ALPHABET
        ---------       -----
       	     5            1
             7            2
            10            3
            15            4
            20            5
            45            6
	    
Creating a huffman tree is simple. Sort this list by frequency and make the two-lowest elements into leaves, creating a parent node with a frequency that is the sum of the two lower element's frequencies: 

12:*
/  \
5:1   7:2

The two elements are removed from the list and the new parent node, with frequency 12, is inserted into the list by frequency. So now the list, sorted by frequency, is: 
10:3
12:*
15:4
20:5
45:6

You then repeat the loop, combining the two lowest elements. This results in: 
22:*
/   \
10:3   12:*
    /   \
  5:1   7:2
  
and the list is now: 

15:4
20:5
22:*
45:6

You repeat until there is only one element left in the list. 
    	35:*
    	/   \
      15:4  20:5

      	22:*
      	35:*
      	45:6

      	    57:*
      	___/    \___
       /            \
     22:*          35:*
    /   \          /   \
 10:3   12:*     15:4   20:5
        /   \
      5:1   7:2

	45:6
	57:*

                                   102:*
                __________________/    \__
               /                          \
      	    57:*                         45:6
      	___/    \___
       /            \
     22:*          35:*
    /   \          /   \
 10:3   12:*     15:4   20:5
        /   \
      5:1   7:2
Now the list is just one element containing 102:*, you are done. 
This element becomes the root of your binary huffman tree. To generate a huffman code you traverse the tree to the value you want, outputing a 0 every time you take a left hand branch, and a 1 every time you take a right hand branch. (normally you traverse the tree backwards from the code you want and build the binary huffman encoding string backwards as well, since the first bit must start from the top). 




