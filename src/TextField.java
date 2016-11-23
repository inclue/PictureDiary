import java.awt.*;
import javax.swing.*;

public class TextField extends JPanel{
	JTextArea myTextArea = new JTextArea();
	void TextField(){
		this.add(myTextArea,BorderLayout.CENTER);
	}
}