import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
 
public class Demo extends JPanel implements ActionListener, KeyListener{
 
   BufferedImage image;
   Ellipse2D.Double circle, circle2, circle3, circle4;
   Rectangle rect;
   Dimension size = new Dimension();			
   /*Rectangle, Dimension이 갖고 있는 함수로 좌표 (10,10)으로 한정 짓거나 
   x,y 좌표대로 이미지나 점이 움직이도록 설정 가능할 듯.*/
   
   Timer t = new Timer(5, this);
   int x=400, y=250, 
      x0=100, y0=100,
      x2=800, y2=800,
      velx=0, vely=0;
   
   Demo(BufferedImage image) {
      this.image = image;
        rect = new Rectangle(image.getWidth(), image.getHeight());
        
      t.start();
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
   }
   
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      /*draw circles*/
      Graphics2D g2 = (Graphics2D)g;
      
      initCircle();
   
      // Draw image centered.
      /*rect.x = (size.width - rect.width)/2;
      rect.y = (size.height - rect.height)/2;*/
      
      /*rect.x=(int) (rect.getWidth()/2);
      rect.y=(int) (rect.getHeight()/2);*/
      rect.x = x;
      rect.y = y;
      
      
      
      g2.drawImage(image, rect.x, rect.y, this);
      g2.setPaint(Color.RED);

      g2.fill(circle);
     /* g2.fill(circle2);
      g2.fill(circle3);
      g2.fill(circle4);*/
      
   }

 
   private void initCircle() {
               
      /*Edge dots(x,y,40,40)=>dot position and size*/            
      circle = new Ellipse2D.Double(x0,y0,40,40);
      /*circle2 = new Ellipse2D.Double(x0,y2,40,40);
      circle3 = new Ellipse2D.Double(x2,y0,40,40);
      circle4 = new Ellipse2D.Double(x2,y2,40,40);*/
      
   }

   public void actionPerformed(ActionEvent e) {
      //infinite motion
      repaint();
      //velocity up (motion activate)
      x += velx;
      y += vely;
   }

   public void keyPressed(KeyEvent e) {
      int code = e.getKeyCode();
      if(code == KeyEvent.VK_UP) {
         velx = 0;
         vely = -1;
      }
      if(code == KeyEvent.VK_DOWN) {
         velx = 0;
         vely = 1;
      }
      if(code == KeyEvent.VK_LEFT) {
         velx = -1;
         vely = 0;
      }
      if(code == KeyEvent.VK_RIGHT) {
         velx = 1;
         vely = 0;
      }
   }

   public void keyReleased(KeyEvent e) {
      //Stopping the motion when key released
      velx=0;
      vely=0;
   }

   public void keyTyped(KeyEvent e) {}
   
   
   
   public static void main(String[] arguments) throws IOException {
   
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
       
       //read text file
       File file = new File("C:\\Users\\SNU1\\git\\BMI\\BMI\\text\\test.txt"); 

       BufferedReader br = new BufferedReader(new FileReader(file)); 

       String st; 
       while ((st = br.readLine()) != null) 
        System.out.println(st); 
        
    
  }
   
}