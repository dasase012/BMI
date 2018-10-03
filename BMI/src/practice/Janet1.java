package practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class Janet1 extends JFrame
{
  int questionShowing = 0;
  final int QUESTIONS = 3;
  final int CHOICES = 4;
  final int DUMMY_INDEX = 4;
  DiscQuestion[] discQuestions = new DiscQuestion[QUESTIONS];
  JRadioButton[] leftRadioButtons = new JRadioButton[CHOICES+1];//+1 for the 'DUMMY_INDEX'
  JRadioButton[] rightRadioButtons = new JRadioButton[CHOICES+1];
  ButtonGroup leftRBgroup = new ButtonGroup();
  ButtonGroup rightRBgroup = new ButtonGroup();
  JLabel[] choiceLabels = new JLabel[CHOICES];
  JButton previousButton = new JButton("Previous");
  JButton nextButton = new JButton("Next");
  JButton doneButton = new JButton("Done");
  public Janet1()
  {
    setSize(350,250);
    setLocation(400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    try
    {
      readInData();
    }
    catch(IOException ioe)
    {
      JOptionPane.showMessageDialog(null,"Error reading in data, exiting");
      System.exit(0);
    }
    buildGUI();
    setTheQuestion(questionShowing);
    previousButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        if(questionShowing > 0)
        {
          questionShowing--;
          setTheQuestion(questionShowing);
        }}});
    nextButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        if(questionShowing < QUESTIONS-1)
        {
          questionShowing++;
          setTheQuestion(questionShowing);
        }}});
  }
  public void readInData() throws IOException
  {
    FileReader file = new FileReader("text/test.txt");
    BufferedReader fileInput = new BufferedReader(file);
    String[] lines = new String[QUESTIONS*CHOICES*3];//each choice has 3 lines = choice + 2 descriptions
    DiscOption[] discOptions = new DiscOption[CHOICES*3];
    for(int x = 0, y = lines.length; x < y; x++)
    {
      lines[x] = fileInput.readLine();
      if(x % 3 == 2)
      {
        discOptions[x/3] = new DiscOption(lines[x-2],lines[x-1],lines[x]);
      }
    }
    for(int x = 0, y = discQuestions.length; x < y; x++)
    {
      discQuestions[x] = new DiscQuestion(new DiscOption[]{
        discOptions[x*4],discOptions[x*4 +1],discOptions[x*4+2],discOptions[x*4 +3]});
    }
  }
  public void buildGUI()
  {
    JLabel topLabel = new JLabel("Please Select MOST for one phrase",JLabel.CENTER);
    topLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
    JPanel midPanel = new JPanel(new BorderLayout());
    JPanel leftRBpanel = new JPanel(new GridLayout(CHOICES+1,1));
    JPanel choicesPanel = new JPanel(new GridLayout(CHOICES+1,1));
    JPanel rightRBpanel = new JPanel(new GridLayout(CHOICES+1,1));
    JLabel mostLabel = new JLabel("MOST");
    JLabel leastLabel = new JLabel("LEAST");
    mostLabel.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
    mostLabel.setForeground(new java.awt.Color(255,51,51));
    leastLabel.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
    leastLabel.setForeground(new java.awt.Color(255,51,51));
    leftRBpanel.add(mostLabel);
    choicesPanel.add(new JLabel("                                    "));//spacer
    rightRBpanel.add(leastLabel);
    for(int x = 0; x < CHOICES+1; x++)
    {
      leftRadioButtons[x] = new JRadioButton();
      leftRBgroup.add(leftRadioButtons[x]);
      rightRadioButtons[x] = new JRadioButton();
      rightRBgroup.add(rightRadioButtons[x]);
      if(x < CHOICES)
      {
        choiceLabels[x] = new JLabel("",JLabel.CENTER);
        JPanel p = new JPanel();
        p.add(leftRadioButtons[x]);
        leftRBpanel.add(p);
        choicesPanel.add(choiceLabels[x]);
        JPanel p1 = new JPanel();
        p1.add(rightRadioButtons[x]);
        rightRBpanel.add(p1);
      }
    }
    midPanel.add(leftRBpanel,BorderLayout.WEST);
    midPanel.add(choicesPanel,BorderLayout.CENTER);
    midPanel.add(rightRBpanel,BorderLayout.EAST);
    JPanel buttonPanel = new JPanel(new GridLayout(1,3));
    buttonPanel.add(previousButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(doneButton);
    JPanel bottomPanel = new JPanel();
    bottomPanel.add(buttonPanel);
    JPanel midHoldingPanel = new JPanel();
    midHoldingPanel.add(midPanel);
    getContentPane().add(topLabel,BorderLayout.NORTH);
    getContentPane().add(midHoldingPanel,BorderLayout.CENTER);
    getContentPane().add(bottomPanel,BorderLayout.SOUTH);
  }
  public void setTheQuestion(int questionNumber)
  {
    leftRadioButtons[DUMMY_INDEX].setSelected(true);
    rightRadioButtons[DUMMY_INDEX].setSelected(true);
    DiscOption[] tempOptions = discQuestions[questionNumber].choices;
    for(int x = 0, y = choiceLabels.length; x < y; x++)
    {
      choiceLabels[x].setText(tempOptions[x].toString());
    }
  }
  public static void main(String[] args){new Janet1().setVisible(true);}
}
class DiscQuestion
{
  DiscOption[] choices;
  public DiscQuestion(DiscOption[] c){choices = c;}
}
class DiscOption
{
  String option;
  String description1;
  String description2;
  public DiscOption(String o, String d1, String d2)
  {
    option = o; description1 = d1; description2 = d2;
  }
  public String toString(){return option.split(",")[0];}
}