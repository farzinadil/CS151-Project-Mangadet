import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class PlayerController {
    private MancalaModel mancalaModel;
    private BoardView boardView;
    public PlayerController(MancalaModel mancalaModel, BoardView boardView){
        this.mancalaModel = mancalaModel;
        this.boardView = boardView;

                //this.boardView.addInputListner(new InputListner());
    }
    public void updateBoardView(){

    }
    class  InputListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
