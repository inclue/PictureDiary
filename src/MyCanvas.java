import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class MyCanvas extends Canvas{
	private int lx=0, ly=0, nx=0, ny=0;
	private int click, buttonState=2, strokeState=1;
	private Color colorState;
	
	MyCanvas(){
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				lx=e.getX();
				ly=e.getY();
				click=e.getButton()/2;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ShapeData sData = new ShapeData(lx,ly,nx,ny,strokeState,buttonState+click,colorState);
				Serial.addShapeArrayList(sData);
			}
		});
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent e) {
				nx=e.getX();
				ny=e.getY();
				repaint();
			}
			@Override
			public void mouseMoved(MouseEvent e) {}
		});
		colorState=Color.BLACK;
	}
	
	public void clear(){
		Serial.clearShapeArrayList();
		lx=ly=nx=ny=-1;
		repaint();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		ArrayList<ShapeData> shapeArrayList = Serial.getShapeArrayList();
		for(int i=0;i<shapeArrayList.size();i++){
			ShapeData sd = shapeArrayList.get(i);
			g2.setColor(sd.color);
			g2.setStroke(new BasicStroke(sd.stroke));
			switch(sd.shape){
			case 2 : case 3 : g2.drawLine(sd.lx, sd.ly, sd.nx, sd.ny); break;
			case 4 : g2.drawRect(min(sd.lx,sd.nx), min(sd.ly,sd.ny), abs(sd.nx-sd.lx), abs(sd.ny-sd.ly)); break;
			case 5 : g2.fillRect(min(sd.lx,sd.nx), min(sd.ly,sd.ny), abs(sd.nx-sd.lx), abs(sd.ny-sd.ly)); break;
			case 6 : g2.drawOval(min(sd.lx,sd.nx), min(sd.ly,sd.ny), abs(sd.nx-sd.lx), abs(sd.ny-sd.ly)); break;
			case 7 : g2.fillOval(min(sd.lx,sd.nx), min(sd.ly,sd.ny), abs(sd.nx-sd.lx), abs(sd.ny-sd.ly)); break;
			}
		}
		g2.setColor(colorState);
		g2.setStroke(new BasicStroke(strokeState));
		switch(buttonState+click){
		case 2 : case 3 : g2.drawLine(lx, ly, nx, ny); break;
		case 4 : g2.drawRect(min(lx,nx), min(ly,ny), abs(nx-lx), abs(ny-ly)); break;
		case 5 : g2.fillRect(min(lx,nx), min(ly,ny), abs(nx-lx), abs(ny-ly)); break;
		case 6 : g2.drawOval(min(lx,nx), min(ly,ny), abs(nx-lx), abs(ny-ly)); break;
		case 7 : g2.fillOval(min(lx,nx), min(ly,ny), abs(nx-lx), abs(ny-ly)); break;
		}
	}
	
	int min(int a,int b){return a<b?a:b;}
	int max(int a,int b){return a>b?a:b;}
	int abs(int a){return a<0?-a:a;}
	
	public void setButtonState(int buttonState) {this.buttonState = buttonState;}
	public void setColorState(String s){
		switch(s){
		case "BLACK": colorState=Color.BLACK; break;
		case "BLUE": colorState=Color.BLUE; break;
		case "CYAN": colorState=Color.CYAN; break;
		case "GRAY": colorState=Color.GRAY; break;
		case "GREEN": colorState=Color.GREEN; break;
		case "MAGENTA": colorState=Color.MAGENTA; break;
		case "ORANGE": colorState=Color.ORANGE; break;
		case "PINK": colorState=Color.PINK; break;
		case "RED": colorState=Color.RED; break;
		case "WHITE": colorState=Color.WHITE; break;
		case "YELLOW": colorState=Color.YELLOW; break;
		}
	}
	public void setStrokeState(int str) {strokeState = str;}
}