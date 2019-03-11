import java.util.Random;

public class Disease {

	private String name;
	private Severity severity;

	public String getName() {
		return name;
	}

	public Severity getSeverity() {
		return severity;
	}

	public Disease(String name, Severity severity) {
		this.name = name;
		this.severity = severity;
	}

	Random random = new Random();

	public boolean cure() {
		switch (severity) {
		case LOW:
			return (random.nextInt(4) > 0) ? true : false; // 75%
		case MEDIUM:
			return (random.nextInt(2) > 0) ? true : false; // 50%
		case HIGH:
			return (random.nextInt(5) < 2) ? true : false;// 25%

		default:
			return false;

		}
	}
}
