import java.awt.*;

public class MyMenu extends MenuBar{
	Menu fileMenu;
	Menu helpMenu;
	MenuItem newMenuItem;
	MenuItem openMenuItem;
	
	void MyMenu(){
		fileMenu = new Menu("File");
		newMenuItem = new MenuItem("New");
		openMenuItem = new MenuItem("Open");
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		
		helpMenu = new Menu("Help");
		this.add(fileMenu);
		this.add(helpMenu);
	}
}
