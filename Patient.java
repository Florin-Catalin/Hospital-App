import java.util.HashSet;

public class Patient extends Person implements Comparable<Patient> {
	public static final int POS = 1;
	public static final int NEG = -1;

	private HashSet<Disease> diseases = new HashSet<Disease>();

	public HashSet<Disease> getDiseases() {
		return diseases;
	}

	public Patient(int id, String name) throws InvalidDataException {
		super(id, name);

	}

	public boolean hasDisease(Disease disease) {
		if (this.diseases.contains(disease))
			return true;
		else
			return false;
	}

	public void addDisease(Disease disease) {
		this.diseases.add(disease);
	}

	public void removeDisease(Disease disease) {
		this.diseases.remove(disease);
	}

	public boolean cureDisease(Disease disease) {
		if (this.diseases.contains(disease)) {
			this.removeDisease(disease);
			return true;
		} else
			return false;
	}

	@Override
	public int compareTo(Patient patient) {
		if (patient.getDiseases().size() > this.getDiseases().size())
			return POS;
		return NEG;
	}

}
