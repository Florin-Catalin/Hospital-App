
public class Person {

	private int ID;
	private String name;

	public static final int ID_LENGTH = 7;
	public static final int ID_NAME_LENGTH = 6;

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int id, String name) throws InvalidDataException {
		if (name.length() >= ID_NAME_LENGTH)
			this.name = name;
		else
			throw new InvalidDataException("Name must be at least " + ID_NAME_LENGTH + "charachters");

		if ((int) Math.log10(id) + 1 == ID_LENGTH)// Math.log10(id) + 1 actually gives the lenght of int
			this.ID = id;
		else
			throw new InvalidDataException("ID must be of length " + ID_LENGTH);

	}

	// I didn't used it actually
	public String toString() {
		return "ID" + "name";

	}

}
