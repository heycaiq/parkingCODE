package garage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

	private Date entry;
	private boolean situation;
	private double value;
	private int vacancy;
	private Date exit;
	private String id;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Ticket(String id) {
	    this.entry = new Date();
	    this.id = id;
	    this.value = 0.0;
	    this.situation = false;
	}
	
	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}

	public boolean isSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public Date getExit() {
		return exit;
	}

	public void setExit() {
		this.exit = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double calValue(Date entry, Date exit) {
		long timeVacancy = exit.getTime() - entry.getTime();

		double hours = timeVacancy / 3600000.0;

		if (hours <= 1) {
			this.value = 15;
		}

		else if (hours <= 2 && hours > 1) {
			this.value = 25;
		}

		else if (hours <= 3 && hours > 2) {
			this.value = 35;
		}

		else if (hours <= 4 && hours > 3) {
			this.value = 45;
		}

		else {
			this.value = 60;
		}

		return this.value;
	}

	public String toString() {
		return "Ticket \nEntry: " + formatter.format(this.entry) + "\nVacancy: " + (this.vacancy + 1) + "\nPlate: "
				+ this.id;
	}

}
