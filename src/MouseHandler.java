import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener{
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Button / "+e.getButton());
		System.out.println("Mouse Press / "+e.getX()+' '+e.getY());
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse Drag / "+e.getX()+' '+e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Release / "+e.getX()+' '+e.getY());
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Exit / "+e.getX()+' '+e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
}
