/**
 * This class represents Lottery 7 of 49 The purpose of this task is to
 * implement rateCombination() with complexity O[N], where N=7
 */
public class Lottery {
	private int[] winningCombination;
	/**
	 * Constructor
	 * @param winningCombination - array of 7 unique numbers in range [1 to 49] (no need to check)        
	 */
	public Lottery(int[] winningCombination) {
		int[] lut = new int[50];
		for (int i = 0; i < winningCombination.length; i++) {
			lut[winningCombination[i]] = winningCombination[i];
		}
		this.winningCombination = lut;
	}

	/**
	 * Rates player's combination of balls, comparing it with winner combination
	 * 
	 * @param playerCombination - array of 7 unique numbers in range [1 to 49] (no
	 *                          need to check)
	 * @return number of winning balls in player's combination
	 */
	public int rateCombination(int playerCombination[]) {
		// TODO : return rate in O[N], where N=7. For example:
		// winningComination 5,2,17,48,43,7,9
		// playerCmbination: 3,5,12,17,44,10,7 ==> rate 3 (because 5,17,7 are hit)

		int rate = 0;
		for (int i = 0; i < playerCombination.length; i++) {
			if ( winningCombination[playerCombination[i]]!=0) {
				rate++;
			}
		}
		return rate;
	}

	/**
	 * Simple sanity test
	 */
	public static void main(String[] args) {
		Lottery loto = new Lottery(new int[] { 5, 2, 17, 48, 43, 7, 9 });
		if (loto.rateCombination(new int[] { 3, 5, 12, 17, 44, 10, 7 }) != 3) {
			System.out.println("Test 1 failed");
			return;
		}
		if (loto.rateCombination(new int[] { 3, 5, 12, 17, 49, 9, 7 }) != 5) {
			System.out.println("Test 2 failed");
			return;
		}
		System.out.println("Success");
	}
}
