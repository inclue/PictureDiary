import java.awt.*;
import javax.swing.*;

public class MyCanvas extends JPanel{
	Canvas canvas = new Canvas();
	void MyCanvas(){
		this.add(canvas,BorderLayout.CENTER);
	}
}
