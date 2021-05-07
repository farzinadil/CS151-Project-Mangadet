import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BoardView extends JFrame implements ChangeListener {
    /**
     *  Board GUI
     *  @param mancalaModel data model that stores and processes pits and turns
     *  @param controller controller portion of MVC that handles user interactions
     *  @param pits data model that stores and processes pits and turns
     *  @param style style characteristics of GUI components
     *  @param ICON_WIDTH width of Icon
     *  @param ICON_HEIGHT height of Icon
     */
    MancalaModel mancalaModel;
    PlayerController controller;
    int[] pits;
    Style style;
    private static final int ICON_WIDTH = 1000;
    private static final int ICON_HEIGHT = 600;

    public BoardView (MancalaModel mancalaModel, PlayerController controller, Style style){
        /**
         * The view of MVC model. Contains all GUI components of the board.
         * @param mancalaModel data model that stores and processes pits and turns
         * @param controller controller portion of MVC that handles user interactions
         * @param style style characteristics of GUI components
         * @return true if the player gets an extra turn, false if not
         */
        this.mancalaModel = mancalaModel;
        this.controller = controller;
        pits = this.mancalaModel.getPits();
        this.style = style;
        /**
         * Icon that contains shapes that represent pits, mancalas, and stones.
         */
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
                Ellipse2D.Double a1 = new Ellipse2D.Double(100, 185, 100, 125);
                Ellipse2D.Double a2 = new Ellipse2D.Double(225, 185, 100, 125);
                Ellipse2D.Double a3 = new Ellipse2D.Double(350, 185, 100, 125);
                Ellipse2D.Double a4 = new Ellipse2D.Double(475, 185, 100, 125);
                Ellipse2D.Double a5 = new Ellipse2D.Double(600, 185, 100, 125);
                Ellipse2D.Double a6 = new Ellipse2D.Double(725, 185, 100, 125);
                g2.setColor(style.getPitColor());
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


                pits = mancalaModel.getPits();
                int startX;
                int startY;
                for( int pitNumber = 0; pitNumber < pits.length; pitNumber++){
                    if (pitNumber == 6){
                        startX = 853;
                        startY = 37;
                    }
                    else if (pitNumber == 13){
                        startX = 32;
                        startY = 37;
                    }
                    else if (pitNumber <= 5){
                    	startX = 130+(pitNumber)*125;
                        startY = 195;
                    }
                    else{
                        startX = 750-(pitNumber-7)*125;
                        startY = 45;

                    }
                    int rowCount = 0;
                    for (int rowIndex = 0; rowIndex < pits[pitNumber]; rowIndex++){
                        if (rowCount == 3){
                            startY += 15;
                            startX -= 45;
                            rowCount = 0;
                        }
                        if(pitNumber >= 0 && pitNumber <= 6) {
                          g2.setColor(style.getStoneColorP1());
                        }
                        else if(pitNumber >= 7 && pitNumber <= 13) {
                          g2.setColor(style.getStoneColorP2());
                        }
                        g2.fill( new Ellipse2D.Double(startX, startY, 10, 10));
                        startX += 15;
                        rowCount++;
                    }
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

        JLabel textB1 = new JLabel("B6");
        textB1.setBounds(150, 0, 50, 50);
        add(textB1);

        JLabel textB2 = new JLabel("B5");
        textB2.setBounds(275, 0, 50, 50);
        add(textB2);

        JLabel textB3 = new JLabel("B4");
        textB3.setBounds(400, 0, 50, 50);
        add(textB3);

        JLabel textB4 = new JLabel("B3");
        textB4.setBounds(525, 0, 50, 50);
        add(textB4);

        JLabel textB5 = new JLabel("B2");
        textB5.setBounds(650, 0, 50, 50);
        add(textB5);

        JLabel textB6 = new JLabel("B1");
        textB6.setBounds(775, 0, 50, 50);
        add(textB6);

        JButton undoButton = new JButton("Undo");
        undoButton.setBounds(25, 450, 100, 35);
        add(undoButton);

        String[] stoneOptions = {"2", "3", "4"};
        JComboBox stoneNumber = new JComboBox(stoneOptions);
        stoneNumber.setBounds(775, 450, 100, 35);
        add(stoneNumber);

        JLabel statusLabel = new JLabel();
        statusLabel.setText(controller.getGameStatus());
        statusLabel.setBounds(325, 450, 400, 35);
        add(statusLabel);

        MouseListener IconListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.mouseClick(e.getX(), e.getY());
                statusLabel.setText(controller.getGameStatus());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        MouseListener buttonListner = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.undo();
                statusLabel.setText(controller.getGameStatus());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        ActionListener actionListener = e -> {
            controller.updateBoardView( Integer.parseInt( stoneNumber.getSelectedItem().toString() ) );
            statusLabel.setText(controller.getGameStatus());
        };

        stoneNumber.addActionListener(actionListener);

        undoButton.addMouseListener(buttonListner);

        JLabel barIconLabel = new JLabel(boardIcon);
        barIconLabel.addMouseListener(IconListener);
        add(barIconLabel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


    }

    /**
     *  Updates Icon when model changes.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        //pits = mancalaModel.getPits();
        repaint();
    }


}
