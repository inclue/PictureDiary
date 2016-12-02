import java.awt.*;

import javax.swing.*;

public class PictureDiary {
	
	public static void main(String[] args){
		JFrame diary = new JFrame("Picture Diary - 20155600 ¹ÚÀÎ¼­");
		DrawPanel canvas = new DrawPanel();
		TextField textArea = new TextField();
		MyMenu menu = new MyMenu(canvas, textArea);
		
		diary.setSize(1000,800);
		diary.setLayout(new BorderLayout());
		diary.add(menu,BorderLayout.NORTH);
		diary.add(canvas,BorderLayout.CENTER);
		diary.add(textArea,BorderLayout.SOUTH);
		diary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		diary.setVisible(true);
	}
}