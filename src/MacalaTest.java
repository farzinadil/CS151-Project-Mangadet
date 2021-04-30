public class MacalaTest {
    public static void main (String args[]){
        Style style = new StyleTest();
        MancalaModel mancalaModel = new MancalaModel();
        BoardView boardView = new BoardView(mancalaModel, style);
    }
}
