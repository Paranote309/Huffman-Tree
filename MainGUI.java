import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainGUI extends JFrame implements ActionListener {
    JTextField result= new JTextField("Text:");
    JTextField input = new JTextField(20);
	JButton decodeButton = new JButton("Decode");
    JButton encodeButton = new JButton("Encode");

    


    MainGUI(){
        super("Huffman");
		Container content = getContentPane();
		JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();

        Font sansFont = new Font("Comic Sans MS",Font.ITALIC,24);

        panel.setLayout(new GridLayout(3,0));
        buttonPanel.setLayout(new GridLayout(0,2));

		decodeButton.addActionListener(this);
        encodeButton.addActionListener(this);
   
        
        input.setFont(sansFont);
        result.setFont(sansFont);
        decodeButton.setFont(sansFont);
        encodeButton.setFont(sansFont);

        result.setEditable(false);


        panel.add(result);
        panel.add(input);
		buttonPanel.add(decodeButton);
        buttonPanel.add(encodeButton);
        panel.add(buttonPanel);
		content.add(panel);
    }
    Huffman huffman = new Huffman();
    
    public static void main(String[] args) {
       
        MainGUI frame = new MainGUI();
        frame.setTitle("Huffman");
		frame.setSize(800, 600);
	    frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public void actionPerformed(ActionEvent e) {
		String message = " ";
        

		if (e.getSource() == decodeButton)
        {
           message = huffman.decode(input.getText());
		}
        if(e.getSource() == encodeButton)
        {
            message = huffman.encode(input.getText());
        }
        result.setText(message);
		
	}
}
