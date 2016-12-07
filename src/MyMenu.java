import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MyMenu extends JPanel{
	JButton newMenu;
	JButton openMenu;
	JButton saveMenu;
	
	MyMenu(DrawPanel dp, TextField tf){
		newMenu = new JButton("New");
		newMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				dp.canvas.clear();
				tf.myTextArea.setText(null);
			}
		});
		openMenu = new JButton("Open");
		openMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				TextField tempTf = Serial.open();
				if(tempTf!=null){
					tf.myTextArea.setText(tempTf.myTextArea.getText());
					dp.canvas.setState();
					dp.canvas.repaint();
				}
			}
		});
		saveMenu = new JButton("Save");
		saveMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Serial.save(tf);
			}
		});
		
		this.add(newMenu);
		this.add(openMenu);
		this.add(saveMenu);
	}
}
