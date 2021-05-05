import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class PlayerController {
    private MancalaModel mancalaModel;
    private int player;
    private boolean previouslyUndone;
    private String gameStatus;
    private boolean gameStarted = false;
    private int pitClicked(int mouseXCoordinate, int mouseYCoordinate){
        if (mouseXCoordinate >= 100 && mouseXCoordinate <= 200 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160 ){
            return 12;
        }
        else if (mouseXCoordinate >= 225 && mouseXCoordinate <= 325 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160){
            return 11;
        }
        else if (mouseXCoordinate >= 350 && mouseXCoordinate <= 450 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160){
            return 10;
        }
        else if (mouseXCoordinate >= 475 && mouseXCoordinate <= 575 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160){
            return 9;
        }
        else if (mouseXCoordinate >= 600 && mouseXCoordinate <= 700 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160){
            return 8;
        }
        else if (mouseXCoordinate >= 725 && mouseXCoordinate <= 825 && mouseYCoordinate >= 35 && mouseYCoordinate <= 160){
            return 7;
        }
        else if (mouseXCoordinate >= 100 && mouseXCoordinate <= 200 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310 ){
            return 0;
        }
        else if (mouseXCoordinate >= 225 && mouseXCoordinate <= 325 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310){
            return 1;
        }
        else if (mouseXCoordinate >= 350 && mouseXCoordinate <= 450 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310){
            return 2;
        }
        else if (mouseXCoordinate >= 475 && mouseXCoordinate <= 575 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310){
            return 3;
        }
        else if (mouseXCoordinate >= 600 && mouseXCoordinate <= 700 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310){
            return 4;
        }
        else if (mouseXCoordinate >= 725 && mouseXCoordinate <= 825 && mouseYCoordinate >= 185 && mouseYCoordinate <= 310){
            return 5;
        }
        else return -1;
    }
    public PlayerController(MancalaModel mancalaModel){
        this.mancalaModel = mancalaModel;
        player = 1;
        gameStatus = "Choose the number of stones per pit to begin game";


    }
    public String getGameStatus(){
        return gameStatus;
    }
    public void updateBoardView(){

    }
    
    public void mouseClick (int mouseXCoordinate, int mouseYCoordinate){
    	// Player makes a move, note: method returns true if player get another move
    	boolean extraTurn = mancalaModel.move(pitClicked(mouseXCoordinate, mouseYCoordinate),player);
    	if (!extraTurn) {
    		player++;
    		if (player ==3) {player=1;}
    	}
        System.out.println(pitClicked(mouseXCoordinate, mouseYCoordinate));
    }
    
    //private void move(int pit){

      //  previouslyUndone = false;
    //}
    public void undo(){
        if (previouslyUndone){

        }
        else {
            // currentmanclaa
            previouslyUndone = true;
        }
    }

}
