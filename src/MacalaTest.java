public class MacalaTest {
    public static void main (String args[]){
        Style style = new Style1();
        MancalaModel mancalaModel = new MancalaModel();
        PlayerController controller = new PlayerController(mancalaModel);
        BoardView boardView = new BoardView(mancalaModel, controller, style);
    }
}
