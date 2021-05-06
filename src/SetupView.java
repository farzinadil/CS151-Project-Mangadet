import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetupView extends JFrame implements ActionListener {
	  private JButton s1;
	  private JButton s2;
	  private JButton s3;
	  private JPanel p;

	  public SetupView() {
		  p = new JPanel();
		  s1 = new JButton("Style 1");
		  s2 = new JButton("Style 2");
		  s3 = new JButton("Style 3");
		  s1.addActionListener(this);
		  s2.addActionListener(this);
		  s3.addActionListener(this);
		  p.add(s1);
		  p.add(s2);
		  p.add(s3);
		  add(p);
		  pack();
			setVisible(true);
	  }

	  public void actionPerformed(ActionEvent e) {
		  String s = ((JButton) e.getSource()).getText();
		  Style st = null;
		  int style = s.charAt(6);
		  /*if(style == 1) {
			  st = new Style1();
		  }
		  else if(style == 2) {
			  st = new Style2();
		  }
		  else if(style == 3) {
			  st = new Style3();
		  } */
		  st = new Style1();
		  MancalaModel m = new MancalaModel();
		  PlayerController p = new PlayerController(m);
		  BoardView b = new BoardView(m, p, st);
		  dispose();
	  }
}
