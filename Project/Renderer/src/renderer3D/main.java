package renderer3D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.*;
import java.util.List;

class Vertex {
	double x;
	double y;
	double z;
	Vertex(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Triangle{
	Vertex v1;
	Vertex v2;
	Vertex v3;
	Color color;
	Triangle(Vertex v1, Vertex v2, Vertex v3, Color color){
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.color = color;
	}
}

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//hori rotation slider
		JSlider headingSlider = new JSlider(0, 360, 180);
		pane.add(headingSlider, BorderLayout.SOUTH);
		
		//vert rotation slider
		JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
		pane.add(pitchSlider, BorderLayout.EAST);
		
		List<Triangle> tris = new ArrayList<Triangle>();
		tris.add(new Triangle(new Vertex(100, 100, 100),
		                      new Vertex(-100, -100, 100),
		                      new Vertex(-100, 100, -100),
		                      Color.WHITE));
		tris.add(new Triangle(new Vertex(100, 100, 100),
		                      new Vertex(-100, -100, 100),
		                      new Vertex(100, -100, -100),
		                      Color.RED));
		tris.add(new Triangle(new Vertex(-100, 100, -100),
		                      new Vertex(100, -100, -100),
		                      new Vertex(100, 100, 100),
		                      Color.GREEN));
		tris.add(new Triangle(new Vertex(-100, 100, -100),
		                      new Vertex(100, -100, -100),
		                      new Vertex(-100, -100, 100),
		                      Color.BLUE));	
		
		//panel to display render results
		JPanel renderPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.BLACK);
					g2.fillRect(0, 0, getWidth(), getHeight());
					
					//rendering part
					g2.translate(getWidth() / 2, getHeight() / 2);
					g2.setColor(Color.WHITE);
					for (Triangle t : tris) {
					    Path2D path = new Path2D.Double();
					    path.moveTo(t.v1.x, t.v1.y);
					    path.lineTo(t.v2.x, t.v2.y);
					    path.lineTo(t.v3.x, t.v3.y);
					    path.closePath();
					    g2.draw(path);
					}
				}
			};
		
		
	
			
			
			
			
		pane.add(renderPanel, BorderLayout.CENTER);
		
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

}
