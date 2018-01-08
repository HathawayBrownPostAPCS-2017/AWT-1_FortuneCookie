// Fortune Teller

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FortuneTeller extends JFrame
    implements ActionListener
{
  private static final EasySound ding = new EasySound("ding.wav");

  private String fortunes[] =
    {
      "You will have a long and happy life",
      "You will get ArrayIndexOutOfBoundsException",
      "length in arrays is not a method"
    };

  private JTextField display;
  
  public FortuneTeller()
  {
    super("Fortune Teller");

    display = new JTextField("  Press \"Next\" to see your fortune...", 25);
    display.setBackground(Color.WHITE);
    display.setEditable(false);

    JButton go = new JButton("Next");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    int k = (int)(Math.random() * fortunes.length);
    display.setText("  " + fortunes[k]);
    ding.play();
  }

  public static void main(String[] args)
  {
    JFrame window = new FortuneTeller();
    window.setBounds(300, 300, 300, 100);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true); 
  }
}