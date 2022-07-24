package telran.text.comparators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class DatesComparator implements Comparator<String> {
	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

	@Override
	public int compare(String o1, String o2) {
		int result = -1;

		try {
			result = sdf.parse(o1).compareTo(sdf.parse(o2));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
