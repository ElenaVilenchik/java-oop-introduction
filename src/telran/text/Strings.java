package telran.text;

import java.util.Arrays;
import telran.text.comparators.DatesComparator;

public class Strings {
	/**
	 * 
	 * @param dates array of strings containing dates in the format D/MM/YYYY D day
	 *              of month (3) without leading 0 MM month number (1-12) YYYY year
	 *              (1980)
	 * 
	 * @return array sorted by dates Use only class String and interface Comparator
	 * 
	 */

	public static String[] sortStringsAsDates(String[] dates) {
		Arrays.sort(dates, new DatesComparator());
		return dates;
	}
}