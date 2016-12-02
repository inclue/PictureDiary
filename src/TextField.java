import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TextField extends JPanel implements Serializable{
	JTextArea myTextArea;
	JScrollPane scrollPane;
	JButton clearButton;
	
	TextField(){	
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout());
		
		clearButton = new JButton("텍스트 지우기");
		clearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				myTextArea.setText(null);
			}
		});
		this.add(clearButton,BorderLayout.WEST);
		
		myTextArea = new JTextArea(10,30);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(myTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		this.add(scrollPane,BorderLayout.CENTER);
	}
}