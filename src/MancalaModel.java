import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class MancalaModel {
	// Position A1-A6 is 0-5, B1-B6 is 7-12,
	// 6 is the main pit for A, and 13 is the main pit for B
	private int[] pits;
	ArrayList<ChangeListener> listeners;
	
	
	MancalaModel() {
		// set all pits to 0
		pits = new int[14];
		for (int i = 0; i < 14; i++) {
			pits[i]=0;
		}
		listeners = new ArrayList<ChangeListener>();
	}
	
	/**
	 * moves the stones recursively for one turn.
	 * @param position integer from 0-5 or 7-12.
	 * @param player integer 0 for player A, 1 for player B
	 * @return true if the player gets an extra turn, false if not
	 */
	public boolean move(int position, int player) {
		int hand = getStones(position); // this is like picking up the stones
		setPits(position,0);
		int pos = position;
		boolean extraTurn = false; // will return true if player gets an extra turn

		while(hand>0) {
			// First check if we are in mancala pit
			if (pos == 6 || pos == 13) {
				// only put here if its player A's turn
				if (pos == 6 && player == 0) {
					setPits(pos,getStones(pos)+1);
					hand--;
				}
				// only put here if its player B's turn
				else if (pos == 13 && player == 1) {
					setPits(pos,getStones(pos)+1);
					hand--;
				}
				// hand will only be 0 here if the last stone has just been put into a mancala pit
				if (hand == 0) { 
					extraTurn = true;
				}
			}
			else {
				setPits(pos,getStones(pos)+1);
				hand--;
				// need to check if the last stone has been placed.
				// need to check if a steal is possible
				if (hand == 0) {
					// player A
					if (player == 0 && (pos >= 0 && pos <= 5)) {
						if (getStones(pos) == 1 && getStones(pos+7)>0) {
							// put into player A's mancala
							setPits(0,getStones(0) + getStones(pos+7)+1);
							setPits(pos,0);
							setPits(pos+7,0);
						}
					}
					// player B
					else if (player == 1 && (pos >= 7 && pos <= 12)) {
						if (getStones(pos) == 1 && getStones(pos+7)>0) {
							// put into player B's mancala
							setPits(6,getStones(pos) + getStones(pos-7)+1);
							setPits(pos,0);
							setPits(pos-7, 0);
						}
					}
				}
			}
		}
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
		for (int i = 0; i < pits.length; i++){
			System.out.print(pits[i] + " ");
		}
		System.out.println("");
		return extraTurn;
	}
	
	public void setPits(int position, int value) {
		// Update data
		System.out.println("here");
		pits[position] = value;
		// Notify view
		ChangeEvent event = new ChangeEvent(this);
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
	}

	public void setPits(int[] pits){
		this.pits = pits;
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
	}

	public int[] getPits(){
		return pits;
	}
	
	public int getStones(int i) {
		return pits[i];
	}

	public void attach(ChangeListener c)
	{
		listeners.add(c);
	}
}