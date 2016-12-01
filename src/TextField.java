import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextField extends JPanel{
	JTextArea myTextArea;
	JScrollPane scrollPane;
	JButton clearButton;
	
	TextField(){	
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout());
		
		myTextArea = new JTextArea(10,30);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(myTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		this.add(scrollPane,BorderLayout.CENTER);
		
		clearButton = new JButton("텍스트 지우기");
		clearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				myTextArea.setText(null);
			}
		});
		this.add(clearButton,BorderLayout.EAST);
	}
}