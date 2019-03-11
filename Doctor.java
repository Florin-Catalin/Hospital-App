import java.util.HashSet;
import java.util.Iterator;

public class Doctor extends Person implements Comparable<Doctor> {
	public static final int POS = 1;
	public static final int NEG = -1;

	private int curedDiseases = 0;

	public int getCuredDiseases() {
		return curedDiseases;
	}

	public void setCuredDiseases(int curedDiseases) {
		this.curedDiseases = curedDiseases;
	}

	public Doctor(int id, String name) throws InvalidDataException {
		super(id, name);
	}

	public void cure(Patient patient) {

		HashSet<Disease> diseases = patient.getDiseases();
		HashSet<Disease> uncuredDiseases = new HashSet<Disease>();
		int chance = (int) Math.random() * diseases.size();
		for (Disease disease : diseases) {
			int odds = (int) Math.random() * diseases.size();
			if (odds <= chance) {
				if (disease.cure()) {
					uncuredDiseases.add(disease);
					this.curedDiseases++;
					System.out.println("Doctor " + this.getName() + " cured " + disease.getName() + " at patient "
							+ patient.getName());
				}
			}

		}
		for (Disease disease : uncuredDiseases) {
			patient.removeDisease(disease);
		}

	}

	@Override
	public int compareTo(Doctor doctor) {
		if (doctor.curedDiseases < this.curedDiseases)
			return POS;
		return NEG;
	}

}
