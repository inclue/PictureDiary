import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Serial {
	static ArrayList<ShapeData> shapeArrayList = new ArrayList<ShapeData>();
	
	static ArrayList<ShapeData> getShapeArrayList(){
		return shapeArrayList;
	}
	
	static void clearShapeArrayList(){
		shapeArrayList.clear();
	}
	
	static void addShapeArrayList(ShapeData a){
		shapeArrayList.add(a);
	}
	
	public static void save(TextField tf){
		try{
			FileOutputStream fos = new FileOutputStream("saveData.grim");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(shapeArrayList.size());
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
			   int n = (int)ois.readObject();
			   
			   clearShapeArrayList();
			   for(int i=0;i<n;i++){
				   shapeArrayList.add((ShapeData)ois.readObject());
			   }
			   TextField TempTf = (TextField)ois.readObject();
			   ois.close();
			   return TempTf;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "can't open file!");
			return null;
		}
	}
}
