package practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SimpleAnimation{
    int x = 70;
    int y = 70;
    JButton startBtn;
    JPanel ball;
    public void createLayout(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        ball = new Ball();
        startBtn = new JButton("START ANIM");
        startBtn.addActionListener(new StartBtnListener());
        frame.getContentPane().add(ball,BorderLayout.CENTER);
        frame.getContentPane().add(startBtn,BorderLayout.SOUTH);
        //
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    public void startAnim(){
        x = 70;
        y = 70;
        for(int i = 0; i<130; i++){
            x++;
            y++;
            ball.repaint();
            try{
                Thread.sleep(50);
            }catch(Exception ex){
                ex.getMessage();
            }
        }
    }
    public static void main(String[] args){
        SimpleAnimation gui = new SimpleAnimation();
        gui.createLayout();
    }
     
    class Ball extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.RED);
            g.fillOval(x,y,40,40);
        }
    }
    class StartBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            startAnim();
        }
    }
}
