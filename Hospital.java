import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Hospital {
	private HashSet<Doctor> doctors = new HashSet<Doctor>();
	private HashSet<Patient> patients = new HashSet<Patient>();

	public void cure() {
		for (Doctor doctor : this.doctors) {
			for (Patient patient : this.patients) {
				doctor.cure(patient);
			}
		}
	}

	public void listPatients() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("LIST OF PATIENTS SORTED BY NUMBER OF DISEASES THEY HAVE");
		System.out.println("--------------------------------------------------------------");
		ArrayList<Patient> sortedList = new ArrayList<Patient>(patients);
		Collections.sort(sortedList);
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(
					sortedList.get(i).getName() + " HAS " + sortedList.get(i).getDiseases().size() + " DISEASES ");
		}
		System.out.println();

	}

	public void listDoctors() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("LIST OF DOCTORS BY NUMBER OF DISEASES THEY CURED");
		System.out.println("--------------------------------------------------------------");
		ArrayList<Doctor> sortedList = new ArrayList<Doctor>(doctors);
		Collections.sort(sortedList);
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(
					sortedList.get(i).getName() + " CURED " + sortedList.get(i).getCuredDiseases() + " DISEASES");
		}
		System.out.println();

	}

	public void listStatistics() {
		int nr = 0;

		for (Patient patient2 : this.patients) {
			if (patient2.getDiseases().size() == 0)
				nr++;
		}
		System.out.println("IN THIS HOSPITAL " + nr + " PATIENTS HAVE BEEN CURED.GOOD FOR THEM!");
		System.out.println();
		nr = this.patients.size() - nr;
		System.out.println("IN MY HOSPITAL " + nr + " HAVEN T BEEN CURED.FUNERAL FURNISHERS APPLICATION , NEXT TIME.");

		System.out.println();
	}

	public static void main(String args[]) throws InvalidDataException {
		Hospital hospital = new Hospital();

		HashSet<Disease> diseases = new HashSet<Disease>();

		Disease dis1 = new Disease("Boala somnului in sesiune", Severity.HIGH);
		Disease dis7 = new Disease("Stresat/a de examene", Severity.HIGH);
		Patient pat1 = new Patient(9999992, "Ungureanu Florin");
		pat1.addDisease(dis1);
		pat1.addDisease(dis7);

		hospital.patients.add(pat1);

		Patient pat7 = new Patient(9999997, "Kriszta Gombos");
		pat7.addDisease(dis7);
		hospital.patients.add(pat7);

		Disease dis2 = new Disease("Disfunctii erectile", Severity.HIGH);
		Patient pat2 = new Patient(9999991, "Calin ");
		pat2.addDisease(dis2);
		hospital.patients.add(pat2);

		Disease dis3 = new Disease("Gripa", Severity.LOW);
		Patient pat3 = new Patient(9999993, "Ion Caragiale");
		pat3.addDisease(dis3);
		hospital.patients.add(pat3);

		Disease dis4 = new Disease("Migrene", Severity.MEDIUM);
		Patient pat4 = new Patient(9999994, "Istvan Nagy");
		pat4.addDisease(dis4);
		hospital.patients.add(pat4);

		Disease dis5 = new Disease("Stres", Severity.HIGH);
		Patient pat5 = new Patient(9999995, "Lorin Furtuna");
		pat5.addDisease(dis5);
		hospital.patients.add(pat5);

		Disease dis6 = new Disease("Anxietate", Severity.HIGH);
		Patient pat6 = new Patient(9999996, "Vasoc Bogdan");
		pat6.addDisease(dis6);
		hospital.patients.add(pat6);

		hospital.doctors.add(new Doctor(1111111, "Ungureanu Dorin"));
		hospital.doctors.add(new Doctor(1111112, "Ungureanu Catalin"));
		hospital.doctors.add(new Doctor(1111113, "Ungureanu Sorin"));
		hospital.doctors.add(new Doctor(1111114, "Ungureanu Dorian"));

		hospital.listPatients();

		hospital.cure();

		System.out.println("-------------- AFTER DOCTOS's ATTEMPTS TO CURE THE DISEASES ---------------------");
		hospital.listPatients();

		hospital.listDoctors();
		hospital.listStatistics();

	}
}