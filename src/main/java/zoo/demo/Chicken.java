package zoo.demo;

import java.util.List;
import java.util.Objects;

public class Chicken extends Birds {
	private boolean isBroiler;

	public Chicken(String name, String favouriteFood, String wingSpan, boolean isBroiler) {
		super(name, favouriteFood, wingSpan);
		this.isBroiler = isBroiler;
	}

	public boolean isBroiler() {
		return isBroiler;
	}

	public void setBroiler(boolean broiler) {
		isBroiler = broiler;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Chicken chicken = (Chicken) o;
		return isBroiler == chicken.isBroiler;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), isBroiler);
	}
}
