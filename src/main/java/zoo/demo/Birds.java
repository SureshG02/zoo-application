package zoo.demo;

import java.util.List;
import java.util.Objects;

public class Birds extends Animal{
	private String wingSpan;

	public Birds(String name, String favouriteFood, String wingSpan) {
		super(name, favouriteFood);
		this.wingSpan = wingSpan;
	}

	public String getWingSpan() {
		return wingSpan;
	}

	public void setWingSpan(String wingSpan) {
		this.wingSpan = wingSpan;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Birds birds = (Birds) o;
		return Objects.equals(wingSpan, birds.wingSpan);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), wingSpan);
	}
}