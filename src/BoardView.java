import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BoardView extends JFrame implements ChangeListener {
    MancalaModel mancalaModel;
    int[] pits;
    Style style;
    private static final int ICON_WIDTH = 1000;
    private static final int ICON_HEIGHT = 600;

    public BoardView (MancalaModel mancalaModel, Style style){
        this.mancalaModel = mancalaModel;
        pits = this.mancalaModel.getPits();
        this.style = style;
        Icon boardIcon = new Icon()
        {
            public int getIconWidth() { return ICON_WIDTH; }
            public int getIconHeight() { return ICON_HEIGHT; }
            public void paintIcon(Component c, Graphics g, int x, int y)
            {
                Graphics2D g2 = (Graphics2D) g;
                Rectangle2D.Double leftRectangle = new Rectangle2D.Double(25, 35, 50, 300);
                Rectangle2D.Double rightRectangle = new Rectangle2D.Double(850, 35, 50, 300);
                Ellipse2D.Double b6 = new Ellipse2D.Double(100, 35, 100, 125);
                Ellipse2D.Double b5 = new Ellipse2D.Double(225, 35, 100, 125);
                Ellipse2D.Double b4 = new Ellipse2D.Double(350, 35, 100, 125);
                Ellipse2D.Double b3 = new Ellipse2D.Double(475, 35, 100, 125);
                Ellipse2D.Double b2 = new Ellipse2D.Double(600, 35, 100, 125);
                Ellipse2D.Double b1 = new Ellipse2D.Double(725, 35, 100, 125);
                Ellipse2D.Double a6 = new Ellipse2D.Double(100, 185, 100, 125);
                Ellipse2D.Double a5 = new Ellipse2D.Double(225, 185, 100, 125);
                Ellipse2D.Double a4 = new Ellipse2D.Double(350, 185, 100, 125);
                Ellipse2D.Double a3 = new Ellipse2D.Double(475, 185, 100, 125);
                Ellipse2D.Double a2 = new Ellipse2D.Double(600, 185, 100, 125);
                Ellipse2D.Double a1 = new Ellipse2D.Double(725, 185, 100, 125);
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

                /*
                Ellipse2D.Double sc = new Ellipse2D.Double(130, 45, 10, 10);
                g2.fill(sc);
                Ellipse2D.Double sc2 = new Ellipse2D.Double(145, 45, 10, 10);
                g2.fill(sc2);
                Ellipse2D.Double sc3 = new Ellipse2D.Double(160, 45, 10, 10);
                g2.fill(sc3);
                 */
                int[] testarray = {3};
                int start = 130;
                for (int i = 0; i < testarray[0]; i++){
                    g2.fill( new Ellipse2D.Double(start+i*15, 45, 10, 10));
                }

            }
        };
        JLabel textA1 = new JLabel("A1");
        textA1.setBounds(150, 300, 50, 50);
        add(textA1);

        JLabel textA2 = new JLabel("A2");
        textA2.setBounds(275, 300, 50, 50);
        add(textA2);

        JLabel textA3 = new JLabel("A3");
        textA3.setBounds(400, 300, 50, 50);
        add(textA3);

        JLabel textA4 = new JLabel("A4");
        textA4.setBounds(525, 300, 50, 50);
        add(textA4);

        JLabel textA5 = new JLabel("A5");
        textA5.setBounds(650, 300, 50, 50);
        add(textA5);

        JLabel textA6 = new JLabel("A6");
        textA6.setBounds(775, 300, 50, 50);
        add(textA6);

        JLabel textB1 = new JLabel("B1");
        textB1.setBounds(150, 0, 50, 50);
        add(textB1);

        JLabel textB2 = new JLabel("B2");
        textB2.setBounds(275, 0, 50, 50);
        add(textB2);

        JLabel textB3 = new JLabel("B3");
        textB3.setBounds(400, 0, 50, 50);
        add(textB3);

        JLabel textB4 = new JLabel("B4");
        textB4.setBounds(525, 0, 50, 50);
        add(textB4);

        JLabel textB5 = new JLabel("B5");
        textB5.setBounds(650, 0, 50, 50);
        add(textB5);

        JLabel textB6 = new JLabel("B6");
        textB6.setBounds(775, 0, 50, 50);
        add(textB6);


        JLabel barIconLabel = new JLabel(boardIcon);
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
        repaint();
        pits = mancalaModel.getPits();
    }
}
