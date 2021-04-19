
public class MancalaModel {
	// Position A1-A6 is 0-5, B1-B6 is 7-12,
	// 6 is the main pit for A, and 13 is the main pit for B
	private int[] pits = new int[14];
	
	/**
	 * moves the stones recursively for one turn.
	 * @param position integer from 0-5 or 7-12.
	 * @param player integer 0 for player A, 1 for player B
	 * @return true if the player gets an extra turn, false if not
	 */
	public boolean move(int position, int player) {
		int hand = pits[position]; // this is like picking up the stones
		pits[position] = 0;
		int pos = position;
		boolean extraTurn = false; // will return true if player gets an extra turn
		// purposefully does not put all stones so the final stone can be done
		// outside of the for loop
		//for (int i = position+1; i<position+hand; i++) {
		//	if (position==6 && player == 0)
		//}
		while(hand>0) {
			// First check if we are in mancala pit
			if (pos == 6 || pos == 13) {
				// only put here if its player A's turn
				if (pos == 6 && player == 0) {
					pits[pos]++;
					hand--;
				}
				// only put here if its player B's turn
				else if (pos == 13 && player == 1) {
					pits[pos]++;
					hand--;
				}
				// hand will only be 0 here if the last stone has just been put into a mancala pit
				if (hand == 0) { 
					extraTurn = true;
				}
			}
			else {
				pits[pos]++;
				hand--;
				// need to check if the last stone has been placed.
				// need to check if a steal is possible
				if (hand == 0) {
					// player A
					if (player == 0 && (pos >= 0 && pos <= 5)) {
						if (pits[pos] == 1 && pits[pos+7]>0) {
							// put into player A's mancala
							pits[0] += pits[pos+7]+1;
							pits[pos] = 0;
							pits[pos+7] = 0;
						}
					}
					// player B
					else if (player == 1 && (pos >= 7 && pos <= 12)) {
						if (pits[pos] == 1 && pits[pos+7]>0) {
							// put into player B's mancala
							pits[6] += pits[pos-7]+1;
							pits[pos] = 0;
							pits[pos-7] = 0;
						}
					}
				}
			}
		}
		return extraTurn;
	}
}
