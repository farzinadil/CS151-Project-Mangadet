import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BoardView extends JFrame implements ChangeListener {
    MancalaModel mancalaModel;
    Style style;
    private static final int ICON_WIDTH = 1000;
    private static final int ICON_HEIGHT = 600;

    public BoardView (MancalaModel mancalaModel, Style style){
        this.mancalaModel = mancalaModel;
        this.style = style;
        Icon barIcon = new Icon()
        {
            public int getIconWidth() { return ICON_WIDTH; }
            public int getIconHeight() { return ICON_HEIGHT; }
            public void paintIcon(Component c, Graphics g, int x, int y)
            {
                Graphics2D g2 = (Graphics2D) g;
                Rectangle2D.Double leftRectangle = new Rectangle2D.Double(25, 25, 50, 300);
                Rectangle2D.Double rightRectangle = new Rectangle2D.Double(925, 25, 50, 300);
                Ellipse2D.Double b6 = new Ellipse2D.Double(100, 25, 100, 125);
                Ellipse2D.Double b5 = new Ellipse2D.Double(225, 25, 100, 125);
                Ellipse2D.Double b4 = new Ellipse2D.Double(350, 25, 100, 125);
                Ellipse2D.Double b3 = new Ellipse2D.Double(475, 25, 100, 125);
                Ellipse2D.Double b2 = new Ellipse2D.Double(600, 25, 100, 125);
                Ellipse2D.Double b1 = new Ellipse2D.Double(725, 25, 100, 125);
                Ellipse2D.Double a6 = new Ellipse2D.Double(100, 175, 100, 125);
                Ellipse2D.Double a5 = new Ellipse2D.Double(225, 175, 100, 125);
                Ellipse2D.Double a4 = new Ellipse2D.Double(350, 175, 100, 125);
                Ellipse2D.Double a3 = new Ellipse2D.Double(475, 175, 100, 125);
                Ellipse2D.Double a2 = new Ellipse2D.Double(600, 175, 100, 125);
                Ellipse2D.Double a1 = new Ellipse2D.Double(725, 175, 100, 125);
                g2.draw(leftRectangle);
                g2.draw(rightRectangle);
                g2.draw(b6);
                g2.draw(b5);
                g2.draw(b4);
                g2.draw(b3);
                g2.draw(b2);
                g2.draw(b1);
                g2.draw(a6);
                g2.draw(a5);
                g2.draw(a4);
                g2.draw(a3);
                g2.draw(a2);
                g2.draw(a1);

            }
        };
        JLabel barIconLabel = new JLabel(barIcon);
        add(barIconLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);



        //add(addMouseListener();)
    }
    /*
    void addCalculateListener(ActionListener listenForCalcButton){
        calculateButton.addActionListener(listenForCalcButton);
    }
    */

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
