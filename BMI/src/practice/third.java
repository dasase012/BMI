package practice;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class third extends JPanel implements ActionListener{

	Timer t = new Timer(5, this);
	double x=100,y=100,x2=800, y2=800,
			velX=2,velY=2;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		Ellipse2D circle = new Ellipse2D.Double(x,y,40,40);
		g2.fill(circle);
		
		Graphics2D g3 = (Graphics2D)g;
		Ellipse2D circle3 = new Ellipse2D.Double(x,y2,40,40);
		g3.fill(circle3);
		
		Graphics2D g4 = (Graphics2D)g;
		Ellipse2D circle4 = new Ellipse2D.Double(x2,y,40,40);
		g4.fill(circle4);
		
		Graphics2D g5 = (Graphics2D)g;
		Ellipse2D circle5 = new Ellipse2D.Double(x2,y2,40,40);
		g5.fill(circle5);
		
		Graphics2D hand = (Graphics2D)g;
		Ellipse2D circle6 = new Ellipse2D.Double(450,450,80,80);
		hand.fill(circle6);
		
		
		
		t.start();
	}

	public void actionPerformed(ActionEvent e) {

		if(x<0 || x>560) {
			velX = -velX;
		}
		if(y<0 || y>360) {
			velY = -velY;
		}
		x += velX;
		y += velY;
		repaint();
	}
}
