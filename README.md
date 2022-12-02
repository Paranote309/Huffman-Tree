# ** Huffman**

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
