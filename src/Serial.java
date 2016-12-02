import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Serial {
	static ArrayList<ShapeData> shapeArrayList = new ArrayList<ShapeData>();
	
	static ArrayList<ShapeData> getShapeArrayList(){
		return shapeArrayList;
	}
	static void clearShapeArrayList(){
		shapeArrayList = new ArrayList<ShapeData>();
	}
	static void addShapeArrayList(ShapeData a){
		shapeArrayList.add(a);
	}
	
	public static void save(TextField tf){
		try{
			FileOutputStream fos = new FileOutputStream("saveData.grim");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for(int i=0;i<shapeArrayList.size();i++){
				oos.writeObject(shapeArrayList.get(i));
			}
			oos.writeObject(tf);
			oos.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "can't save file!");
		}
	}
	
	public static TextField open(){
		try {
			   FileInputStream fis = new FileInputStream("saveData.grim");
			   ObjectInputStream ois = new ObjectInputStream(fis);
			   for(int i=0;i<shapeArrayList.size();i++){
					shapeArrayList.add((ShapeData)ois.readObject());
			   }
			   ois.close();
			   return (TextField)ois.readObject();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "can't open file!");
			return null;
		}
	}
}
