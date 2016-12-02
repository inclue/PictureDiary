import java.awt.*;
import java.io.*;


public class ShapeData implements Serializable  {
	int lx, ly, nx, ny;
	int stroke, shape;
	Color color;
	ShapeData(int lx, int ly, int nx, int ny, int str, int sha, Color col){
		this.lx=lx;
		this.ly=ly;
		this.nx=nx;
		this.ny=ny;
		stroke=str;
		color=col;
		shape=sha;
	}
}