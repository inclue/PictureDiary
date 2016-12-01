import java.awt.*;
import javax.swing.*;


public class DrawPanel extends JPanel{
	MyCanvas canvas;
	DrawPanel(){
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		this.setLayout(new BorderLayout());
		
		canvas = new MyCanvas();
		this.add(canvas,BorderLayout.CENTER);
	}	
}
