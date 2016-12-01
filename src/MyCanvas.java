import java.awt.*;

import javax.swing.*;

public class MyCanvas extends Canvas{
	MyCanvas(){
		this.setBackground(Color.WHITE);
		
		
		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 30, 30);
	}
}
