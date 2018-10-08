import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.imageio.ImageIO;
 
public class Demo extends JPanel {
 
   BufferedImage image;
   Ellipse2D.Double circle;
   Rectangle rect;
   
   static List<Integer> integers = new ArrayList<>();
   static int handX,handY,circleX,circleY;
   
   Demo(BufferedImage image) {

      this.image = image;
        rect = new Rectangle(image.getWidth(), image.getHeight());
        
      //t.start();
      //addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
	  
      
   }
   public static void getFileVariables (int x, int y,int cx,int cy) {
		 handX =  integers.get(x);
		 handY = integers.get(y);
		 circleX =  integers.get(cx);
		 circleY= integers.get(cy);
	     System.out.println(x+"///"+y+"///"+cx+"///"+cy);
	   }
   
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
   //   Demo d = new Demo(image);
      /*draw circles*/
      Graphics2D g2 = (Graphics2D)g;
      
      initCircle();
 
     // rect.x = integers.get(1)*100;
      System.out.println(this.handX+"\n");
     rect.y = handY*100;
       
      g2.drawImage(image,  this.handX*100, this.handY*100, this);
      g2.setPaint(Color.RED);
      g2.fill(circle);
      
   }

 
   private void initCircle() {
               
      /*Edge dots(x,y,40,40)=>dot position and size*/            
      circle = new Ellipse2D.Double(circleX*100,circleY*100,40,40);
     
   }

   
   public static void main(String[] arguments) throws IOException {

	   //read text file
		   try {
		
			   File file = new File("C:\\Users\\SNU1\\git\\BMI\\BMI\\text\\test.txt");
			   String[] splitedStr = null;
			   FileReader filereader = new FileReader(file);
			   BufferedReader bf = new BufferedReader(filereader);
			   String line = "";
			   splitedStr = null;
			   
			   long length = 0;
			   while((line=bf.readLine())!=null){
				   if(line.isEmpty()) {
					   break;
				   }
				   splitedStr = line.split(" ");
				   
				   for(int i=1;i<splitedStr.length;i++) {
					   splitedStr[i]=splitedStr[i].trim();
					   System.out.println(splitedStr[i]);
					   integers.add(i);
				   }
			   }
			   bf.close();
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}

		  
		 getFileVariables(integers.get(6),integers.get(7),integers.get(8),integers.get(9));
	      
		  
		  System.out.println(handX +" ?????"+handY+" ?????"+circleX +" ?????"+circleY);
		  System.out.println(integers.get(6)+" " +integers.get(7)+" "+integers.get(8)+" "+integers.get(9));
	   
	      //insert image
	       BufferedImage image = ImageIO.read(new File("image/point.png"));
	       Demo d = new Demo(image);
	   
	       //main window
	       JFrame frame = new JFrame();
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	       frame.add(new JScrollPane(d));
	   
	       //main setup
	       frame.setSize(1000, 1000);
	       frame.setLocation(500, 50);
	       frame.setVisible(true);
	       
	       
		 
	  }


   
}