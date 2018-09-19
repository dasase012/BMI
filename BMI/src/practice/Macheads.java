package practice;

import javax.swing.JFrame;

public class Macheads {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		//second s = new second();
		third t = new third();
		
		//f.add(s);
		f.add(t);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
	}
}

