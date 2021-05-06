public class PlayerController {
    /**
     * Controller.
     *  @param mancalaModel data model that stores and processes pits and turns
     *  @param player numerical value, a value of 1 represents player 1 and 2 represents player 2
     *  @param previouslyUndone boolean set to true if a move was undone recently
     *  @param gameStatus String that displays the status of the game, ie Player 1 turn, Player 2 turn
     *  @param gameStarted boolean that represents weather the game has started
     *  @param gameOver boolean that represents weather the game has ended
     *  @param winner numerical value, a value of 1 represents player 1 has won and 2 represents player 2 has won
     *  @param previousPits storage of the pits to revert to in case of a player chooses to redo a move
     */
    private MancalaModel mancalaModel;
    private int player;
    private boolean previouslyUndone;
    private String gameStatus;
    private boolean gameStarted;
    private boolean gameOver;
    private String winner;
    int previousPits[];

    /**
     * Constructor of controller.
     * @param mancalaModel data model that stores and processes pits and turns
     */
    public PlayerController(MancalaModel mancalaModel){
        this.mancalaModel = mancalaModel;
        player = 1;
        gameStatus = "Select the number of stones per pit to begin game";
        gameStarted = false;
        gameOver = false;

    }
    /**
     * Returns the pits array index number of the pit that the mouse has clicked
     * @param mouseXCoordinate X coordinate of mouse
     * @param mouseYCoordinate Y coordinate of mouse
     * @return the pit number of the mouse click or -1 if no pit is clicked
     */
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

    /**
     * Returns the gameStatus
     * @return gameStatus the status of the game
     */
    public String getGameStatus(){
        return gameStatus;
    }
    /**
     * initializes pits array and sets it to pits of mancalaModel only if the game hasn't started.
     * @param stoneCount the number of stones per pit
     */
    public void updateBoardView(int stoneCount){
        if (!gameStarted){
            int[] pits = {stoneCount, stoneCount, stoneCount, stoneCount, stoneCount, stoneCount, 0, stoneCount, stoneCount, stoneCount, stoneCount, stoneCount, stoneCount, 0};
            mancalaModel.setPits(pits);
            gameStarted = true;
            gameStatus = "Player 1 turn";
        }

    }
    /**
     * Checks for valid move by player and calls move if so
     * @param mouseXCoordinate X coordinate of mouse
     * @param mouseYCoordinate Y coordinate of mouse
     */
    public void mouseClick (int mouseXCoordinate, int mouseYCoordinate){
        int pitCLicked = pitClicked(mouseXCoordinate, mouseYCoordinate);
        if (pitCLicked >= 0 && pitCLicked <= 5 && player == 1 && !gameOver && mancalaModel.getPits()[pitCLicked] != 0){
            move(pitCLicked);
        }
        else if(pitCLicked >= 7 && pitCLicked <= 12 && player == 2 && !gameOver && mancalaModel.getPits()[pitCLicked] != 0){
            move(pitCLicked);
        }
    }
    /**
     * Checks weather the game has ended.
     */
    private void checkGameOver (){
        int[] pits = mancalaModel.getPits();
        if (pits[0] == 0 && pits[1] == 0 && pits[2] == 0 && pits[3] == 0 && pits[4] == 0 && pits[5] == 0 && pits[7] == 0 && pits[8] == 0 && pits[9] == 0 && pits[10] == 0 && pits[11] == 0 && pits[12] == 0){
            if (pits[6] > pits[13]){
                winner = "PLayer 1 wins";
            }
            else if (pits[13] > pits[6]){
                winner = "Player 2 wins";
            }
            else {
                winner = "Tie Game";
            }
            gameStatus = winner;
            gameOver = true;
        }
    }
    /**
     * Calls move of mancalaModel to fulfil the player's move
     * @param pit The index of the pit in pits[] that has been selected by a player
     */
    private void move(int pit){
        previousPits = mancalaModel.getPits();
        if (mancalaModel.move(pit,player-1)){
            gameStatus = "Player " + player + "gets 2nd turn";
        }
        else if (player == 1){
            player = 2;
            gameStatus = "Player " + player + "'s turn";
        }
        else {
            player = 1;
            gameStatus = "Player " + player + "'s turn";
        }
        previouslyUndone = false;
        checkGameOver();
    }
    /**
     * Reverts a move by setting pits[] in mancalaModel to previousPits
     */
    public void undo(){
        if (previouslyUndone){
            gameStatus = "Cannot undo twice";
        }
        else {
            mancalaModel.setPits(previousPits);
            if (player == 1){
                player = 2;
                gameStatus = "Player 2 turn";
            }
            else {
                player = 1;
                gameStatus = "Player 1 turn";
            }
            previouslyUndone = true;
        }
    }

}
