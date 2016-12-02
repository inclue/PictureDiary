import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToolButton extends JButton {
	private int setState;
	ToolButton(String name, int state){
		this.setText(name);
		setState=state;
	}
	
	public int getSetState(){
		return setState;
	}
}
