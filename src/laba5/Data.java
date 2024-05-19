package laba5;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import laba5.dop.TheBestLinkedList;

public class Data {
	private List<Person> people = new TheBestLinkedList<Person>();
	private String filename;
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void add(Person person) {
		people.add(person);
	}
	public int getLastId() {
		if (people.size() == 0) return 0;
		return people.get(people.size()-1).getId();
	}
	public List<Person> getPeople() {
		return  people;
		
	}
	public void save() {
		String safe = "";
		for (int i = 0; i<people.size(); i++) {
			safe = safe + people.get(i).toCSVFormat() + "\n";
		}
		try {
			FileOutputStream file = new FileOutputStream(filename);
			OutputStreamWriter output = new OutputStreamWriter(file);
			output.write(safe);
			output.close();
	    }

	    catch (Exception e) {
	    	e.getStackTrace();
	    }
	}
}
