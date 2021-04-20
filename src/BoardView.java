import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class BoardView extends JFrame implements ChangeListener {
    MancalaModel mancalaModel;
    public BoardView (MancalaModel mancalaModel){
        this.mancalaModel = mancalaModel;
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
