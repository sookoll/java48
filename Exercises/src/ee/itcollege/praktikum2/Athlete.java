package ee.itcollege.praktikum2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Athlete implements Comparable<Athlete>, Serializable {

//	private static final long serialVersionUID = 1L;
	private String name;
	private Double result;

	public Athlete(String name, Double result) {
		super();
		this.name = name;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	@Override
	public int compareTo(Athlete other) {
		//return result.compareTo(other.getResult());
		// desc
		return -result.compareTo(other.getResult());
	}
	
	@Override
	public String toString() {
		return String.format("%6.2f %s", result, name);
	}

}
