package telran.people;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person implements Comparable<Person> {
	private long id;
	private int birthYear;
	private String email;

	public Person(long id, int birthYear, String email) {
		this.id = id;
		this.birthYear = birthYear;
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
		Matcher matcher = pattern.matcher(email);
		boolean matches = matcher.matches();
		if (!matches) {
			throw new IllegalArgumentException(String.format("%s - wrong email address", email));
		}
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public int compareTo(Person o) {
		return Long.compare(this.id, o.id);
	}
}