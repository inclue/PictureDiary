import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class DrawPanel extends JPanel{
	MyCanvas canvas;
	
	JPanel setPanel;
	JPanel buttonPanel;
	JPanel clearPanel;
	JPanel strokePanel;
	JPanel colorPanel;
	
	ToolButton pencilButton;
	ToolButton lineButton;
	ToolButton rectButton;
	ToolButton circleButton;
	JButton clearButton;
	
	JLabel Stroke;
	CheckboxGroup cbGroup;
	Checkbox s1;
	Checkbox s2;
	Checkbox s3;
	Checkbox s4;
	
	String[] item = {"BLACK", "BLUE", "CYAN", "GRAY", "GREEN", "MAGENTA",
			"ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
	JComboBox cmb;
	JLabel label; 
	
	DrawPanel(){
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		this.setLayout(new BorderLayout());
		
		setPanel = new JPanel(new BorderLayout());
		setPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		buttonPanel = new JPanel(new GridLayout(2,2));
		
		lineButton = new ToolButton("/",2);
		lineButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				canvas.setButtonState(lineButton.getSetState());
			}
		});
		buttonPanel.add(lineButton);
		
		rectButton = new ToolButton("□",4);
		rectButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				canvas.setButtonState(rectButton.getSetState());
			}
		});
		buttonPanel.add(rectButton);
		
		circleButton = new ToolButton("○",6);
		circleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				canvas.setButtonState(circleButton.getSetState());
			}
		});
		buttonPanel.add(circleButton);
		
		pencilButton = new ToolButton("연필",8);
		pencilButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				canvas.setButtonState(pencilButton.getSetState());
			}
		});
		buttonPanel.add(pencilButton);
		
		clearPanel = new JPanel(new BorderLayout());
		clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				canvas.clear();
			}
		});
		clearPanel.add(clearButton, BorderLayout.NORTH);
		clearPanel.add(buttonPanel,BorderLayout.CENTER);
		setPanel.add(clearPanel,BorderLayout.CENTER);
		
		strokePanel = new JPanel();
		Stroke = new JLabel("굵기");
		CheckboxGroup cbGroup = new CheckboxGroup();
		s1 = new Checkbox("x1.0",cbGroup,true);
		s1.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent ie) {
				canvas.setStrokeState(1);
			}	
		});
		s2 = new Checkbox("x2.0",cbGroup,false);
		s2.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent ie) {
				canvas.setStrokeState(2);
			}	
		});
		s3 = new Checkbox("x3.0",cbGroup,false);
		s3.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent ie) {
				canvas.setStrokeState(3);
			}	
		});
		s4 = new Checkbox("x4.0",cbGroup,false);
		s4.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent ie) {
				canvas.setStrokeState(4);
			}	
		});
		strokePanel.add(Stroke);
		strokePanel.add(s1);
		strokePanel.add(s2);
		strokePanel.add(s3);
		strokePanel.add(s4);
		setPanel.add(strokePanel,BorderLayout.NORTH);
		
		colorPanel = new JPanel();
		cmb = new JComboBox(item);
		label = new JLabel("색상");
		cmb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setColorState((String)cmb.getSelectedItem());
			}
		});
		colorPanel.add(label);
		colorPanel.add(cmb);
		setPanel.add(colorPanel,BorderLayout.SOUTH);
		
		this.add(setPanel,BorderLayout.WEST);
		
		canvas = new MyCanvas();
		this.add(canvas,BorderLayout.CENTER);
	}
}
