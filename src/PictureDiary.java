import java.awt.*;
import javax.swing.*;

public class PictureDiary {
	public static void main(String[] args){
		JFrame Diary = new JFrame("Picture Diary - 20155600 ¹ÚÀÎ¼­");
		MyCanvas canvas = new MyCanvas();
		TextField textArea = new TextField();
		MyMenu myMenu = new MyMenu();
		
		Diary.setMenuBar(myMenu);
		Diary.setSize(800,500);
		Diary.add(canvas,BorderLayout.CENTER);
		Diary.add(textArea,BorderLayout.SOUTH);
		Diary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Diary.setVisible(true);
	}
}
