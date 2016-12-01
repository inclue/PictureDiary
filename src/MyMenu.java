import java.awt.*;

public class MyMenu extends MenuBar{
	Menu newMenu;
	Menu openMenu;
	Menu saveMenu;
	
	MyMenu(){
		newMenu = new Menu("New");
		openMenu = new Menu("Open");
		saveMenu = new Menu("Save");
		
		this.add(newMenu);
		this.add(openMenu);
		this.add(saveMenu);
	}
}
