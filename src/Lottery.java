import java.util.HashSet;
import java.util.Set;

/**
 * This class represents Lottery 7 of 49 The purpose of this task is to
 * implement rateCombination() with complexity O[N], where N=7
 */
public class Lottery {
	private static int[] winningCombination;

	public Lottery(int[] winningCombination) {
		Lottery.winningCombination = winningCombination;
	}

	public int rateCombination(int playerCombination[]) {
		Set<Integer> playerCombinationSet = new HashSet<>();

		for (int i = 0; i < playerCombination.length; i++) {
			playerCombinationSet.add(playerCombination[i]);
			playerCombinationSet.add(winningCombination[i]);
		}
		return playerCombination.length * 2 - playerCombinationSet.size();
	}

	/**
	 * Simple sanity test
	 */
	public static void main(String[] args) {
		Lottery loto = new Lottery(new int[]{5,2,17,48,43,7,9}) ;
		if (loto.rateCombination(new int[] {3,5,12,17,44,10,7}) != 3) {
			System.out.println("Test 1 failed");
            return;			
		}
		if (loto.rateCombination(new int[] {3,5,12,17,49,9,7}) != 5) {
			System.out.println("Test 2 failed");
            return;			
		}
		System.out.println("Success");
	}
}
